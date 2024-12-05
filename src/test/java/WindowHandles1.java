import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandles1 {

    @Test()
    public void windowHandles() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
        String windowsAddress = driver.getWindowHandle();       //getting the current window address
        System.out.println("Current Window Address Is : " + windowsAddress);

        Set<String> windows = driver.getWindowHandles();   //getting all the window address and storing it in Set
        System.out.println("Set Representation : " + windows);

        String StringFormatWindowAddress = driver.getWindowHandles().toString();   //By calling .toString(), you're converting the entire Set<String> to a single String, which will be a textual representation of the set's contents.
        System.out.println("String Representation : " + StringFormatWindowAddress);

        driver.findElement(By.xpath("//a[text()='Open new window']")).click();
        Set<String> allWindowAddress = driver.getWindowHandles();

        //printing all window address
        for (String windowsAllAddress : allWindowAddress) {
            System.out.println("All windows : " + windowsAllAddress);
        }

        Object[] windowsToSwitch = driver.getWindowHandles().toArray();

        //switching to new window
        driver.switchTo().window((String) windowsToSwitch[1]);
        Assert.assertEquals(driver.getTitle(), "Simple Page", "You are not in the page");
        Assert.assertEquals(driver.getWindowHandle().toString(), windowsToSwitch[1], "Both are different");
        System.out.println(driver.getWindowHandle().toString());
        driver.close();
    }
}
