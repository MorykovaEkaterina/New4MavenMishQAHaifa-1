package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;

import java.util.List;

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
    @FindBy(xpath ="//*[contains(text(),'valid email')]")
    WebElement alertEmail;
    @FindBy(xpath ="//*[contains(text(),'Enter 6 characters')]")
    WebElement alertPassword;
    @FindBy(xpath = "//*[contains(text(),'This field is mandatory')]")
    List<WebElement> emptyAlertsList;


    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginPageHelper waitUntilPageLoad() {
        Log.info("LoginPageHelper: ---wait until loginPage is loaded---");
        Log.info("LoginPageHelper: Cancel button was loaded");
        waitUntilElementIsLoaded(driver,
                cancelButton,
                45);
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
        waitUntilElementIsLoaded(driver, loginButton, 45);
        Log.info("LoginPageHelper: click on Login button");
        loginButton.click();
        return this;
    }

    public String getAlertText() {
        waitUntilElementIsLoaded(driver, alertText,45);
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
        waitUntilElementIsAbsent(driver, cancelButton,45);
        return this;
    }

    public String getAlertEmail() {
        waitUntilElementIsLoaded(driver, alertEmail, 45);
        return alertEmail.getText();
    }

    public String getAlertPassword() {
        waitUntilElementIsLoaded(driver, alertPassword, 45);
        return alertPassword.getText();
    }

    public int getQuantityAlertsForEmptyFields(){
        return emptyAlertsList.size();
    }
}
