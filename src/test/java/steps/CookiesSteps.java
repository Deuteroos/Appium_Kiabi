package steps;

import kiabi.pages.Cookies;
import io.cucumber.java.en.And;

public class CookiesSteps {

    private static final Cookies cookies = new Cookies();

    @And("^I click on the refused cookies button$")
    public static void I_click_on_the_refused_cookies_button() {
        cookies.clickOnRefusedCookies();
    }
}
