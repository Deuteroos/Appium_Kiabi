package carrefour.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends Utils {

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/login_welcome1") // Bonjour inconnue
    private MobileElement titleLoginPage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[4]/android.view.View[1]/android.view.View")
    private MobileElement titleLoginPageAfterCreateAccount;

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/login")
    private MobileElement emailInput;

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/mdp")
    private MobileElement passwordInput;

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/btn_valider")
    private MobileElement loginButton;

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/btn_creer")
    private MobileElement createAccountButton;

    public void writeEmailInput(String text) {
        set(emailInput, text);
    }

    public void writePasswordInput(String text) {
        set(passwordInput, text);
    }

    public void writeCredential(String email, String password) {
        set(emailInput, email);
        set(passwordInput, password);
    }

    public void clickOnEmailInput() {
        click(emailInput);
    }

    public void clickOnPasswordInput() {
        click(passwordInput);
    }

    public void clickOnLoginButton() {
        click(loginButton);
    }

    public void clickOnCreateAccountButton() {
        click(createAccountButton);
    }

    public String getTitleLoginPage() {
        return titleLoginPage.getText();
    }

    public String getTitleLoginPageAfterCreateAccount() {
        return titleLoginPageAfterCreateAccount.getText();
    }
}
