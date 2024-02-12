package cucumber;

import lombok.Getter;
import managers.PageObjectManager;
import managers.WebDriverManager;

@Getter
public class TestContext {
    private final WebDriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        scenarioContext = new ScenarioContext();
    }

}
