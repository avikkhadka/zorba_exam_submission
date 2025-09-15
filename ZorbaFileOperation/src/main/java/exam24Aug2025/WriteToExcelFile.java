package exam24Aug2025;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteToExcelFile {
    public static void main(String[] args) {
        String filePath = "/Users/avikkhadka/Desktop/IOExams/zorba_exam_submission/ZorbaFileOperation/src/main/resources/employee.xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Create header row
            Row header = sheet.createRow(0);
            String[] columns = {
                    "Emp Id", "Emp Name", "Emp Address", "Emp Salary",
                    "Emp Mobile", "Department", "policy_id",
                    "Manager_id", "emp_share (%)", "date_of_joining"
            };
            for (int i = 0; i < columns.length; i++) {
                header.createCell(i).setCellValue(columns[i]);
            }

            // Employee data: each row contains original + new columns
            Object[][] employees = {
                    {1001, "Jhon Tracker", "Austin", 1200.93, "9099991212", "Finance", 1001, "Null", 60, "02/12/2014"},
                    {1002, "Bhaba George", "Texas", 2312.21, "7809991212", "HR", 1003, "1001", 20, "12/20/2024"},
                    {1003, "James Adams", "Florida", 1220.12, "9879799670", "Finance", 1004, "1002", 15, "06/16/2010"},
                    {1004, "Shiv Sharma", "London", 1345.21, "8879799670", "Engg", 1002, "1004", 30, "08/18/2025"},
                    {1005, "David Goon", "France", 1890.98, "6766676670", "Science", 1003, "1001", 15, "07/15/2012"},

            };

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            int rowNum = 1;

            for (Object[] emp : employees) {
                Row row = sheet.createRow(rowNum++);
                // Original 7 columns
                for (int i = 0; i < 7; i++) {
                    if (emp[i] instanceof String)
                        row.createCell(i).setCellValue((String) emp[i]);
                    else if (emp[i] instanceof Double)
                        row.createCell(i).setCellValue((Double) emp[i]);
                    else if (emp[i] instanceof Integer)
                        row.createCell(i).setCellValue((Integer) emp[i]);
                }

                // New columns
                row.createCell(7).setCellValue((String) emp[7]);
                row.createCell(8).setCellValue((Integer) emp[8]);

                // Date of joining
                Cell dateCell = row.createCell(9);
                CreationHelper createHelper = workbook.getCreationHelper();
                CellStyle dateStyle = workbook.createCellStyle();
                dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("MM/dd/yyyy"));
                Date doj = sdf.parse((String) emp[9]);
                dateCell.setCellValue(doj);
                dateCell.setCellStyle(dateStyle);
            }

            // Write to Excel file
            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            fos.close();

            System.out.println("Excel file created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
