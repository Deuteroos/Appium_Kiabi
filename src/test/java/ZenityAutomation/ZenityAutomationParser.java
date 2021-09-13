package ZenityAutomation;

import org.json.JSONObject;
import org.reflections8.Reflections;
import org.reflections8.scanners.MethodAnnotationsScanner;
import org.reflections8.scanners.SubTypesScanner;
import org.reflections8.util.ClasspathHelper;
import org.reflections8.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ZenityAutomationParser {

    enum Color {
        RESET("\033[0m"),
        RED("\033[0;31m"),
        GREEN("\033[0;32m"),
        YELLOW("\033[0;33m"),
        BLUE("\033[0;34m"),
        MAGENTA("\033[0;35m"),
        CYAN("\033[0;36m");

        private final String code;

        Color(String code) {
            this.code = code;
        }

        String get() {
            return this.code;
        }
    }

    private static ZenityAutomationDatabaseManager databaseManager;

    public static void main(String... args) {
        try {
            databaseManager = new ZenityAutomationDatabaseManager();
            Reflections reflections = new Reflections(new ConfigurationBuilder()
                    .setUrls(ClasspathHelper.forPackage("steps"))
                    .setScanners(new MethodAnnotationsScanner(), new SubTypesScanner()));

            Set<Method> methodsAnnotatedWith = reflections.getMethodsAnnotatedWith(AutomationModule.class);
            ArrayList<String> modulesList = new ArrayList<>();
            modulesList.add("Start");

            System.out.println(Color.YELLOW.get() + "Retrieving automated modules...");

            for (Method method : methodsAnnotatedWith) {

                String moduleName = method.getAnnotation(AutomationModule.class).moduleName().replaceAll("'", "''");
                String moduleDescription = method.getAnnotation(AutomationModule.class).moduleDescription().replaceAll("'", "''");
                String moduleCategory = method.getAnnotation(AutomationModule.class).category().replaceAll("'", "''");
                modulesList.add(moduleName);
                JSONObject moduleOutputs = parseModuleOutputs(method.getAnnotation(AutomationModule.class).outputs());
                JSONObject moduleInputs = parseModuleInputs(method.getAnnotation(AutomationModule.class).inputs());

                JSONObject jsonModuleParameters = new JSONObject();
                ModuleParameters[] methodParameters = method.getAnnotation(AutomationModule.class).parameters();

                for (int i = 0; i < methodParameters.length; i++) {
                    JSONObject parameter = new JSONObject();

                    parameter.put("type", methodParameters[i].type());
                    parameter.put("label", methodParameters[i].label().replaceAll("'", "''"));
                    parameter.put("drivenBy", methodParameters[i].drivenBy().toString().toLowerCase());

                    if (methodParameters[i].choices().length > 0) {
                        List<String> choicesList = new ArrayList<>(Arrays.asList(methodParameters[i].choices()));
                        parameter.put("choices", choicesList);
                    }

                    jsonModuleParameters.put(String.valueOf(i + 1), parameter);
                }

                databaseManager.updateProjectModules(moduleName, moduleDescription, moduleOutputs, moduleInputs, jsonModuleParameters, moduleCategory);
            }

            for (ModulesConnections moduleConfig : ModulesConnections.values()) {
                databaseManager.updateProjectModulesConfiguration(moduleConfig);
            }

            System.out.println(Color.RESET.get() + "\nFound modules : " + Color.GREEN.get());
            modulesList.forEach(System.out::println);

            databaseManager.removeOldModules(modulesList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static JSONObject parseModuleOutputs(String[] outputs) {
        return parseModuleIO(outputs);
    }

    private static JSONObject parseModuleInputs(String[] inputs) {
        return parseModuleIO(inputs);
    }

    private static JSONObject parseModuleIO(String[] arguments) {
        JSONObject serializedIO = new JSONObject();

        for (int j = 0; j < arguments.length + 1; j++) {
            JSONObject outputObject = new JSONObject();
            if (j == 0) {
                outputObject.put("type", "flow");
                outputObject.put("name", "");
                outputObject.put("color", "#4EA9FF");
            } else {
                ModulesConnections module = ModulesConnections.valueOf(arguments[j - 1].toUpperCase());

                outputObject.put("type", arguments[j - 1]);
                outputObject.put("name", module.displayLabel);
                outputObject.put("color", module.color);
            }
            serializedIO.put(String.valueOf(j + 1), outputObject);
        }
        return serializedIO;
    }
}
