package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class AuthenticationScreen extends BaseScreen{

    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id ='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement titleText; // AuthenticationScreen

    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmailField;
    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    MobileElement inputPasswordField;
    @FindBy(id = "com.sheygam.contactapp:id/regBtn")
    MobileElement registrationButton;
    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginButton;
    @FindBy(id = "android:id/message")
    MobileElement errorText;

public AuthenticationScreen fillEmailField (String email){
    waitForElement(inputEmailField);
    inputEmailField.sendKeys(email);
    return this;
 }

 public AuthenticationScreen fillPasswordField(String password){
    inputPasswordField.sendKeys(password);
    return this;
 }
public <T extends BaseScreen> T clickByLoginButton(){
    loginButton.click();
    List<MobileElement> list =
            driver.findElements(By.xpath("//*[@resource-id='android:id/alertTitle']"));
    if(list.size()>0){
        driver.findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
        return null;// (T) new AuthenticationScreen(driver);
    }
       return (T) new ContactListScreen(driver);
    }

    // check if we are on AuthenticationScreen
    public boolean isItAuthenticationScreen(){
        return titleText.isDisplayed();
    }
    public boolean isItWrongAuthScreen(){ return errorText.isDisplayed(); }


 public <T extends BaseScreen> T clickByRegistrationButton(){
    registrationButton.click();
    List<MobileElement> list =
              driver.findElements(By.id("android:id/alertTitle"));
  if(list.size()>0){
            driver.findElement(By.id("android:id/button1")).click();
            return (T)new AuthenticationScreen(driver);
        }else{
      return (T) new ContactListScreen(driver);
     }
     }

    public <T extends BaseScreen> T clickByLoginButtonMy() throws Exception{
        try{
            loginButton.click();
            driver.findElements(By.xpath("//*[@resource-id='android:id/alertTitle']"));
            return (T) new ContactListScreen(driver);
        }catch(Exception e){
            System.out.println("Errore!" +e);
            driver.findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
            return (T)new AuthenticationScreen(driver);
        }
    }
}
