package readingDataFromExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataFromExcel {

    @Test()
    public void writeData() throws IOException {

        String[][] data = {
                {"Username", "Password"},
                {"admin", "admin123"},
                {"user1", "pass123"},
                {"user2", "admin123"},
                {"user3", "pass123"}
        };

        String filePath = "src/test/java/readingDataFromExcel/UserLoginData.xlsx";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        int totalRows = data.length;
        int totalColumn = data[0].length;

        for (int i = 0; i < totalRows; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < totalColumn; j++) {
                // Create cells inside column loop
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fos.close();
        System.out.println("Data is written successfully");
    }
}