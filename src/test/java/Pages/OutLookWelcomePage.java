package Pages;

import Utilis.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OutLookWelcomePage {

    WebDriver webDriver;

    public OutLookWelcomePage(WebDriver driver)
    {
        webDriver = driver;
    }

    public OutLookWelcomePage navigateToOutLook()
    {
        webDriver.navigate().to("https://outlook.live.com/mail/0/");

        return this;
    }

    public OutLookWelcomePage clickSignInButton()
    {
        WaitUtil.waitToTheElement(webDriver ,By.xpath("(//a[contains(text(), 'Sign in')])[2]")).click();

        return this;
    }

    public void switchWindowFocus()
    {
        webDriver.switchTo().window(webDriver.getWindowHandles().toArray()[1].toString());
    }
}
