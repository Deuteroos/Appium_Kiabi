package carrefour.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Cookies extends Utils {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.app.Dialog/android.view.View[2]/android.widget.Button[2]")
    private MobileElement refusedCookiesButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[5]")
    private MobileElement refusedLikeApp;

    public void clickOnRefusedLikeApp() {
        if (waitUntil(visibilityOf(refusedLikeApp))) {
            click(refusedLikeApp);
        }
    }

    public void clickOnRefusedCookies() {
        if (waitUntil(visibilityOf(refusedCookiesButton))) {
            click(refusedCookiesButton);
        }
    }
}
