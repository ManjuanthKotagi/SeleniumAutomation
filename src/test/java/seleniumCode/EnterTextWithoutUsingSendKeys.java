package seleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnterTextWithoutUsingSendKeys {

    @Test()
    public void enterTextWithoutUsingSendKeys() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement textBox = driver.findElement(By.id("fullname"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("arguments[0].value='Hello World';",textBox);
    }
}
