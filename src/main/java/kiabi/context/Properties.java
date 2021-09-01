package kiabi.context;

import kiabi.configurations.CapabilitiesConfigReader;
import kiabi.configurations.PropertiesConfiguration;
import kiabi.configurations.SystemPropertiesReader;

public interface Properties {
    CapabilitiesConfigReader CAPABILITIES_CONFIG = CapabilitiesConfigReader.getInstance();
    SystemPropertiesReader SYSTEM_PROPERTIES = SystemPropertiesReader.getInstance();
    PropertiesConfiguration FILE_PROPERTIES = PropertiesConfiguration.getInstance();
}
