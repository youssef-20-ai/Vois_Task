package Tests;

import Utilis.BrowserFactory;
import Utilis.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver webDriver;


    @BeforeSuite
    public void loadProperties()
    {
        try {
            PropertiesManager.loadProperties();
        }catch (Exception e)
        {
            System.out.println();
            Assert.fail();
        }
    }

    @Parameters({"BrowserType"})
    @BeforeTest
    public void openBrowser(String browserType) {

        webDriver =  BrowserFactory.getDriver(browserType);
          webDriver.manage().window().maximize();

    }


    @AfterMethod
    public void closeBrowser()
    {
        webDriver.quit();
    }

}
