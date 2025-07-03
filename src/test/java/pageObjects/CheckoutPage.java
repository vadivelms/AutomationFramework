package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;
import testDataTypes.Customer;

import java.util.List;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "first-name")
    private WebElement firstNameInput;

    @FindBy(how = How.ID, using = "last-name")
    private WebElement lastNameInput;

    @FindBy(how = How.ID, using = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(how = How.ID, using = "continue")
    private WebElement continueButton;

    @FindBy(how = How.ID, using = "cancel")
    private WebElement cancelButton;

    @FindBy(how = How.ID, using = "finish")
    private WebElement finishButton;

    @FindBy(how = How.CLASS_NAME, using = "summary_total_label")
    private WebElement summaryTotalLabel;

    @FindBy(how = How.CLASS_NAME, using = "complete-header")
    private WebElement completeHeader;

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public String getSummaryTotal() {
        return summaryTotalLabel.getText();
    }

    public boolean isCheckoutComplete() {
        return completeHeader.isDisplayed();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

}
