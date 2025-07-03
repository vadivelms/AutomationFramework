package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import pageObjects.ProductListingPage;

public class ProductListingPageSteps {
    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductListingPageSteps(TestContext context) {
        testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
    }

    @And("user selects the first product")
    public void user_selects_the_first_product() {
        productListingPage.select_Product(0);
    }

    @And("user adds the selected product to the cart")
    public void user_adds_selected_product_to_cart() {
        productListingPage.clickOn_AddToCart();
    }
}

