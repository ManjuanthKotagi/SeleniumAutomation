package seleniumCode;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollUp {
    @Test()
    public void scrollUp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down to the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //scroll up to the page
        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0,0)");

    }
}
