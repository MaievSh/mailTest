package mailPages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class VerificationMail extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerificationMail.class);

    public VerificationMail(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public static String getUser(String path, String user) {
        Properties properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
            properties.load(file);
            file.close();
            return properties.getProperty(user);

        } catch (IOException e) {
            System.err.println(" Incorrect user!");
        }
        return "default";
    }

    public static String getPassword(String path, String password) {
        Properties properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
            properties.load(file);
            file.close();
            return properties.getProperty(password);

        } catch (IOException e) {
            System.err.println(" Incorrect Password!");
        }
        return "default";
    }

    public void setDBSignificance(String path, String User, String valueUser, String password, String valuePassword) {
        Properties properties = new Properties();
        try {
            FileOutputStream file = new FileOutputStream(path);
            properties.setProperty(User, valueUser);
            properties.setProperty(password, valuePassword);
            properties.store(file, "");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}