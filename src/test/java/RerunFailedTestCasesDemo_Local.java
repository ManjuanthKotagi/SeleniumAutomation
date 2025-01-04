import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//This is for method levels and not working for global level
public class RerunFailedTestCasesDemo_Local {

    @Test(retryAnalyzer = RerunFailedTests_Local.class)
    public void textBoxTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");

        WebElement fullNameTextBox = driver.findElement(By.id("fullnam"));
        WebElement emailTextBox = driver.findElement(By.id("email"));
        WebElement addressTextBox = driver.findElement(By.id("address"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.cssSelector(".btn.btn-primary"));

        fullNameTextBox.sendKeys("Manju");
        emailTextBox.sendKeys("manju@gmail.com");
        addressTextBox.sendKeys("Bangalore");
        password.sendKeys("password");
        submitButton.click();
        driver.close();
    }
}