package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListingPage {

    public ProductListingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
    private WebElement btn_AddToCart;

    @FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
    private List<WebElement> prd_List;
    @FindBy(how = How.ID, using = "pa_color")
    private WebElement color_DrpDwn;
    @FindBy(how = How.ID, using = "pa_size")
    private WebElement size_DrpDwn;

    public void clickOn_AddToCart() {
        btn_AddToCart.click();
    }

    public void select_Product(int productNumber) {
        prd_List.get(productNumber).click();
    }

    public void select_Color(int index) {
        Select color = new Select(color_DrpDwn);
        color.selectByIndex(index);
    }

    public void select_Size(int index) {
        Select color = new Select(size_DrpDwn);
        color.selectByIndex(index);
    }
    public String getProductName(int productNumber) {
        return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
    }
}
