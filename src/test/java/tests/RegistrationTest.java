package tests;

import cofig.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RegistrationTest extends AppiumConfig {
    @Test
    public void registrationnewUsertest(){
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("testUser2@mail.ru")
                .fillPasswordField("bbDD*64321")
                .clickByRegistrationButton();
        Assert.assertTrue(contactListScreen.isContactListPresent());
    }
}
