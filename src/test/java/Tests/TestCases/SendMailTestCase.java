package Tests.TestCases;

import Pages.HomePage;
import Pages.OutLookWelcomePage;
import Pages.SignInPage;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SendMailTestCase extends BaseTest {

    @Test
    public void sendMail()
    {
        new OutLookWelcomePage(webDriver)
                .navigateToOutLook()
                .clickSignInButton()
                .switchWindowFocus();


        new SignInPage(webDriver)
                .enterEmail()
                .clickNextButton()
                .enterPassword()
                .clickSignInButton()
                .clickYesButton();

        new HomePage(webDriver)
                .validateThatTheHomePageDisplayed()
                .clickNewMailButton()
                .enterMailTo()
                .enterMailSubject()
                .clickInsertButton()
                .addAttachment()
                .clickBrowseThisComputer()
                .attachTheFile()
                .clickSendButton()
                .clickSentItemsButton()
                .validateThatThaMailSentSuccessfully();
    }
}
