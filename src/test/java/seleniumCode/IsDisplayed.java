package seleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IsDisplayed {

    @Test
    public void isDisplayed() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        Boolean submitBtnStatus = submitBtn.isDisplayed();
        System.out.println(submitBtnStatus);
    }
}
