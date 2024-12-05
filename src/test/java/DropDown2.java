import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown2 {

    @Test
    public void dropDownSelect() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

        //Select dropdown = new Select(driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[3]")));
        //dropdown.selectByValue("Green");

        WebElement scroll = driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[3]"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);

        driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[3]")).click();
        driver.close();
    }
}
