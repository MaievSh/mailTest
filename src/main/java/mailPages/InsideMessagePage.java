package mailPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class InsideMessagePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsideMessagePage.class);

    @FindBy(xpath = "//span[@class='button2__txt']")
    private List<ExtendedWebElement> deleteMessageBtn;
    @FindBy(xpath = "//span[@class='ll-sp__normal']")
    private ExtendedWebElement messagePreview;
    @FindBy(xpath = "//div[@class='llc__content']")
    private ExtendedWebElement replyMessagePreview;
    @FindBy(xpath = "//span[@class='button2__ico']")
    private List<ExtendedWebElement> threeDotsBtn;
    @FindBy(xpath = "//span[@class='list-item__text']")
    private List<ExtendedWebElement> markBtn;
    @FindBy(xpath = "//div[@class='translator__title']")
    private ExtendedWebElement translatePreview;
    @FindBy(xpath = "//span[@class='button2__ico']")
    private List<ExtendedWebElement> threeDotsInMessage;
    @FindBy(xpath = "//a[contains(@title, 'Спам')]")
    private ExtendedWebElement spamPageBtn;


    public InsideMessagePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void setDeleteMessageBtn() {
        deleteMessageBtn.get(1).click();
    }

    public void replyMessageBtn() {
        deleteMessageBtn.get(5).click();
    }

    public ExtendedWebElement getMessagePreview() {
        return messagePreview;
    }

    public ExtendedWebElement getReplyMessagePreview() {
        return replyMessagePreview;
    }

    public void setThreeDotsBtn() {
        threeDotsBtn.get(5).click();
    }

    public void setMarkUnreadBtn() {
        markBtn.get(0).click();
    }

    public void setMoreBtn() {
        markBtn.get(6).click();
    }

    public ExtendedWebElement getTranslatePreview() {
        return translatePreview;
    }

    public void setThreeDotsInMessage() {
        threeDotsInMessage.get(19).click();
    }

    public void setSpam() {
        markBtn.get(16).click();
    }

    public void setSpamPageBtn() {
        spamPageBtn.click();
    }
}