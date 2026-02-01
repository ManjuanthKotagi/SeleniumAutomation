package takingScreenshotOfFailedTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).driver;
        ScreenShotCapture screenShotCapture = new ScreenShotCapture();
        try {
            screenShotCapture.captureScreenshot(driver, result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
