package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteToExcelFile {
    public static void main(String[] args) {
        try {
            //we need to read the data first to find how many rows of data we have
            File fileObj = new File("/Users/avikkhadka/Desktop/17AugExam/ZorbaFileOperation/src/main/resources/employee.properties");
            Properties propertiesObj = new Properties();
            FileInputStream fileInputStreamObj = new FileInputStream(fileObj);
            propertiesObj.load(fileInputStreamObj);
            fileInputStreamObj.close();


            File excelFileObj = new File("/Users/avikkhadka/Desktop/17AugExam/ZorbaFileOperation/src/main/resources/employee.xlsx");
            FileInputStream excelFis = new FileInputStream(excelFileObj);
            XSSFWorkbook workbook = new XSSFWorkbook(excelFis);
            XSSFSheet sheetObj = workbook.getSheetAt(0);
            excelFis.close();

            //we need to find the last data to append the new data
            int lastRowNum = sheetObj.getLastRowNum();
            int maxEmpId = 0;
            for (int i = 1; i <= lastRowNum; i++) {
                Row row = sheetObj.getRow(i);
                if (row != null && row.getCell(0) != null) {
                    int id = (int) row.getCell(0).getNumericCellValue();
                    if (id > maxEmpId) maxEmpId = id;
                }
            }
            int newEmpId = maxEmpId + 1;

            //now we will add the data
            Row newRow = sheetObj.createRow(lastRowNum + 1);
            newRow.createCell(0).setCellValue(newEmpId);
            newRow.createCell(1).setCellValue(propertiesObj.getProperty("name"));
            newRow.createCell(2).setCellValue(propertiesObj.getProperty("address"));
            newRow.createCell(3).setCellValue(Double.parseDouble(propertiesObj.getProperty("salary")));
            newRow.createCell(4).setCellValue(propertiesObj.getProperty("mobile"));
            newRow.createCell(5).setCellValue(propertiesObj.getProperty("department"));
            newRow.createCell(6).setCellValue(propertiesObj.getProperty("dateOfJoining"));
            newRow.createCell(7).setCellValue(propertiesObj.getProperty("policy_id"));

            //saving the data
            FileOutputStream fileOutputStreamObj = new FileOutputStream(excelFileObj);
            workbook.write(fileOutputStreamObj);
            fileOutputStreamObj.close();
            workbook.close();

            System.out.println("Employee data saved successfully = " + newEmpId);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
