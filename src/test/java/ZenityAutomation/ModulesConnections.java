package ZenityAutomation;

import java.util.HashMap;

public enum ModulesConnections {
    FLOW("#4EA9FF", "Flow", new HashMap<>()),
    USER("#D69F2F", "Utilisateur", ZenityAutomationConfiguration.userParameters),
    BUG("#CC162F", "Bug", ZenityAutomationConfiguration.bugParameters),
    SEARCH("#CD162F", "Search", ZenityAutomationConfiguration.searchParameters);

    String color;
    String displayLabel;
    HashMap<String, ModuleParameterType> parameters;

    ModulesConnections(String color, String displayLabel, HashMap<String, ModuleParameterType> parameters) {
        this.color = color;
        this.displayLabel = displayLabel;
        this.parameters = parameters;
    }
}
