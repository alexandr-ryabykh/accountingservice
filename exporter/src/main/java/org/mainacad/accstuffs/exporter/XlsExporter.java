package org.mainacad.accstuffs.exporter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.mainacad.db.register.domain.Register;
import org.mainacad.db.register.domain.Student;
import org.mainacad.db.register.domain.Stuff;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class XlsExporter {

    int index = 1;

    public byte[] exportListOfStuffs(Iterable<Stuff> stuffs) {
        HSSFWorkbook hwb = new HSSFWorkbook();

        HSSFSheet sheet = hwb.createSheet("new sheet");

        HSSFRow rowhead = sheet.createRow(0);

        rowhead.createCell(0).setCellValue("SNo");

        rowhead.createCell(1).setCellValue("Date");

        rowhead.createCell(2).setCellValue("PaymentPurpose");

        rowhead.createCell(3).setCellValue("Income");

        rowhead.createCell(4).setCellValue("Outcome");

        rowhead.createCell(5).setCellValue("StateOfBudget");


        for (Stuff s : stuffs) {
            HSSFRow row = sheet.createRow(index);
            int serialNumber = index - 1;

            row.createCell(0).setCellValue(serialNumber);

            row.createCell(1).setCellValue(s.getDate().toString());

            row.createCell(2).setCellValue(s.getPaymentPurpose());

            row.createCell(3).setCellValue(s.getIncome());

            row.createCell(4).setCellValue(s.getOutcome());

            row.createCell(5).setCellValue(s.getStateOfBudget());

            index++;
        }

        try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            hwb.write(bos);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error creating Excel file", e);
        }
    }

    public byte[] exportRegister(Register register){
        HSSFWorkbook hwb = new HSSFWorkbook();

        HSSFSheet sheet = hwb.createSheet("new sheet");

        CellStyle style = hwb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle style1 = hwb.createCellStyle();
        style1.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        HSSFRow rowhead = sheet.createRow(0);

        HSSFCell cell0= rowhead.createCell(0);

        cell0.setCellValue("Тренер: " + register.getGroups().getTeacher().getFirstName()+" "+
                register.getGroups().getTeacher().getLastName());

        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

        cell0.setCellStyle(style);

        HSSFRow row = sheet.createRow(1);

        HSSFCell cell1=row.createCell(0);
        cell1.setCellValue("Имя");
        cell1.setCellStyle(style1);
        HSSFCell cell2=row.createCell(1);
        cell2.setCellValue("Фамилия");
        cell2.setCellStyle(style1);
        HSSFCell cell3=row.createCell(2);
        cell3.setCellValue("эл. почта");
        cell3.setCellStyle(style1);
        HSSFCell cell4=row.createCell(3);
        cell4.setCellValue("Телефон");
        cell4.setCellStyle(style1);

        int i = 4;
        for (LocalDate date:register.dateList()) {
            row.createCell(i++).setCellValue(date.toString());
        }
        i=2;
        for(Student student:register.getGroups().getStudents()){
            HSSFRow sheetRow = sheet.createRow(i++);
            sheetRow.createCell(0).setCellValue(student.getFirstName());
            sheetRow.createCell(1).setCellValue(student.getLastName());
            sheetRow.createCell(2).setCellValue(student.getEMail());
            sheetRow.createCell(3).setCellValue(student.getPhoneNumber());
        }

        HSSFRow hoursRow = sheet.createRow(i+1);
        hoursRow.createCell(0).setCellValue("Кол-во часов: ");

        for(int j = 0;j<row.getLastCellNum();j++) {
            sheet.autoSizeColumn(j);
            if(j>3){
                hoursRow.createCell(j).setCellValue(register.getGroups().getTeacher().getWorkHours());
            }
        }
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            hwb.write(bos);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error creating Excel file", e);
        }
    }
}
