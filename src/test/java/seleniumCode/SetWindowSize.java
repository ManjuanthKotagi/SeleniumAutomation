package seleniumCode;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SetWindowSize {

    @Test()
    public void setWindowSize() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.get("https://www.google.com");
    }
}
