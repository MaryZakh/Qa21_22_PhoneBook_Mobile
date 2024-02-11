package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactListScreen extends BaseScreen {
    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityTextView;

    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement menuOptions;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logoutButton;

    @FindBy(id = "com.sheygam.contactapp:id/add_contact_btn")
    MobileElement plusBtn;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName'")
    List<MobileElement> contactNameList;

    public boolean isActivityTitleDisplayed(String text) {
        //return activityTextView.getText().contains("Contact list");
        return isShouldHave(activityTextView, text, 10);
    }

    public AuthenticationScreen logout() {
        if (activityTextView.getText().equals("Contact list")) {
            menuOptions.click();
            logoutButton.click();
        }
        return new AuthenticationScreen(driver);
    }

    public ContactListScreen isAccountOpened() {
        Assert.assertTrue(isActivityTitleDisplayed("Contact list"));
        return this;
    }

    public AddNewContatSreen openContactForm(){
        plusBtn.click();
        return new AddNewContatSreen(driver);
    }

    public ContactListScreen isContactAddedByName(String name, String lastName){
        //List<MobileElement> list = driver.findElements(By.xpath(""));
        isShouldHave(activityTextView,"Contact list",5);
        boolean isPresent = false;
        for (MobileElement element:contactNameList){
            if (element.getText().equals(name+ " "+ lastName)){
                isPresent=true;
                break;
            }
        }
        Assert.assertTrue(isPresent);
        return  this;
    }

}
