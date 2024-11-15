package Utilis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(String browserType)
    {
        switch (browserType)
        {
            case "Chrome" : driver.set(new ChromeDriver(getChromeOptions())); break;
            case "Edge" : driver.set(new EdgeDriver()); break;
            case "FireFox" : driver.set(new FirefoxDriver()); break;
        }
        return driver.get();
    }


    public static ChromeOptions getChromeOptions()
    {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("profile-directory=Default");

        return chromeOptions;
    }
}
