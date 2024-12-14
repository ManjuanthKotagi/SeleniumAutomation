import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBox {

    @Test()
    public void checkBoxTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");

        WebElement mainLevel1CheckBox = driver.findElement(By.id("c_bs_1"));
        WebElement mainLevel2CheckBox = driver.findElement(By.id("c_bs_2"));

        mainLevel1CheckBox.click();
        mainLevel2CheckBox.click();

        Assert.assertTrue(mainLevel1CheckBox.isSelected());
        Assert.assertTrue(mainLevel2CheckBox.isSelected());

        driver.close();
    }
}
