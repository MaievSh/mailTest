package mailTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import mailPages.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailMessageTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailMessageTest.class);
    private final String user = VerificationMail.getUser("properties", "user");
    private final String password = VerificationMail.getPassword("properties", "password");

    @BeforeClass
    public void logIn() {
        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.open();
        Assert.assertTrue(logInPage.isPageOpened(), "Home page is not opened");
        VerificationMail verification = new VerificationMail(getDriver());
        verification.setDBSignificance("properties", "user", user, "password", password);
        String loginProp = VerificationMail.getUser("properties", "user");
        String passwordProp = VerificationMail.getPassword("properties", "password");
        logInPage.inputEmail(loginProp);
        logInPage.inputPasswordButton();
        logInPage.inputPassword(passwordProp);
        logInPage.LogInButtonClick();
        Assert.assertTrue(logInPage.getIncomingMessageBar().isElementPresent(), "User is not logged in!");
    }

    @BeforeMethod
    public void sendMessageToYourself() {
        IncomingMessagePage messagePage = new IncomingMessagePage(getDriver());
        InsideMessagePage insideMessagePage = new InsideMessagePage(getDriver());
        messagePage.setWriteMessageBtn();
        messagePage.setInputFields();
        messagePage.setChooseAddressee();
        messagePage.setAddButton();
        messagePage.setInputMessage("This is test message!");
        messagePage.setSendBtn();
        messagePage.setCloseFrame();
        messagePage.setMessageForMyself();
        Assert.assertTrue(insideMessagePage.getMessagePreview().isElementWithTextPresent("This is test message!"), "Message is not send!");
    }

    @Test(enabled = true)
    public void deleteMessage() {
        InsideMessagePage insideMessagePage = new InsideMessagePage(getDriver());
        MessageForMyselfPage messageForMyselfPage = new MessageForMyselfPage(getDriver());
        insideMessagePage.getMessagePreview().click();
        insideMessagePage.setDeleteMessageBtn();
        Assert.assertTrue(messageForMyselfPage.getAfterDelete().isElementWithTextPresent("В папке нет писем."), "Message is not delete!");

    }

    @Test(enabled = true)
    public void replyOnMessage() {
        InsideMessagePage insideMessagePage = new InsideMessagePage(getDriver());
        IncomingMessagePage messagePage = new IncomingMessagePage(getDriver());
        insideMessagePage.getMessagePreview().click();
        insideMessagePage.replyMessageBtn();
        messagePage.setInputMessage("This is test reply message!");
        messagePage.setSendBtn();
        messagePage.setCloseFrame();
        Assert.assertTrue(insideMessagePage.getReplyMessagePreview().isElementWithTextPresent("This is test reply message!"), "Message is not send!");
    }

    @Test(enabled = true)
    public void readAndMarkLikeUnreadMessage() {
        IncomingMessagePage messagePage = new IncomingMessagePage(getDriver());
        InsideMessagePage insideMessagePage = new InsideMessagePage(getDriver());
        MessageForMyselfPage messageForMyselfPage = new MessageForMyselfPage(getDriver());
        messagePage.setMessageForMyself();
        insideMessagePage.getMessagePreview().click();
        insideMessagePage.setThreeDotsBtn();
        insideMessagePage.setMarkUnreadBtn();
        messagePage.setMessageForMyself();
        Assert.assertTrue(messageForMyselfPage.getUnreadDot().isElementPresent(), "Message is not marked like unread!");
    }

    @Test(enabled = true)
    public void translateMessage() {
        InsideMessagePage insideMessagePage = new InsideMessagePage(getDriver());
        insideMessagePage.getMessagePreview().click();
        insideMessagePage.setThreeDotsBtn();
        insideMessagePage.setMoreBtn();
        Assert.assertTrue(insideMessagePage.getTranslatePreview().isElementPresent(), "Message is not translated!");
    }

    @Test(enabled = true)
    public void markLikeSpam() {
        InsideMessagePage insideMessagePage = new InsideMessagePage(getDriver());
        insideMessagePage.getMessagePreview().click();
        insideMessagePage.setThreeDotsInMessage();
        insideMessagePage.setSpam();
        insideMessagePage.setSpamPageBtn();
        Assert.assertTrue(insideMessagePage.getReplyMessagePreview().isElementWithTextPresent("This is test message!"), "Message is not send!");
    }
}