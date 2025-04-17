import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {
    ChromeDriver driver;
    @BeforeTest
    public void startDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void assertTitle(){
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertEquals(title,"Google");
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }

}