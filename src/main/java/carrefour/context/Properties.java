package carrefour.context;

import carrefour.configurations.CapabilitiesConfigReader;
import carrefour.configurations.PropertiesConfiguration;
import carrefour.configurations.SystemPropertiesReader;

public interface Properties {
    CapabilitiesConfigReader CAPABILITIES_CONFIG = CapabilitiesConfigReader.getInstance();
    SystemPropertiesReader SYSTEM_PROPERTIES = SystemPropertiesReader.getInstance();
    PropertiesConfiguration FILE_PROPERTIES = PropertiesConfiguration.getInstance();
}
