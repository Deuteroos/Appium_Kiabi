package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features",
        glue = {"steps"},
        tags = "@sanity3",
        plugin = {
                "pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        }
)
public class TestRunner extends BaseRunner{
}
