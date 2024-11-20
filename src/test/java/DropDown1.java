import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DropDown1 {

    //This is only for single select dropdown, and can't be supported multiselect dropdowns
    @Test
    public void testMethod() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

        Select dropdown = new Select(driver.findElement(By.xpath("//select")));
        List<WebElement> dropdownItems = dropdown.getOptions();
        List<String> countries = new ArrayList<>();

        for(int i=0;i<dropdownItems.size();i++) {
            System.out.println(dropdownItems.get(i).getText());
            countries.add(dropdownItems.get(i).getText());
        }
        System.out.println(countries.size());
        Assert.assertTrue(countries.contains("India"), "Countries doesn't contain India" );

        String selectedCountry = dropdown.getFirstSelectedOption().getText();
        System.out.println("First Selected Option is " + selectedCountry);

        dropdown.selectByValue("IND");
        dropdown.selectByIndex(1);
        dropdown.selectByVisibleText("Indonesia");
    }
}
