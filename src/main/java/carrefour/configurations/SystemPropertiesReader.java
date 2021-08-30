package carrefour.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SystemPropertiesReader {

    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemPropertiesReader.class);

    private static final String PLATFORM_KEY = "platform";
    private static final String LOCATION_KEY = "location";
    private static final String DEVICE_KEY = "device";

    public final String platform;
    public final String location;
    public final String device;

    SystemPropertiesReader() {
        this.platform = System.getProperty(PLATFORM_KEY, "android").toUpperCase();
        this.location = System.getProperty(LOCATION_KEY, "local").toUpperCase();
        this.device = System.getProperty(DEVICE_KEY, "pixel_2");
    }

    public static SystemPropertiesReader getInstance() {
        return INSTANCE;
    }
}
