package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {

    private final WebDriver driver;

    private ProductListingPage productListingPage;

    private CartPage cartPage;

    private CheckoutPage checkoutPage;

    private InventoryListPage inventoryListPage;

    private LoginPage loginPage;


    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }

    public ProductListingPage getProductListingPage() {

        return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;

    }

    public CartPage getCartPage() {

        return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;

    }

    public CheckoutPage getCheckoutPage() {

        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;

    }

    public InventoryListPage getInventoryListPage() {

        return (inventoryListPage == null) ? inventoryListPage = new InventoryListPage(driver) : inventoryListPage;

    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }
}
