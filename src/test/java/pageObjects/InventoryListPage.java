package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class InventoryListPage {
    public InventoryListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "inventory_list")
    private WebElement inventoryList;

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "inventory_item"))
    private List<WebElement> inventoryItems;

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "inventory_item_name"))
    private List<WebElement> itemNames;

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "inventory_item_price"))
    private List<WebElement> itemPrices;

    @FindAll(@FindBy(how = How.CSS, using = ".btn_inventory"))
    private List<WebElement> addToCartButtons;

    public int getInventoryItemCount() {
        return inventoryItems.size();
    }

    public String getItemName(int index) {
        return itemNames.get(index).getText();
    }

    public String getItemPrice(int index) {
        return itemPrices.get(index).getText();
    }

    public void addItemToCart(int index) {
        addToCartButtons.get(index).click();
    }

    public void addItemToCartByName(String itemName) {
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().equalsIgnoreCase(itemName)) {
                addToCartButtons.get(i).click();
                break;
            }
        }
    }

    public boolean isItemPresent(String itemName) {
        return itemNames.stream().anyMatch(e -> e.getText().equalsIgnoreCase(itemName));
    }

    public boolean isInventoryListDisplayed() {
        return inventoryList.isDisplayed();
    }
}
