package org.mainacad.accstuffs.exporter;

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
import org.apache.poi.ss.usermodel.Row;
import org.mainacad.accstuffs.exporter.utils.RowModifier;
import org.mainacad.db.register.domain.Teacher;

public class XlsExporter {

    private static final int HEADER = 0;

    int index = 1;

    public byte[] exportListOfStuffs(Iterable<Stuff> stuffs) {
        HSSFWorkbook hwb = new HSSFWorkbook();
        HSSFSheet sheet = hwb.createSheet("new sheet");
        createHeader(sheet, "SNo", "Date", "PaymentPurpose", "Income", "Outcome", "StateOfBudget");

        for (Stuff s : stuffs) {
            RowModifier row = new RowModifier(sheet.createRow(index));
            int serialNumber = index - 1;

            row.addCell(serialNumber);
            row.addCell(s.getDate().toString());
            row.addCell(s.getPaymentPurpose());
            row.addCell(s.getIncome());
            row.addCell(s.getOutcome());
            row.addCell(s.getStateOfBudget());
            row.resetIndex();
            index++;
        }

        return toBytes(hwb);        
    }

    public byte[] exportRegister(Register register) {
        HSSFWorkbook hwb = new HSSFWorkbook();
        HSSFSheet sheet = hwb.createSheet("new sheet");

        CellStyle yellowStyle = hwb.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle greenStyle = hwb.createCellStyle();
        greenStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
        greenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Teacher teacher = register.getGroups().getTeacher();
        String trenerString = "Тренер: " + teacher.getFirstName() + " "
                + teacher.getLastName();        
        Row head = createHeader(sheet, trenerString);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
        head.getCell(HEADER).setCellStyle(yellowStyle);

        Row firstRow = createRow(sheet, 1, "Имя", "Фамилия", "эл. почта", "Телефон");
        firstRow.cellIterator().forEachRemaining(cell -> cell.setCellStyle(greenStyle));

        int i = 4;
        for (LocalDate date : register.dateList()) {
            firstRow.createCell(i++).setCellValue(date.toString());
        }
        i = 2;
        for (Student student : register.getGroups().getStudents()) {
            HSSFRow sheetRow = sheet.createRow(i++);
            sheetRow.createCell(0).setCellValue(student.getFirstName());
            sheetRow.createCell(1).setCellValue(student.getLastName());
            sheetRow.createCell(2).setCellValue(student.getEMail());
            sheetRow.createCell(3).setCellValue(student.getPhoneNumber());
        }

        HSSFRow hoursRow = sheet.createRow(i + 1);
        hoursRow.createCell(0).setCellValue("Кол-во часов: ");

        for (int j = 0; j < firstRow.getLastCellNum(); j++) {
            sheet.autoSizeColumn(j);
            if (j > 3) {
                hoursRow.createCell(j).setCellValue(register.getGroups().getTeacher().getWorkHours());
            }
        }
        return toBytes(hwb);
    }

    private Row createHeader(HSSFSheet sheet, String... headerNames) {
        return createRow(sheet, HEADER, headerNames);
    }
    
    private Row createRow(HSSFSheet sheet, int index, String... headerNames) {
        Row row = sheet.createRow(index);
        RowModifier rowhead = new RowModifier(row);
        for (String headerName : headerNames) {
            rowhead.addCell(headerName);
        }
        return row;
    }

    private byte[] toBytes(HSSFWorkbook workbook) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            workbook.write(bos);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error creating Excel file", e);
        }
    }
}
