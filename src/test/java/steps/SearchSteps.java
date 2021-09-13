package steps;

import ZenityAutomation.AutomationModule;
import ZenityAutomation.ModuleParameters;
import ZenityAutomation.ModulesConnections;
import io.cucumber.datatable.DataTable;
import kiabi.pages.Cookies;
import kiabi.pages.HomePage;
import kiabi.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SearchSteps {

    private static final SearchPage searchPage = new SearchPage();
    private static final HomePage homePage = new HomePage();
    private static final Cookies cookies = new Cookies();

    @AutomationModule(moduleName = "I am on the search page", moduleDescription = "Permet d'accéder à la page de recherche", category = "4. Search")
    @Given("^I am on the search page$")
    public static void I_am_on_the_search_page() {
        cookies.clickOnRefusedLikeApp();
        homePage.clickOnSearchButton();
        cookies.clickOnRefusedCookies();
    }

    @When("^I will search a product named \"([^\"]*)\"$")
    public static void I_will_search_a_product(String productSearch) {
        searchPage.clickOnSearchInput();
        searchPage.writeSearchInput(productSearch);
    }

    @AutomationModule(moduleName = "I fill the search with product named:", moduleDescription = "Permet de remplir le formulaire de recherche", category = "4. Search", parameters = {
            @ModuleParameters(type = ModuleParameters.paramType.STRING, label = "search", drivenBy = ModulesConnections.SEARCH),
    })
    @When("^I fill the search with product named:$")
    public static void I_fill_the_search_with_product_named(DataTable dt) {
        List<Map<String, String>> credential = dt.asMaps();
        searchPage.clickOnSearchInput();
        searchPage.writeSearchInput(credential.get(0).get("searchName"));
    }

    @And("^I go to the basket page$")
    public static void I_go_to_the_basket_page() {
        searchPage.clickOnFirstProductWithBasketButton();
    }

    @When("^I add the product to the basket at the size \"([^\"]*)\"$")
    public static void I_add_the_product_to_the_basket_at_the_size(String size) {
        searchPage.clickOnFirstAddProductToBasketButton();
        searchPage.selectTheSize(size);
    }

    @AutomationModule(moduleName = "The name of the products should be matches with the search", moduleDescription = "Vérifie que le nom du produit correspond bien à la recherche", category = "4. Search")
    @Then("^The name of the products should be matches with the search$")
    public static void The_name_of_the_products_should_be_matches_with_the_search() {
        Assert.assertTrue(searchPage.getProductSearchName().contains("Robe"));
    }
}
