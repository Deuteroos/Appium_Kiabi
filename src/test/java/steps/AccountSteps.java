package steps;

import carrefour.pages.AccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountSteps {

    private static final AccountPage accountPage = new AccountPage();

    @And("^I click on the button to access login page$")
    public static void I_click_on_the_button_to_access_login_page() {
        accountPage.clickOnLoginPageButton();
    }

    @Then("^I should be able to be connected$")
    public static void I_should_be_able_to_be_connected() {
        Assert.assertTrue(accountPage.isLogoutButtonDisplayed());
    }
}
