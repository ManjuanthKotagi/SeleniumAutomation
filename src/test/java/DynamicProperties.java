import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicProperties {

    @Test()
    public void dynamicPropTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/dynamic-prop.php");

        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));

        Assert.assertFalse(driver.findElement(By.id("visibleAfter")).isDisplayed());
        colorChangeButton.click();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(6));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        Assert.assertTrue(driver.findElement(By.id("visibleAfter")).isDisplayed());
        driver.close();
    }
}
