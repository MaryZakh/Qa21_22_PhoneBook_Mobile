package screens;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationScreen extends BaseScreen {
    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement emailEditText;

    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    MobileElement passwordEditText;

    //@FindBy(xpath = "//*[text()]='LOGIN'")
    @FindBy(xpath = "//*[@text='LOGIN']")
    MobileElement loginButton;


    public AuthenticationScreen fillEmail(String email) {
        //pause(4000);
        should(emailEditText,10);
        type(emailEditText, email);
        return this;

    }

    public AuthenticationScreen fillPassword(String password) {
        type(passwordEditText,password);
        return this;

    }

    public ContactListScreen submitLogin(){
        loginButton.click();
        return new ContactListScreen(driver);
    }

}
