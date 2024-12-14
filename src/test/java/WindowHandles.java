import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandles {

    @Test()
    public void windowHandleTest() {
        //Program to handle new tab
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

        WebElement newTabButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

        newTabButton.click();

        Object[] allTabs = driver.getWindowHandles().toArray();

        driver.switchTo().window((String) allTabs[1]);

        Assert.assertEquals(allTabs[1], driver.getWindowHandle(), "Tabs are different and not navigated to new tab");

        driver.close();
    }
}
