package steps;

import kiabi.pages.FidelityProgramsPage;
import io.cucumber.java.en.And;

public class FidelityProgramsSteps {

    private static final FidelityProgramsPage fidelityProgramsPage = new FidelityProgramsPage();

    @And("^I refused the fidelity programs$")
    public static void I_refused_the_fidelity_programs() {
        fidelityProgramsPage.clickOnDontWantFidCardButton();
        fidelityProgramsPage.clickOnSubmitChoiceFidCardButton();
    }
}
