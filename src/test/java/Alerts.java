import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts {

    @Test()
    public void alertsTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");

        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Alert']"));
        WebElement confirmBox = driver.findElement(By.xpath("//button[text()='Click Me' and @onclick='myDesk()']"));
        WebElement promptBox = driver.findElement(By.xpath("//button[text()='Click Me' and @onclick='myPromp()']"));

        //alert to accept(clicking on Ok button)
        alertButton.click();
        driver.switchTo().alert().accept();

        confirmBox.click();
        driver.switchTo().alert().dismiss(); //pressing cancel button

        confirmBox.click();
        driver.switchTo().alert().accept(); //pressing cancel button

        promptBox.click();
        driver.switchTo().alert().sendKeys("Hi");
        driver.switchTo().alert().accept();
    }
}
