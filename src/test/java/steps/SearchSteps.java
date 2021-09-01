package steps;

import kiabi.pages.Cookies;
import kiabi.pages.HomePage;
import kiabi.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchSteps {

    private static final SearchPage searchPage = new SearchPage();
    private static final HomePage homePage = new HomePage();
    private static final Cookies cookies = new Cookies();

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

    @And("^I go to the basket page$")
    public static void I_go_to_the_basket_page() {
        searchPage.clickOnFirstProductWithBasketButton();
    }

    @When("^I add the product to the basket at the size \"([^\"]*)\"$")
    public static void I_add_the_product_to_the_basket_at_the_size(String size) {
        searchPage.clickOnFirstAddProductToBasketButton();
        searchPage.selectTheSize(size);
    }

    @Then("^The name of the products should be matches with the search$")
    public static void The_name_of_the_products_should_be_matches_with_the_search() {
        Assert.assertTrue(searchPage.getProductSearchName().contains("Robe"));
    }
}
