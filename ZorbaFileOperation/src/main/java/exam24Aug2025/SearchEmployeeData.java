package exam24Aug2025;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SearchEmployeeData {
    public static void main(String[] args) {
        // File path set as per your request
        String filePath = "/Users/avikkhadka/Desktop/IOExams/zorba_exam_submission/ZorbaFileOperation/src/main/resources/employee.xlsx";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int empIdInput = sc.nextInt();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // for date formatting

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet empSheet = workbook.getSheetAt(0);
            boolean found = false;

            // Search employee in Sheet1
            for (int i = 1; i <= empSheet.getLastRowNum(); i++) {
                Row row = empSheet.getRow(i);
                if (row != null) {
                    Cell idCell = row.getCell(0);
                    if (idCell != null && (int) idCell.getNumericCellValue() == empIdInput) {
                        found = true;
                        System.out.println("Employee Details:");
                        System.out.println("Emp Id: " + (int) row.getCell(0).getNumericCellValue());
                        System.out.println("Emp Name: " + row.getCell(1).getStringCellValue());
                        System.out.println("Emp Address: " + row.getCell(2).getStringCellValue());
                        System.out.println("Emp Salary: " + row.getCell(3).getNumericCellValue());
                        System.out.println("Emp Mobile: " + row.getCell(4).getStringCellValue());
                        System.out.println("Department: " + row.getCell(5).getStringCellValue());
                        System.out.println("Policy ID: " + (int) row.getCell(6).getNumericCellValue());
                        System.out.println("Manager ID: " + row.getCell(7).getStringCellValue());
                        System.out.println("Emp Share (%): " + (int) row.getCell(8).getNumericCellValue());
                        System.out.println("Date of Joining: " + sdf.format(row.getCell(9).getDateCellValue()));
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Employee ID not found.");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        sc.close();
    }
}
