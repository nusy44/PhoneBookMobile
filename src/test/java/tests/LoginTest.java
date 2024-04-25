package tests;

import cofig.AppiumConfig;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTest extends AppiumConfig {
    @Test
    public void loginPositive() throws InterruptedException{
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("nusy4@yandex.ru")
                .fillPasswordField("aaAA*12345")
                .clickByLoginButton();
        AuthenticationScreen authenticationScreen = contactListScreen.logout();
        Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }
    // TestCase
   // 1. Open AuthenticationScreen
   // 2.1. Fill emailField with incorrect value and passwordField with correct value - "loginNegativeWrongEmail"
   // 2.2. Fill emailField with correct value and passwordField with incorrect value - "loginNegativeWrongPassword"
   // 3. Click on Login button
   // 4. The System return Error-message

    @Test
    public void loginNegativeWrongEmail() throws Exception {
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("nusy4yandex.ru")
                .fillPasswordField("aaAA*12345")
                .clickByLoginButton();
        AuthenticationScreen authenticationScreen = new AuthenticationScreen(driver);
        Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }

    @Test
    public void loginNegativeWrongPassword(){
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("nusy4@yandex.ru")
                .fillPasswordField("aaBB*12345")
                .clickByLoginButton();
        AuthenticationScreen authenticationScreen = new AuthenticationScreen(driver);
        Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }

}
