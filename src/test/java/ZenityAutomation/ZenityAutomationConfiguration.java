package ZenityAutomation;

import java.util.HashMap;

public class ZenityAutomationConfiguration {

    public static final HashMap<String, ModuleParameterType> userParameters = new HashMap<String, ModuleParameterType>() {{
        put("Nom d''utilisateur", ModuleParameterType.STRING);
        put("Mot de passe", ModuleParameterType.STRING);
    }};

    public static final HashMap<String, ModuleParameterType> bugParameters = new HashMap<String, ModuleParameterType>() {{
        put("Nom d''utilisateur", ModuleParameterType.STRING);
        put("Mot de passe", ModuleParameterType.STRING);
    }};

    public static final HashMap<String, ModuleParameterType> searchParameters = new HashMap<String, ModuleParameterType>() {{
        put("Nom d''utilisateur", ModuleParameterType.STRING);
        put("Mot de passe", ModuleParameterType.STRING);
    }};
}
