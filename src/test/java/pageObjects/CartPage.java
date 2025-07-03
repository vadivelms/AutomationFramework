package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Elements for cart page
    @FindBy(how = How.CLASS_NAME, using = "cart_item")
    private java.util.List<WebElement> cartItems;

    @FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
    private java.util.List<WebElement> cartItemNames;

    @FindBy(how = How.CLASS_NAME, using = "inventory_item_price")
    private java.util.List<WebElement> cartItemPrices;

    @FindBy(how = How.CLASS_NAME, using = "cart_quantity")
    private java.util.List<WebElement> cartItemQuantities;

    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(how = How.ID, using = "checkout")
    private WebElement checkoutButton;


    // Methods for cart actions and validations
    public void openCart() {
        cartIcon.click();
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public String getCartItemName(int index) {
        return cartItemNames.get(index).getText();
    }

    public String getCartItemPrice(int index) {
        return cartItemPrices.get(index).getText();
    }

    public String getCartItemQuantity(int index) {
        return cartItemQuantities.get(index).getText();
    }

    public boolean isProductInCart(String productName) {
        return cartItemNames.stream().anyMatch(e -> e.getText().equalsIgnoreCase(productName));
    }

    public void removeItemByName(String productName) {
        for (WebElement item : cartItems) {
            WebElement name = item.findElement(org.openqa.selenium.By.className("inventory_item_name"));
            if (name.getText().equalsIgnoreCase(productName)) {
                item.findElement(org.openqa.selenium.By.tagName("button")).click();
                break;
            }
        }
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

}