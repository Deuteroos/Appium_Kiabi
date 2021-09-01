package kiabi.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class SearchPage extends Utils {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.EditText")
    private MobileElement searchInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]")
    private MobileElement clickSearchInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[1]/android.view.View[3]")
    private MobileElement productSearchName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[1]/android.view.View[5]")
    private MobileElement firstAddProductToBasketButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.widget.ListView/android.view.View")
    private List<MobileElement> listOfSize;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Voir mon panier\"]")
    private MobileElement firstBasketProductButton;

    public void writeSearchInput(String text) {
        set(searchInput, text);
    }

    public void selectTheSize(String size) {
        listOfSize
                .stream()
                .filter(element -> element.getText().contains(size))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element not cliquable!"))
                .click();
    }

    public void clickOnFirstAddProductToBasketButton() {
        click(firstAddProductToBasketButton);
    }

    public void clickOnSearchInput() {
        click(clickSearchInput);
    }

    public void clickOnFirstProductWithBasketButton() {
        click(firstBasketProductButton);
    }

    public String getProductSearchName() {
        return productSearchName.getText();
    }
}
