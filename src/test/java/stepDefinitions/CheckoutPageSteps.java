package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.CheckoutPage;

public class CheckoutPageSteps {
    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context) {
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @And("user enters valid checkout information")
    public void user_enters_valid_checkout_information() {
        checkoutPage.fillCheckoutInformation("John", "Doe", "12345");
        checkoutPage.clickContinue();
    }

    @And("user completes the purchase")
    public void user_completes_the_purchase() {
        checkoutPage.clickFinish();
    }

    @Then("the order should be completed successfully")
    public void the_order_should_be_completed_successfully() {
        Assert.assertTrue(checkoutPage.isCheckoutComplete());
    }
}

