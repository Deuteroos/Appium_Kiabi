package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features",
        glue = {"steps"},
        tags = "@sanity3",
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "json:target/cucumber-reports/Cucumber.json"
        }
)
public class TestRunner extends BaseRunner{
}
