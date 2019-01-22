package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EventsAuthPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import pages.MenuPageHelper;
import util.DataProviders;
import org.apache.log4j.Logger;
import util.LogLog4j;

/**
 * Created by Inka on 19-Dec-18.
 */
public class LoginPageTests extends TestBase {
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    EventsAuthPageHelper eventsAuthPage;
    MenuPageHelper menuPage;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @BeforeMethod
    public void initPage(){
        homePage = PageFactory
                .initElements(driver, HomePageHelper.class);
        loginPage = PageFactory
                .initElements(driver, LoginPageHelper.class);
        eventsAuthPage = PageFactory.initElements(driver,
                EventsAuthPageHelper.class);
        menuPage = PageFactory
                .initElements(driver,MenuPageHelper.class);

    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginPositive")
    public void loginPositive(String email, String password)  {

        Log.info("--------Test loginPositive was started---------");
        Log.info("Parameter: email = " + email);
        Log.info("Parameter: password = " + password);
        Log.info("Test login Positive: homePage was opened");
        homePage.waitUntilPageLoad()
                .pressLoginButton()
                .waitUntilPageLoad();
        Log.info("Test login Positive: loginPage was opened");
        loginPage.enterValueToFieldEmail(email)
                .enterValueToFieldPassword(password)
                .pressLogInButton();
        eventsAuthPage.waitUntilPageLoad();

        Assert.assertEquals("Menu", eventsAuthPage.getTooltipIconMenu());
        Assert.assertEquals("Find event",eventsAuthPage.getHeader());
        //driver.quit();
        eventsAuthPage.menuButtonClick();
        menuPage.waitUntilPageLoad()
                .pressLogOutButton();
        homePage.waitUntilPageLoad();
        Assert.assertEquals(homePage.getHeader(),
                "Shabbat in the family circle");

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginNegative")
    public void loginNegative(String email, String password){
        Log.info("--------- Test loginNegative was started -----------");
        Log.info("Parameter - email: " + email);
        Log.info("Parameter - password: " + password);
        Log.info("loginNegative: homePage is opened");
        homePage.waitUntilPageLoad()
                .pressLoginButton();
        Log.info("loginNegative: loginPage was opened");
        loginPage.waitUntilPageLoad()
                .enterValueToFieldEmail(email)
                .enterValueToFieldPassword(password)
                .pressLogInButton();
       Assert.assertEquals("Wrong authorization, login or password",
               loginPage.getAlertText(),
               "alert 'Wrong authorization, login or password' wasn't given");
       Log.info("loginNegative: loginPage was opened");
       loginPage.pressCancelButton()
               .waitUntilWindowIsClosed();
    }
}
