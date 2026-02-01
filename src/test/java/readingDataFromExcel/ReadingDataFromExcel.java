package readingDataFromExcel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingDataFromExcel {
    @Test()
    public void readData() throws IOException {
        String filePath = "src/test/java/readingDataFromExcel/UserLoginData.xlsx";
        String sheetName = "Sheet1";

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int totalRows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getLastCellNum();
        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < totalRows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                String cellValue = formatter.formatCellValue(cell);
                System.out.println(cellValue);
            }
        }
    }
}