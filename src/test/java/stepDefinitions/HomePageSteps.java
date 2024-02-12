package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;

public class HomePageSteps {
    TestContext testContext;
    HomePage homePage;
    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("user is on Home Page")
    public void user_is_on_home_page() {

        homePage.navigateTo_HomePage();
    }

    @When("he search for {string}")
    public void he_search_for(String arg1) {
        homePage.perform_Search(arg1);

    }
}
