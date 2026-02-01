package readingFromPropFiles;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReading {

    @Test()
    public void getPropertyFileData() throws IOException {
        Properties properties = new Properties();
        FileInputStream files = new FileInputStream("src/test/java/readingFromPropFiles/config.properties");
        properties.load(files);

        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println(browser);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }
}