package runners;

import carrefour.manager.AndroidDriverManager;
import carrefour.server.AppiumServer;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;

import static carrefour.context.Properties.SYSTEM_PROPERTIES;

public class BaseRunner extends AbstractTestNGCucumberTests {

    @Parameters({"device"})
    @BeforeClass
    public void beforeSuite(@Optional("pixel_2") String device) {
        if (!AppiumServer.isRunning() && this.isLocal()) {
            AppiumServer.start();
        }
        AndroidDriverManager.setDriver(device);
    }

    @AfterClass
    public void afterSuite() {
        AndroidDriverManager.getDriver().quit();
        if (AppiumServer.isRunning() && !this.isLocal()) {
            AppiumServer.stop();
        }
    }

    @After
    public void ITestResults(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            BaseRunner.saveScreenShotPNG();
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    public static void saveScreenShotPNG() {
        Allure.addAttachment("screenshot", new ByteArrayInputStream(((TakesScreenshot) AndroidDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    private boolean isLocal() {
        return SYSTEM_PROPERTIES.location.toLowerCase().equals("local");
    }
}
