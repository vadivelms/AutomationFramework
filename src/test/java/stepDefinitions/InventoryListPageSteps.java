package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.InventoryListPage;

public class InventoryListPageSteps {
    TestContext testContext;
    InventoryListPage inventoryListPage;
    String firstItemName;

    public InventoryListPageSteps(TestContext context) {
        testContext = context;
        inventoryListPage = testContext.getPageObjectManager().getInventoryListPage();
    }

    @And("user is on the inventory page")
    public void user_is_on_inventory_page() {
        Assert.assertTrue(inventoryListPage.isInventoryListDisplayed());
    }

    @And("user adds the first item to the cart")
    public void user_adds_first_item_to_cart() {
        firstItemName = inventoryListPage.getItemName(0);
        inventoryListPage.addItemToCart(0);
        testContext.getScenarioContext().setContext(Context.valueOf("FIRST_ITEM_NAME"), firstItemName);
    }

    @And("user adds the first item to the cart and captures its name")
    public void user_adds_first_item_to_cart_and_captures_name() {
        String firstItemName = inventoryListPage.getItemName(0);
        inventoryListPage.addItemToCart(0);
        testContext.getScenarioContext().setContext(Context.valueOf("CAPTURED_ITEM_NAME"), firstItemName);
    }
}
