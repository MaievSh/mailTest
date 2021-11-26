package mailPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncomingMessagePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(IncomingMessagePage.class);

    @FindBy(xpath = "//span[@class='compose-button__txt'][contains(text(),'Написать письмо')]")
    private ExtendedWebElement writeMessageBtn;
    @FindBy(xpath = "//div[@class='text--1czzf'][contains(text(),'Кому')]")
    private ExtendedWebElement inputFieldsAddressee;
    @FindBy(xpath = "//div[@data-test-id='addressbook-item-avatar']")
    private ExtendedWebElement chooseAddressee;
    @FindBy(xpath = "//button[@data-test-id='compose-mode-add']")
    private ExtendedWebElement addButton;
    @FindBy(xpath = "//div[@role='textbox']")
    private ExtendedWebElement inputMessage;
    @FindBy(xpath = "//span[@title='Отправить']")
    private ExtendedWebElement sendBtn;
    @FindBy(xpath = "//span[@title='Закрыть']")
    private ExtendedWebElement closeFrame;
    @FindBy(xpath = "//div[@class='nav__folder-name__txt'][contains(text(),'Письма себе')]")
    private ExtendedWebElement messageForMyself;
    @FindBy(xpath = "//span[@class='ll-sp__normal']")
    private ExtendedWebElement messagePreview;


    public IncomingMessagePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void setWriteMessageBtn() {
        writeMessageBtn.click();
    }

    public void setInputFields() {
        inputFieldsAddressee.click();
    }

    public void setChooseAddressee() {
        chooseAddressee.click();
    }

    public void setAddButton() {
        addButton.click();
    }

    public void setInputMessage(String text) {
        inputMessage.click();
        inputMessage.type(text);
    }

    public void setSendBtn() {
        sendBtn.click();
    }

    public void setCloseFrame() {
        closeFrame.click();
    }

    public void setMessageForMyself() {
        messageForMyself.click();
    }


}
