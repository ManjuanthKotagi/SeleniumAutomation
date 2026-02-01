package seleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RightClick {

    @Test()
    public void rightClick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        WebElement nameTextBox = driver.findElement(By.id("name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(nameTextBox).contextClick(nameTextBox).build().perform();
        Thread.sleep(4000);
        driver.close();
    }
}
