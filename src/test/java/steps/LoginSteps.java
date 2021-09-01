package steps;

import kiabi.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginSteps {

    private static final LoginPage loginPage = new LoginPage();
    private static final HomePage homePage = new HomePage();
    private static final Cookies cookies = new Cookies();
    private static final AccountPage accountPage = new AccountPage();


    @Given("^I am on the login page$")
    public static void I_am_on_the_login_page() {
        cookies.clickOnRefusedLikeApp();
        homePage.clickOnAccountButton();
        accountPage.clickOnLoginPageButton();
    }

    @And("^I click on the email input")
    public static void I_click_on_the_email_input() {
        loginPage.clickOnEmailInput();
    }

    @And("^I will use credential \"([^\"]*)\" and password \"([^\"]*)\"$")
    public static void Login_credentials(String email, String password) {
        loginPage.writeCredential(email, password);
    }

    @And("^I click on the login button$")
    public static void I_click_on_the_login_button() {
        loginPage.clickOnLoginButton();
    }

    @And("^I click on the password input")
    public static void I_click_on_the_password_input() {
        loginPage.clickOnPasswordInput();
    }

    @And("^I write \"([^\"]*)\" in the password input$")
    public static void I_write_in_the_password_input(String password) {
        loginPage.writePasswordInput(password);
    }

    @And("^I click on the create account button$")
    public static void I_click_on_the_create_account_button() {
        loginPage.clickOnCreateAccountButton();
    }

    @Then("^I should be on the login page$")
    public static void I_should_be_on_the_login_page() {
        Assert.assertTrue(loginPage.getTitleLoginPageAfterCreateAccount().contains("Identifiez-vous"));
    }
}
