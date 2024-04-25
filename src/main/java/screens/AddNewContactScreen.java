package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen{

    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputName']")
    MobileElement inputName ;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    MobileElement  inputLastName;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement inputEmail;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    MobileElement inputPhone;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    MobileElement inputAddress;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    MobileElement  inputDescription;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/createBtn']")
    MobileElement createButton;

    public <T extends BaseScreen> T clickByCreateButton() throws Exception{
        try{
            createButton.click();
            return (T) new ContactListScreen(driver);
        }catch(Exception e){
            e.printStackTrace();
            driver.findElement(By.xpath("//*[@resource-id='android:id/alertTitle']"))
                    .click();
            return null;
        }
    }
    public AddNewContactScreen fillNameField (String name){
        waitForElement(inputName);
        inputName.sendKeys(name);
        return this;
    }
    public AddNewContactScreen fillLastNameField (String lastName){
        inputLastName.sendKeys(lastName);
        return this;
    }

    public AddNewContactScreen fillEmailField (String email){
        inputEmail.sendKeys(email);
        return this;
    }
    public AddNewContactScreen fillPhoneField (String phone){
        inputPhone.sendKeys(phone);
        return this;
    }
    public AddNewContactScreen fillAddressField (String address){
        inputAddress.sendKeys(address);
        return this;
    }
    public AddNewContactScreen fillDescField (String desc){
        inputDescription.sendKeys(desc);
        return this;
    }

    public  void fillNewForm(Contact contact){
        fillNameField(contact.getName())
                .fillLastNameField(contact.getLastName())
                .fillEmailField(contact.getEmail())
                .fillPhoneField(contact.getPhone())
                .fillAddressField(contact.getAddress())
                .fillDescField(contact.getDescription());
        }
// метод не виден из класса Теста
//        public void createContact()  {
//            createButton.clickByCreateButton();
//        }

}
