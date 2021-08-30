package steps;

import carrefour.pages.CreateAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CreateAccountSteps {

    private static final CreateAccountPage createAccountPage = new CreateAccountPage();

    @When("^I fill the creation account form with lastName \"([^\"]*)\", firstName \"([^\"]*)\", birthDate \"([^\"]*)\", email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public static void I_am_on_the_login_page(String lastName, String firstName, String birthDate, String email, String password) {
        createAccountPage.clickOnMrRadioButton();
        createAccountPage.clickOnLastNameInput();
        createAccountPage.writeLastNameInput(lastName);
        createAccountPage.clickOnFirstNameInput();
        createAccountPage.writeFirstNameInput(firstName);
        createAccountPage.clickOnBirthDateInput();
        createAccountPage.writeBirthDateInput(birthDate);
        createAccountPage.clickOnEmailInput();
        createAccountPage.writeEmailInput(email);
        createAccountPage.clickOnPasswordInput();
        createAccountPage.writePasswordInput(password);
        createAccountPage.clickOnGoodPlanSMSButton();
    }

    @And("^I click on the submit creation account button$")
    public static void I_click_on_the_submit_creation_account_button() {
        createAccountPage.clickOnSubmitCreationAccountButton();
    }
}
