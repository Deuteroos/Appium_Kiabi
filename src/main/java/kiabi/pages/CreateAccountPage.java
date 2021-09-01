package kiabi.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateAccountPage extends Utils {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[5]/android.view.View[1]/android.view.View[2]")
    private MobileElement mrRadioButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[5]/android.view.View[1]/android.widget.RadioButton[1]")
    private MobileElement msRadioButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[5]/android.view.View[2]/android.widget.EditText")
    private MobileElement lastNameInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[5]/android.view.View[3]/android.widget.EditText")
    private MobileElement firstNameInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[5]/android.view.View[4]/android.widget.EditText")
    private MobileElement birthDayInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[5]/android.view.View[5]/android.widget.EditText")
    private MobileElement emailInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[5]/android.view.View[6]/android.widget.EditText")
    private MobileElement passwordInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View")
    private MobileElement goodPlanSMSButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[4]/android.view.View/android.view.View/android.widget.EditText")
    private MobileElement phoneInput;

    @AndroidFindBy(className = "android.widget.Button")
    private MobileElement submitButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.TextView")
    private MobileElement textPasswordVerification;

    public void writeLastNameInput(String text) {
        set(lastNameInput, text);
    }

    public void writeFirstNameInput(String text) {
        set(firstNameInput, text);
    }

    public void writeBirthDateInput(String text) {
        set(birthDayInput, text);
    }

    public void writeEmailInput(String text) {
        set(emailInput, text);
    }

    public void writePasswordInput(String text) {
        set(passwordInput, text);
    }

    public void writePhoneInput(String text) {
        set(phoneInput, text);
    }

    public void clickOnMrRadioButton() {
        click(mrRadioButton);
    }

    public void clickOnMsRadioButton() {
        click(msRadioButton);
    }

    public void clickOnLastNameInput() {
        click(lastNameInput);
    }

    public void clickOnTextPasswordVerification() {
        click(textPasswordVerification);
    }

    public void clickOnFirstNameInput() {
        click(firstNameInput);
    }

    public void clickOnBirthDateInput() {
        click(birthDayInput);
    }

    public void clickOnEmailInput() {
        click(emailInput);
    }

    public void clickOnPasswordInput() {
        click(passwordInput);
    }

    public void clickOnGoodPlanSMSButton() {
        swipeScreen("UP", 50);
        click(goodPlanSMSButton);
    }

    public void clickOnPhoneInput() {
        click(phoneInput);
    }

    public void clickOnSubmitCreationAccountButton() {
        click(submitButton);
    }

}
