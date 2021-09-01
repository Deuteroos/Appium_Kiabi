package steps;

import kiabi.pages.BasketPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BasketSteps {

    private static final BasketPage basketPage = new BasketPage();

    @When("^I remove the product of the basket$")
    public static void I_remove_the_product_of_the_basket() {
        basketPage.clickOnRemoveFirstProductBasketButton();
    }

    @Then("^I should be able to see the correct product in the basket$")
    public static void I_should_be_able_to_see_the_correct_product_in_the_basket() {
        Assert.assertTrue(basketPage.getNameOfFirstProductInBasket().contains("Robe") && basketPage.getSizeOfFirstProductInBasket().contains("5A"));
    }

    @Then("^The basket should be empty$")
    public static void The_basket_should_be_empty() {
        Assert.assertTrue(basketPage.getTitleBasketWithNoProduct().contains("0"));
    }
}
