package kiabi.configurations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;

public enum CapabilitiesConfigReader {

    INSTANCE;

    private static final Logger LOG = LogManager.getLogger(CapabilitiesConfigReader.class);

    private static final String CONFIG_FILE_PATH = "config/capabilities.conf.json";

    private static final JsonNode node;

    static {
        try (JsonParser parser = new ObjectMapper().getFactory().createParser(new FileReader(CONFIG_FILE_PATH))) {
            node = parser.readValueAsTree();
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static CapabilitiesConfigReader getInstance() {
        return INSTANCE;
    }

    public DesiredCapabilities getDesiredCapabilities(String location, String platform, String device) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //TypeReference typeReference = new TypeReference<Map<String, String>>() {};

        // Map<String, String> capabilitiesMap = (Map<String, String>) new ObjectMapper().convertValue(this.getCapabilitiesJson(location, platform, device), typeReference);
        // capabilitiesMap.forEach(capabilities::setCapability);
        return capabilities;

    }

    private JsonNode getCapabilitiesJson(String location, String platform, String device) {
        return node.get(location.toLowerCase()).get(platform.toLowerCase()).get(device);
    }
}
