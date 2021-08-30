package carrefour.configurations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public enum PropertiesConfiguration {

    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(PropertiesConfiguration.class);

    private static final String PROPERTIES_FILENAME = "application.properties";
    private static final String PROPERTIES_LOCATION = "config/" + PROPERTIES_FILENAME;

    private Properties properties;

    public final String applicationPath;

    public final String appiumServerHost;
    public final String appiumServerPort;

    public static PropertiesConfiguration getInstance() {
        return INSTANCE;
    }

    PropertiesConfiguration() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTIES_LOCATION))) {
            this.properties = new Properties();
            this.properties.load(reader);

            this.applicationPath = readProperty("applicationPath");
            this.appiumServerHost = readProperty("appiumServerHost");
            this.appiumServerPort = readProperty("appiumServerPort");


        } catch (IOException e) {
            throw new IllegalArgumentException("application.properties not found in resources folder");
        }
    }

    private String readProperty(String key) {
        String property = this.properties.getProperty(key);
        if (property == null) {
            LOGGER.warn("{} value is missing in config.properties", key);
        }
        return property;
    }
}
