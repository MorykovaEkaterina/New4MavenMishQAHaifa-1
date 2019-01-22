package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;
import util.LogLog4j;

/**
 * Created by Inka on 23-Dec-18.
 */
public class HomePageHelper extends PageBase {
    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    WebElement createAccountButton;

    @FindBy(xpath = "//span[contains(text(),'Go to Event list')]")
    WebElement goToEventButton;

    @FindBy(xpath = "//h1[@class='mat-display-3']")
    WebElement header;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    public HomePageHelper(WebDriver driver){
        super(driver);
    }

    public HomePageHelper waitUntilPageLoad() {
        Log.info("HomePageHelper: ---wait until homePage is loaded---");
        Log.info("HomePageHelper: wait until loginButton is loaded");
        waitUntilElementIsLoaded(driver,
                loginButton,
                45);
        Log.info("HomePageHelper: wait until createAccountButton is loaded");
        waitUntilElementIsLoaded(driver,
                createAccountButton,40);
        Log.info("HomePageHelper: wait until goToEventButton is loaded");
        waitUntilElementIsLoaded(driver, goToEventButton,40);
        return this;
    }

    public String getGoToEventButtonName() {
        return goToEventButton.getText();
    }

    public HomePageHelper pressGoToEventButton() {
        goToEventButton.click();
        return this;
    }

    public HomePageHelper pressLoginButton() {
        Log.info("HomePageHelper: -- press Login button---");
        Log.info("HomePageHelper: Login button was clicked");
        loginButton.click();
        return this;
    }

    public HomePageHelper pressCreateAccountButton() {

        createAccountButton.click();
        return this;
    }


    public String getHeader() {
        return header.getText();
    }
}
