package org.mainacad.accstuffs.exporter;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.mainacad.db.register.domain.Stuff;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
}
