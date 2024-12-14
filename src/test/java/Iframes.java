import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Iframes {

    @Test()
    public void IframeTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");

        WebElement firstFrame = driver.findElement(By.xpath("(//iframe[@src='new-tab-sample.php'])[1]"));

        //driver.switchTo().frame(firstFrame) ;
        driver.switchTo().frame(0);
        String text = driver.findElement(By.tagName("h1")).getText() ;
        System.out.println(" Text is: " + text);
        driver.close();
    }
}
