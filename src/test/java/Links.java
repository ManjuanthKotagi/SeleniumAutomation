import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class Links {

    @Test()
    public void linkTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/broken-link.php");
        //WebElement validLink = driver.findElement(By.xpath("//a[text()='Click Here for Valid Link']"));
        WebElement brokenLink = driver.findElement(By.xpath("//a[text()='Click Here for Broken Link']"));

        //validLink.click();

        brokenLink.click();
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Broken Link - Status 500"));
        driver.close();
    }
}
