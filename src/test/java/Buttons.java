import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Buttons {

    @Test()
    public void buttonTest() {
        String expectedClickMeMessage = "You have done a dynamic click";
        String expectedDoubleClickMessage = "You have Double clicked";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");
        WebElement clickMeButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        WebElement rightClickMeButton = driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
        WebElement doubleClickMeButton = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        WebElement clickMeButtonMessage = driver.findElement(By.xpath("//div[@id='welcomeDiv']"));
        WebElement doubleClickedMessage = driver.findElement(By.xpath("//p[@id='doublec']"));

        //moving to the particular element and clicking the button
        Actions actions = new Actions(driver);
        actions.moveToElement(clickMeButton).click(clickMeButton).build().perform();  //moveToElement is used for moving to element
        String actualClickMeMessage = clickMeButtonMessage.getText();
        Assert.assertEquals(actualClickMeMessage, expectedClickMeMessage, "Click me button is not clicked");

        actions.moveToElement(rightClickMeButton).doubleClick(rightClickMeButton).perform();

        actions.moveToElement(doubleClickMeButton).doubleClick(doubleClickMeButton).perform();
        String actualDoubleClickMessage = doubleClickedMessage.getText();
        Assert.assertEquals(actualDoubleClickMessage, expectedDoubleClickMessage, "Double click button is not clicked");
        driver.close();
    }
}
