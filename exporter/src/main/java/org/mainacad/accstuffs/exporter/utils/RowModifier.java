package org.mainacad.accstuffs.exporter.utils;

import org.apache.poi.ss.usermodel.Row;

public class RowModifier {

    private Row row;
    private int index;

    public RowModifier(Row row) {
        this.row = row;
        this.index = 0;
    }

    public void addCell(String value) {
        row.createCell(index).setCellValue(value);
        index++;
    }
    
    public void addCell(double value) {
        row.createCell(index).setCellValue(value);
        index++;
    }
    
    public void resetIndex() {
        index = 0;
    }
}