import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionClass {

    @Test()
    public void buttonTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");
        WebElement clickMeButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

        //moving to the particular element and clicking the button
        Actions actions = new Actions(driver);
        actions.moveToElement(clickMeButton).click(clickMeButton).build().perform();
        driver.close();
    }
}
