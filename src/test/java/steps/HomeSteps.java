package steps;

import carrefour.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomeSteps {

    private static final HomePage homePage = new HomePage();

    @And("^I click on the account menu button$")
    public static void I_click_on_the_account_menu_button() {
        homePage.clickOnAccountButton();
    }

    @And("^I navigate to the basket page$")
    public static void I_navigate_to_the_basket_page() {
        homePage.clickOnBasketButton();
    }

    @And("^I click on the basket menu button$")
    public static void I_click_on_the_basket_menu_button() {
        homePage.clickOnBasketButton();
    }

    @And("^I click on the select shop button$")
    public static void I_click_on_the_select_shop_button() {
        homePage.clickOnSelectShopButton();
    }

    @Then("^I should be on the home page$")
    public static void I_should_be_on_the_home_page() {
        Assert.assertTrue(homePage.getTitleHomePageAfterCreateAccount().contains("rentrée"));
    }
}
