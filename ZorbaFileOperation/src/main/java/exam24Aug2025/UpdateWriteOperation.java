package exam24Aug2025;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateWriteOperation {
    public static void main(String[] args) {
        String filePath = "/Users/avikkhadka/Desktop/IOExams/zorba_exam_submission/ZorbaFileOperation/src/main/resources/employee.xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Create header row with original + 3 new columns
            Row header = sheet.createRow(0);
            String[] columns = {
                    "Emp Id", "Emp Name", "Emp Address", "Emp Salary",
                    "Emp Mobile", "Department", "policy_id",
                    "Manager_id", "emp_share (%)", "date_of_joining"
            };
            for (int i = 0; i < columns.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Create data row with your example values
            Row row = sheet.createRow(1);
            row.createCell(0).setCellValue(1001); // Emp Id
            row.createCell(1).setCellValue("Jhon Tracker"); // Emp Name
            row.createCell(2).setCellValue("Austin"); // Emp Address
            row.createCell(3).setCellValue(1200.93); // Emp Salary
            row.createCell(4).setCellValue("9099991212"); // Emp Mobile
            row.createCell(5).setCellValue("Finance"); // Department
            row.createCell(6).setCellValue(1001); // policy_id
            row.createCell(7).setCellValue("Null"); // Manager_id
            row.createCell(8).setCellValue(60); // emp_share (%)

            // Date of joining
            Cell dateCell = row.createCell(9);
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
            dateCell.setCellValue(new SimpleDateFormat("dd/MM/yyyy").parse("02/12/2014"));
            dateCell.setCellStyle(dateStyle);

            // Write to file
            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            fos.close();

            System.out.println("Excel file updated with 3 new columns successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
