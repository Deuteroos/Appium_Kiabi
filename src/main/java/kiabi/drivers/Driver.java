package kiabi.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface Driver {

    AppiumDriver<MobileElement> getDriver();

    void closeDriver();

    default DesiredCapabilities androidDesiredCapabilities() {
        return new DesiredCapabilities();
    }

}
