import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


//This will work for method levels and for particular test, not for global(Ex: RerinFailedTestCasesDemo)
public class RerunFailedTests_Local implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxRetryCount) {
            retryCount ++;
            return true;
        }
        return false;
    }
}
