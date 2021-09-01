package kiabi.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AccountPage extends Utils {

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/myaccount_welcome")
    private MobileElement loginButton;

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/myaccount_logoff")
    private MobileElement logoutButton;

    public void clickOnLoginPageButton() {
        click(loginButton);
    }

    public boolean isLogoutButtonDisplayed() {
        longWaitUntil(visibilityOf(logoutButton));
        return logoutButton.isDisplayed();
    }

    public void clickOnLogoutButton() {
        click(logoutButton);
    }
}
