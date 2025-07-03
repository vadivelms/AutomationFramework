package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.FileReaderManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void beforeSteps() {
        System.out.println("----------- BeforeSteps");
        testContext.getWebDriverManager().getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    @After
    public void afterSteps(Scenario scenario) {
        String status = String.valueOf(scenario.getStatus());
        System.out.println("status : ---" + status);
        if (!status.equals("PASSED")) {
            scenario.attach(((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES),
                    "image/png", "Screenshot for the failed/broken step");
            System.out.println("----- saved SS");
        }
        testContext.getWebDriverManager().closeDriver();
    }
}
