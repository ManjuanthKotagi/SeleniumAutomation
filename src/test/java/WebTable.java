import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.*;

public class WebTable {

    @Test()
    public void webTable() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        driver.manage().window().maximize();

        //Get Total Number of Rows
        int rowsCount = driver.findElements(By.xpath("//table//tr")).size();
        System.out.println("Number of Rows Are : " + rowsCount);

        //Get Total Columns
        int columnCount = driver.findElements(By.xpath("//table//tr//td//h3")).size();
        System.out.println("Number of Columns Are : " + columnCount);

        //Get All Column Text
        ArrayList<String> columnText = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String text = driver.findElement(By.xpath("(//table//tr//td//h3//strong)[" + i + "]")).getText();
            columnText.add(text);
        }

        for (int i = 0; i < columnText.size(); i++) {
            System.out.println("Column Text Are : " + columnText.get(i));
        }

        //Checked the checkbox based on the country name
        driver.findElement(By.xpath("//strong[text()='Afghanistan']//ancestor::tr//td//input")).click();

        //get the row details based on the country name
        int totalColumns = driver.findElements(By.xpath("//strong[contains(text(),'Afghanistan')]//ancestor::tr//td")).size();
        ArrayList<String> columnValues = new ArrayList<>();
        for (int i = 1; i <= totalColumns; i++) {
            columnValues.add(driver.findElement(By.xpath("//strong[contains(text(),'Afghanistan')]//ancestor::tr//td[" + i + "]")).getText());
        }

        for (int i = 0; i < columnValues.size(); i++) {
            System.out.println("Row Values Based On the Country Is " + columnValues.get(i));
        }

        //Map<String, String> countryDetails = new HashMap();

//        countryDetails.put("Country","Afghanistan");
//        countryDetails.put("Capital(s)","Kabul");
//        countryDetails.put("Currency","Afghani");
//        countryDetails.put("Primary Language(s)","Dari Persian; Pashto");
//
//        for(Map.Entry<String, String> entry : countryDetails.entrySet()) {
//            System.out.println("key " + entry.getKey() + "Value " + entry.getValue());
//        }

        List<Map<String, String>> allCountries = new ArrayList<>();
        //Map<String, String> countries = new HashMap<>();
        for (int row = 2; row <= rowsCount; row++) {
            Map<String, String> countries = new HashMap<>();
            for (int column = 2; column <= columnCount; column++) {
                String columnName = driver.findElement(By.xpath("(//table//tr//td//h3//strong)[" + column + "]")).getText();
                String columnValue = driver.findElement((By.xpath("//table//tr[" + row + "]//td[" + column + "]"))).getText();
                countries.put(columnName, columnValue);
            }
            allCountries.add(countries);
        }

        for (Map<String, String> country : allCountries) {
            System.out.println(country);
        }

        driver.close();
    }
}
