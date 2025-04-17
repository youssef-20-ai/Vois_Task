package Pages;

import Utilis.PropertiesManager;
import Utilis.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class SignInPage {

    //hello

    WebDriver webDriver;

    public SignInPage(WebDriver driver)
    {
        webDriver = driver;
    }

    public SignInPage enterEmail()
    {
        WaitUtil.waitToTheElement(webDriver ,By.xpath("//input[@type='email']"))
                .sendKeys(PropertiesManager.getProperty("username"));

        return this;
    }

    public SignInPage enterPassword()
    {
        WaitUtil.waitToTheElement(webDriver ,By.xpath("//input[@type='password']"))
                .sendKeys(PropertiesManager.getProperty("password"));

        return this;
    }

    public SignInPage clickNextButton()
    {
        webDriver.findElement(By.xpath("//button[text()='Next']"))
                .click();

        return this;
    }

    public SignInPage clickSignInButton()
    {
        webDriver.findElement(By.xpath("//button[text()='Sign in']"))
                .click();

        return this;
    }

    public void clickYesButton()
    {
        WaitUtil.waitToTheElement(webDriver ,By.xpath("//button[text()='Yes']"))
                .click();
    }
}
