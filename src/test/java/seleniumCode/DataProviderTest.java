package seleniumCode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "loginTest")
    public void loginDataTest(String userName, String password) {
        System.out.println("UserName : " + userName);
        System.out.println("Password : " + password);
    }

    @DataProvider(name = "loginTest")
    public Object[][] loginTest() {
        Object[][] data = {
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"},
                {"user4", "password4"}
        };
        return data;
    }
}
