package seleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    @Test()
    public void fileUpload() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement fileUploadButton = driver.findElement(By.id("uploadFile"));
        fileUploadButton.sendKeys("C://Users//OneDrive//Desktop//UserFile.txt");
        Thread.sleep(4000);

    }
}
