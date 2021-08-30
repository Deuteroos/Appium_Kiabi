package carrefour.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static carrefour.context.Properties.*;

public class LocalDriver implements Driver {

    private AppiumDriver<MobileElement> driver;

    public LocalDriver(String location, String platform, String device) {
        switch (platform) {
            case "ANDROID":
            case "ANDROID_EMULATOR":
                this.driver = createAndroidDriver(location, platform, device);
        }
    }

    public AppiumDriver<MobileElement> getDriver() {
        return this.driver;
    }

    public void closeDriver() {
        this.driver.close();
    }

    private AppiumDriver<MobileElement> createAndroidDriver(String location, String platform, String device) {
        DesiredCapabilities capabilities = Config.getCapabilities(location, platform, device);
        capabilities.setCapability(MobileCapabilityType.APP, FILE_PROPERTIES.applicationPath);
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

        return new AndroidDriver<>(Config.getAppiumUrl(), capabilities);
    }

    private static class Config {
        private static String APPIUM_HOST = FILE_PROPERTIES.appiumServerHost;
        private static String APPIUM_PORT = FILE_PROPERTIES.appiumServerPort;

        private static DesiredCapabilities getCapabilities(String location, String platform, String device) {
            return CAPABILITIES_CONFIG.getDesiredCapabilities(location, platform, device);
        }

        private static URL getAppiumUrl() {
            try {
                return new URL("http://" + APPIUM_HOST + ":" + APPIUM_PORT + "/wd/hub");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
