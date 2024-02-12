package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
//@SelectClasspathResource("com/koushick/BDD/Steps")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/End2End_Test.feature")
//@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "com/koushick/BDD/Steps")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@googleSearch")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report/cucumber.html")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")

public class TestRunnerV1 {
}
