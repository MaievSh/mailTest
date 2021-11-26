package mailPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogInPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogInPage.class);

    @FindBy(xpath = "//input[@class='email-input svelte-1tib0qz']")
    private ExtendedWebElement emailField;
    @FindBy(xpath = "//button[contains(text(),'Ввести пароль')]")
    private ExtendedWebElement passButton;
    @FindBy(xpath = "//input[@class='password-input svelte-1tib0qz']")
    private ExtendedWebElement passField;
    @FindBy(xpath = "//button[@class='second-button svelte-1tib0qz'][contains(text(),'Войти')]")
    private ExtendedWebElement logInButton;
    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private ExtendedWebElement incomingMessageBar;

    public LogInPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void inputEmail(String email) {
        emailField.click();
        emailField.type(email);
    }

    public void inputPasswordButton() {
        passButton.click();
    }

    public void inputPassword(String password) {
        passField.click();
        passField.type(password);
    }

    public void LogInButtonClick() {
        logInButton.click();
    }

    public ExtendedWebElement getIncomingMessageBar() {
        return incomingMessageBar;
    }
}
