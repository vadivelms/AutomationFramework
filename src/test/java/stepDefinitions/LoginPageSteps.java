package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginPageSteps {
    TestContext testContext;
    LoginPage loginPage;

    public LoginPageSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("user is on the SauceDemo login page")
    public void user_is_on_login_page() {
        // Implement navigation if needed
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }
}
