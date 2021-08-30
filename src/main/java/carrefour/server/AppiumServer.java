package carrefour.server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;

import static carrefour.context.Properties.FILE_PROPERTIES;

public class AppiumServer {

    private static final Logger LOG = LoggerFactory.getLogger(AppiumServer.class);

    private static String APPIUM_HOST = FILE_PROPERTIES.appiumServerHost;
    private static String APPIUM_PORT = FILE_PROPERTIES.appiumServerPort;

    private static AppiumDriverLocalService localService;

    public static void start() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress(APPIUM_HOST)
                .usingPort(Integer.parseInt(APPIUM_PORT))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.RELAXED_SECURITY);

        localService = AppiumDriverLocalService.buildService(serviceBuilder);
        localService.start();
        LOG.info("- - - - - - - - Starting Appium Server - - - - - - - - - -");
    }

    public static void stop() {
        try {
            localService.stop();
            LOG.info("- - - - - - - Appium server has been stopped - - - - - - - - - ");
        } catch (Exception e) {
            LOG.error("- - - - - - - Stopping appium server has failed - - - - - - - - ");
        }
    }

    public static boolean isRunning() {
        try {
            new ServerSocket(Integer.parseInt(APPIUM_PORT)).close();
        } catch (IOException e) {
            return true;
        }
        return false;
    }
}
