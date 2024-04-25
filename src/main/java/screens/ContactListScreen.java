package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactListScreen extends BaseScreen {
    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement titleText;
    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOptions;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logoutButton;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
    MobileElement addButton;

//@FindBy(xpath = "//*[contains(text(), 'Pedro Nichols')]")
//static MobileElement addedContact ;

    public AuthenticationScreen logout(){
        moreOptions.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }

    public boolean isContactListPresent(){
      return isElementPresent(titleText, "Contact list");
    }

    public AddNewContactScreen openNewContactForm(){
        waitForElement(addButton);
        addButton.click();
        return new AddNewContactScreen(driver);
    }
//    public boolean isContactExsist(String contactName){//TODO
//        // пройтись по всем контактам и сравнить с тем контактом который мы создали
//        // взять последний контакт и сравнить с тем который мы создали
//    }
//public static void main(String[] args) {
//    AppiumDriver<MobileElement> driver = null;
//// new SplashScreen(driver).switchToAuthScreen().fillEmailField("nusy4@yandex.ru").fillPasswordField("aaAA*12345")
////            .clickByLoginButton();
//    ContactListScreen contactListScreen = new ContactListScreen(driver);
//  //  String newContact = "Pedro Nichols";
//  //  MobileElement addContact = driver.findElement(By.xpath("//*[contains(text(), 'newContact')]"));
//    System.out.println("Added contact is "+ addedContact);
//}
}
