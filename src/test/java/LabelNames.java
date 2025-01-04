import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LabelNames {

    @Test()
    public void getTheLabelText() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");

        int totalElements = driver.findElements(By.xpath("//div[@id='nav-xshop']//a")).size();

        for (int i = 1; i < totalElements; i++) {
            String labelText = driver.findElement(By.xpath("(//div[@id='nav-xshop']//a)[" +(i) + "]")).getText();
            System.out.println("Label Text is : " + labelText);
        }
        driver.close();
    }
}
