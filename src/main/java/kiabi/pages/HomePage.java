package kiabi.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends Utils {

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/bottom_navigation_account")
    private MobileElement accountButton;

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/bottom_navigation_search")
    private MobileElement searchButton;

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/header_basket_container")
    private MobileElement basketButton;

    @AndroidFindBy(id = "android:id/text1")
    private MobileElement titleHomePage;

    @AndroidFindBy(id = "com.pictime.kiabi.activity:id/bottom_navigation_magasin")
    private MobileElement selectShopButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[5]/android.widget.Image")
    private MobileElement titleHomePageAfterCreateAccount;

    public void clickOnSearchButton() {
        click(searchButton);
    }

    public void clickOnBasketButton() {
        click(basketButton);
    }

    public void clickOnAccountButton() {
        click(accountButton);
    }

    public void clickOnSelectShopButton() {
        click(selectShopButton);
    }

    public String getTitleHomePage() {
        return titleHomePage.getText();
    }

    public String getTitleHomePageAfterCreateAccount() {
        return titleHomePageAfterCreateAccount.getText();
    }

}
