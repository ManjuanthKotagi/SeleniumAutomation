package seleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class MakeMyTrip {

    @Test()
    public void makeMyTrip() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
    }
}
