import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtons {

    @Test()
    public void radioButtonTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");

        WebElement yesRadioButton = driver.findElement(By.xpath("//input[@value='igottwo']"));
        WebElement impressiveRadioButton = driver.findElement(By.xpath("//input[@value='igotthree']"));
        WebElement disabledRadioButton = driver.findElement(By.xpath("//input[@name='inlineRadioOptions']"));

        yesRadioButton.click();
        Assert.assertTrue(yesRadioButton.isSelected());

        impressiveRadioButton.click();
        Assert.assertTrue(impressiveRadioButton.isSelected());

        Assert.assertFalse(disabledRadioButton.isEnabled());  //by the dom structure radio button is disabled.
        driver.close();
    }
}
