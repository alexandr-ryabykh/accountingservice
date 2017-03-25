package org.mainacad.accstuffs.exporter;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.mainacad.accstuffs.model.Stuff;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XlsExporter {

    int index = 0;
    int sno = 0;

    public void exportListOfStuffs(Iterable<Stuff> stuffs) {
        HSSFWorkbook hwb = new HSSFWorkbook();

        HSSFSheet sheet = hwb.createSheet("new sheet");

        HSSFRow rowhead = sheet.createRow((short) 6);

        rowhead.createCell((short) 0).setCellValue("SNo");

        rowhead.createCell((short) 1).setCellValue("Date");

        rowhead.createCell((short) 2).setCellValue("PaymentPurpose");

        rowhead.createCell((short) 3).setCellValue("Income");

        rowhead.createCell((short) 4).setCellValue("Outcome");

        rowhead.createCell((short) 5).setCellValue("StateOfBudget");

        String filename = "d:\\f" + " test" + ".xls";


        for (Stuff s : stuffs) {
            HSSFRow row = sheet.createRow((short) index);

            row.createCell((short) 0).setCellValue(sno);

            row.createCell((short) 1).setCellValue(s.getDate().toString());

            row.createCell((short) 2).setCellValue(s.getPaymentPurpose());

            row.createCell((short) 3).setCellValue(s.getIncome());

            row.createCell((short) 4).setCellValue(s.getOutcome());

            row.createCell((short) 5).setCellValue(s.getStateOfBudget());

            index++;
            sno++;
        }
            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream(filename);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                hwb.write(fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


//        return hwb.getBytes();



    }
}
