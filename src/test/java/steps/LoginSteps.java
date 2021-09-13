package steps;

import ZenityAutomation.AutomationModule;
import ZenityAutomation.ModuleParameters;
import ZenityAutomation.ModulesConnections;
import io.cucumber.datatable.DataTable;
import kiabi.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

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


    @AutomationModule(inputs = {"user"}, moduleName = "I fill the Login Form:", moduleDescription = "Permet de remplir le formulaire de connexion", category = "2. Connexion", outputs = {"user"}, parameters = {
            @ModuleParameters(type = ModuleParameters.paramType.STRING, label = "email", drivenBy = ModulesConnections.USER),
            @ModuleParameters(type = ModuleParameters.paramType.STRING, label = "password", drivenBy = ModulesConnections.USER),
    })
    @And("^I fill the Login Form:$")
    public static void I_fill_the_login_form(DataTable dt) {
        List<Map<String, String>> credential = dt.asMaps();
        loginPage.writeCredential(credential.get(0).get("email"), credential.get(0).get("password"));
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
