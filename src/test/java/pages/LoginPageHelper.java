package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginPageHelper waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver,
                cancelButton,
                20);
        return this;
    }

    public LoginPageHelper enterValueToFieldEmail(String value) {

        setValueToField(emailField,value);
        return this;
    }

    public LoginPageHelper enterValueToFieldPassword(String value) {
        setValueToField(passwordField,value);
        return this;
    }

    public LoginPageHelper pressLogInButton() {
        waitUntilElementIsLoaded(driver, loginButton, 20);
        loginButton.click();
        return this;
    }

    public String getAlertText() {
        waitUntilElementIsLoaded(driver, alertText,30);
    return alertText.getText();

    }

    public LoginPageHelper pressCancelButton(){
        cancelButton.click();
        return this;
    }

    public LoginPageHelper waitUntilWindowIsClosed(){
        waitUntilElementIsAbsent(driver, cancelButton,30);
        return this;
    }
}
