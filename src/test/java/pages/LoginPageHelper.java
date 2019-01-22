package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;
import util.LogLog4j;

/**
 * Created by Inka on 26-Dec-18.
 */
public class LoginPageHelper extends PageBase {
    @FindBy(xpath = "//span[contains(text(),'Cancel')]" )
    WebElement cancelButton;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;
    @FindBy(xpath = "//span[contains(text(),'Log in')]")
    WebElement loginButton;
    @FindBy(xpath =
            "//div[@class='alert alert-danger ng-star-inserted']")
    WebElement alertText;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginPageHelper waitUntilPageLoad() {
        Log.info("LoginPageHelper: ---wait until loginPage is loaded---");
        Log.info("LoginPageHelper: Cancel button was loaded");
        waitUntilElementIsLoaded(driver,
                cancelButton,
                20);
        return this;
    }

    public LoginPageHelper enterValueToFieldEmail(String value) {
        Log.info("LoginPageHelper: ---enter value emeil---");
        Log.info("LoginPageHelper: was eneterd email: " + value);
        setValueToField(emailField,value);
        return this;
    }

    public LoginPageHelper enterValueToFieldPassword(String value) {
        Log.info("LoginPageHelper: ---enter value password---");
        Log.info("LoginPageHelper: was enetered password: " + value);
        setValueToField(passwordField,value);
        return this;
    }

    public LoginPageHelper pressLogInButton() {
        Log.info("LoginPageHelper: --- pressLogInButton() ---");
        Log.info("LoginPageHelper: wait until Login button is loaded");
        waitUntilElementIsLoaded(driver, loginButton, 20);
        Log.info("LoginPageHelper: click on Login button");
        loginButton.click();
        return this;
    }

    public String getAlertText() {
        waitUntilElementIsLoaded(driver, alertText,30);
    return alertText.getText();

    }

    public LoginPageHelper pressCancelButton(){
        Log.info("LoginPageHelper: --- pressCancelButton() ---");
        Log.info("LoginPageHelper: click on Cancel button");
        cancelButton.click();
        return this;
    }

    public LoginPageHelper waitUntilWindowIsClosed(){
        Log.info("LoginPageHelper: --- waitUntilWindowIsClosed() ---");
        Log.info("LoginPageHelper: wait until Cancel button is absent");
        waitUntilElementIsAbsent(driver, cancelButton,30);
        return this;
    }
}
