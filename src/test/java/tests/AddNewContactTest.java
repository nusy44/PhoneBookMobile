package tests;

import cofig.AppiumConfig;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.BaseScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class AddNewContactTest extends AppiumConfig {

    @Test
    public void addNewContactTest() throws Exception {
        // переключиться на экран авторизации
        new SplashScreen(driver).switchToAuthScreen().fillEmailField("nusy4@yandex.ru").fillPasswordField("aaAA*12345")
                .clickByLoginButton();
        Contact contact = new Contact(NameAndLastNameGenerator.generateName(), NameAndLastNameGenerator.generateLastName(),
                PhoneNumberGenerator.generatePhoneNumber(), EmailGenerator.generateEmail(5,5,3),
                AddressGenerator.generateAddress(),"description");
        new ContactListScreen(driver).openNewContactForm().fillNewForm(contact);
        //new ContactListScreen(driver).openNewContactForm().fillNewForm(contact).clickByCreateButton();
        // - почему не видит метод clickByCreateButton() система находится на странице AddNewContactScreen
        // переписан код с добавлением строк 33, 34
        System.out.println("New contact form filled successfully!");
        AddNewContactScreen addNewContactScreen = new AddNewContactScreen(driver);
        addNewContactScreen.clickByCreateButton();
        String newContact = contact.getName()+" "+contact.getLastName();
        System.out.println("New contact" + " "+newContact);
        ContactListScreen contactListScreen = new ContactListScreen(driver);
        System.out.println("ContactListScreen is oped");
        Assert.assertTrue(contactListScreen
                .isElementPresent(driver.findElement(By.xpath("//*[contains(text(), newContact)]")),
                newContact));
    }
    public MobileElement newContact (String newContact){
        ContactListScreen contactListScreen = new ContactListScreen(driver);
         return (MobileElement) driver.findElement(By.xpath("//*@[text=newContact]"));
      }
    @Test
    public void addNewContactTestFromAI() throws Exception {
        // Switch to the authentication screen
        new SplashScreen(driver).switchToAuthScreen()
                .fillEmailField("nusy4@yandex.ru")
                .fillPasswordField("aaAA*12345")
                .clickByLoginButton();

        // Create a new contact object with generated data
        Contact contact = new Contact(NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                PhoneNumberGenerator.generatePhoneNumber(),
                EmailGenerator.generateEmail(5,5,3),
                AddressGenerator.generateAddress(),"description");

        // Open the new contact form and fill it with the generated contact data
        new ContactListScreen(driver)
                .openNewContactForm()
                .fillNewForm(contact);
        System.out.println("New contact form filled successfully!");

        // Click the "Create" button to save the new contact
        AddNewContactScreen addNewContactScreen = new AddNewContactScreen(driver);
        addNewContactScreen.clickByCreateButton();

        // Construct the expected name of the new contact
        String newContact = contact.getName()+" "+contact.getLastName();
        System.out.println("New contact" + " "+newContact);

        // Get the ContactListScreen instance
        ContactListScreen contactListScreen = new ContactListScreen(driver);
        System.out.println("ContactListScreen is opened");

        // Assert that the new contact is present in the contact list
        Assert.assertTrue(contactListScreen
                .isElementPresent(driver.findElement(By.xpath("//*[contains(text(), '" + newContact + "')]")),
                        newContact));
    }


}
// fillNewForm(contact) - заполнить поля
// в классе ContactListScreen с помощью @FindBy найти поля
// createContact
// проверить что контакт добавлен