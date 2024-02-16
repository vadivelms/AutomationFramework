package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;
import pageObjects.ProductListingPage;
import utility.LoggingUtility;

public class ProductPageSteps {
    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductPageSteps(TestContext context) {
        testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
    }

    @When("choose to buy the first item")
    public void choose_to_buy_the_first_item() {
        String productName = productListingPage.getProductName(0);
        testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productName);
        productListingPage.select_Product(0);
        productListingPage.select_Color(1);
        productListingPage.select_Size(1);
        productListingPage.clickOn_AddToCart();
        LoggingUtility.logInfo("sampleinfo");
        LoggingUtility.logError("sample error");
    }
}
