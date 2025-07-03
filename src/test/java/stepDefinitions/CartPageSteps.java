package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.CartPage;

public class CartPageSteps {
    TestContext testContext;
    CartPage cartPage;

    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @And("user navigates to the cart page")
    public void user_navigates_to_cart_page() {
        cartPage.openCart();
    }

    @Then("the first item should be present in the cart")
    public void the_first_item_should_be_present_in_the_cart() {
        String firstItemName = (String) testContext.getScenarioContext().getContext(Context.FIRST_ITEM_NAME);
        Assert.assertTrue(cartPage.isProductInCart(firstItemName));
    }

    @Then("the captured item should be present in the cart")
    public void the_captured_item_should_be_present_in_the_cart() {
        String capturedItemName = (String) testContext.getScenarioContext().getContext(Context.CAPTURED_ITEM_NAME);
        Assert.assertTrue(cartPage.isProductInCart(capturedItemName));
    }

    @And("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cartPage.clickCheckout();
    }
}
