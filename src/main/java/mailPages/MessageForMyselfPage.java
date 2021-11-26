package mailPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageForMyselfPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageForMyselfPage.class);

    @FindBy(xpath = "//span[@class='octopus__title']")
    private ExtendedWebElement afterDelete;
    @FindBy(xpath = "//span[@title='Пометить прочитанным']")
    private ExtendedWebElement unreadDot;


    public MessageForMyselfPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public ExtendedWebElement getAfterDelete() {
        return afterDelete;
    }

    public ExtendedWebElement getUnreadDot() {
        return unreadDot;
    }

}