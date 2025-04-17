package Pages;

import Utilis.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class HomePage {

    WebDriver webDriver;

    public HomePage(WebDriver driver)
    {
        webDriver = driver;
    }

    public HomePage validateThatTheHomePageDisplayed()
    {
        boolean isDisplayed = WaitUtil.waitToTheElement(webDriver ,By.xpath("//span[text()='Outlook']"))
                .isDisplayed();

        Assert.assertTrue(isDisplayed);

        return this;
    }

    public HomePage clickNewMailButton()
    {
        WaitUtil.waitToTheElement(webDriver ,By.xpath("//button[@aria-label='New mail']"))
                .click();

        return this;
    }

    public HomePage enterMailTo()
    {
        WaitUtil.waitToTheElement(webDriver ,By.xpath("//div[@aria-label='To']"))
                .sendKeys("islam.hassan@vodafone.com");

        return this;
    }

    public HomePage enterMailSubject()
    {
        webDriver.findElement(By.xpath("//input[@aria-label='Add a subject']"))
                .sendKeys("Automation Task");

        return this;
    }

    public HomePage clickInsertButton()
    {
        webDriver.findElement(By.xpath("//button[.//span[text()='Insert']]"))
                .click();

        return this;
    }

    public HomePage addAttachment()
    {
        WaitUtil.waitToTheElement(webDriver , By.xpath("//button[contains(text(), 'Attach') or contains(@aria-label, 'Attach')]"))
                .click();

        return this;
    }

    public HomePage clickBrowseThisComputer()
    {
        WaitUtil.waitToTheElement(webDriver , By.xpath("//button[@aria-label='Browse this computer']"))
                .click();
        return this;
    }

    public HomePage attachTheFile() {

        try {
            Robot robot = new Robot();
            StringSelection filePath = new StringSelection("C:\\Users\\yraga\\Downloads\\TaskData.xlsx");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
            robot.delay(3000);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            WaitUtil.waitToTheElement(webDriver , By.xpath("//div[contains(text(), 'TaskData.xlsx')]"))
                    .isDisplayed();

        }catch (Exception e)
        {
            Assert.fail();
        }

        return this;
    }

    public HomePage clickSendButton()
    {
        webDriver.findElement(By.xpath("//button[@aria-label='Send']"))
                .click();

        return this;
    }

    public HomePage clickSentItemsButton()
    {
        webDriver.findElement(By.xpath("//span[text()='Sent Items']\n"))
                .click();

        return this;
    }

    public void validateThatThaMailSentSuccessfully()
    {
        boolean isMailDisplayed = WaitUtil.waitToTheElement(webDriver , By.xpath("//*[contains(text(), 'Automation Task')]\n"))
                        .isDisplayed();

        Assert.assertTrue(isMailDisplayed);
    }
}
