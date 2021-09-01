package kiabi.manager;

import kiabi.drivers.Driver;
import kiabi.drivers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static kiabi.context.Properties.SYSTEM_PROPERTIES;

public class AndroidDriverManager {

    private static final AndroidDriverManager INSTANCE = new AndroidDriverManager();

    private static ThreadLocal<Driver> driver = new ThreadLocal<>();

    private AndroidDriverManager() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver.get().getDriver();
    }

    public static void setDriver(String device) {
        driver.set(DriverFactory.getDriver(SYSTEM_PROPERTIES.location, SYSTEM_PROPERTIES.platform, device));
    }

    public static AndroidDriverManager getInstance() {
        return INSTANCE;
    }
}