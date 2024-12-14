import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowHandles2 {

    @Test()
    public void windowHandlesTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

        WebElement newWindowButton = driver.findElement(By.xpath("//button[text()='New Window']"));

        newWindowButton.click();

        Object[] allWindows = driver.getWindowHandles().toArray();

        driver.switchTo().window((String) allWindows[1]);

        Assert.assertEquals(allWindows[1], driver.getWindowHandle(), "New window is not opened and not navigated the control");

        driver.close();
    }
}
