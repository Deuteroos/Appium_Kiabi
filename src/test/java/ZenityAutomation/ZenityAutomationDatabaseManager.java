package ZenityAutomation;

import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

public class ZenityAutomationDatabaseManager {

    private static Connection connection;
    private static final String projectName = "Appium_Kiabi";
    private static final String projectKey = "L3ZRLT1XI57WWBEZ";
    private static long projectId;

    private void getProject() throws SQLException {
        String selectQuery = "SELECT project_id FROM public.projects WHERE project_key = '" + projectKey + "' AND name = '" + projectName + "';";
        ResultSet selectResult = queryDatabase(selectQuery);

        if (selectResult.next())
            projectId = Long.parseLong(selectResult.getString(1));
        else
            throw new SQLException("Could not find project " + projectName + " with key " + projectKey);
    }

    public void setDatabase() throws SQLException {
        String host = "127.0.0.1";
        String user = "postgres";
        String password = "2009";
        String database = "Zenity_automationTool";
        String url = "jdbc:postgresql://" + host + ":5432/" + database;

        connection = DriverManager.getConnection(url, user, password);

        getProject();
    }

    public ZenityAutomationDatabaseManager() throws SQLException {
        setDatabase();
    }

    public void updateProjectModules(String moduleName, String moduleDescription, JSONObject moduleOutputs, JSONObject moduleInputs, JSONObject moduleParameters, String category) throws SQLException {
        String updateQuery = "UPDATE public.testmodules SET(\"moduleinputs\",\"label\",\"description\",\"moduleoutputs\",\"moduleparameters\", \"category\") = ('" + moduleInputs.toString() + "','" + moduleName + "','" + moduleDescription + "','" + moduleOutputs.toString() + "','" + moduleParameters.toString() + "','" + category + "') WHERE \"project_id\" = '" + projectId + "' AND \"label\" = '" + moduleName + "';";
        String selectQuery = "SELECT testmodule_id FROM public.testmodules WHERE \"project_id\" = '" + projectId + "' AND \"label\" = '" + moduleName + "';";
        String insertQuery = "INSERT INTO public.testmodules (\"moduleinputs\",\"label\",\"description\",\"moduleoutputs\",\"project_id\", \"moduleparameters\", \"category\") VALUES ('" + moduleInputs.toString() + "','" + moduleName + "','" + moduleDescription + "','" + moduleOutputs.toString() + "','" + projectId + "', '" + moduleParameters.toString() + "','" + category + "');";

        ResultSet selectResult = queryDatabase(selectQuery);

        if (selectResult.next())
            queryDatabase(updateQuery);
        else
            queryDatabase(insertQuery);
    }

    public void removeOldModules(ArrayList<String> modulesList) throws SQLException {
        String selectQuery = "SELECT testmodule_id FROM public.testmodules WHERE \"project_id\" = '" + projectId + "'";
        String selectModuleQuery = "SELECT label FROM public.testmodules WHERE \"project_id\" = '" + projectId + "' AND \"testmodule_id\" = '%s';";
        String queryConditions = " AND \"label\" != '%s'";
        String deleteQuery = "DELETE FROM public.testmodules WHERE \"testmodule_id\" = '%s'";

        ArrayList<String> deletedModulesList = new ArrayList<>();

        for (String module : modulesList) {
            selectQuery = selectQuery.concat(String.format(queryConditions, module));
        }

        ResultSet selectResult = queryDatabase(selectQuery);

        while (selectResult.next()) {
            ResultSet selectModuleResult = queryDatabase(String.format(selectModuleQuery, selectResult.getString(1)));
            selectModuleResult.next();
            deletedModulesList.add(selectModuleResult.getString(1));

            queryDatabase(String.format(deleteQuery, selectResult.getString(1)));
        }

        if (deletedModulesList.size() > 0) {
            System.out.println(ZenityAutomationParser.Color.RESET.get() + "\nDeleted old modules : " + ZenityAutomationParser.Color.RED.get());
            deletedModulesList.forEach(System.out::println);
        }
    }

    public void updateProjectModulesConfiguration(ModulesConnections moduleConfig) throws SQLException {
        JSONObject jsonParameters = new JSONObject(moduleConfig.parameters);

        String updateQuery = "UPDATE public.projectmoduleconfiguration SET(\"iocolor\",\"iolabel\",\"ioparameters\") = ('" + moduleConfig.color + "','" + moduleConfig.displayLabel + "','" + jsonParameters.toString() + "') WHERE \"project_id\" = '" + projectId + "' AND \"iotype\" = '" + moduleConfig.toString() + "';";
        String selectQuery = "SELECT moduleconfiguration_id FROM public.projectmoduleconfiguration WHERE \"project_id\" = '" + projectId + "' AND \"iotype\" = '" + moduleConfig.toString() + "';";
        String insertQuery = "INSERT INTO public.projectmoduleconfiguration (\"iocolor\",\"iolabel\",\"ioparameters\",\"iotype\",\"project_id\") VALUES ('" + moduleConfig.color + "','" + moduleConfig.displayLabel + "','" + jsonParameters.toString() + "','" + moduleConfig.toString() + "','" + projectId + "');";

        ResultSet selectResult = queryDatabase(selectQuery);

        if (selectResult.next())
            queryDatabase(updateQuery);
        else
            queryDatabase(insertQuery);
    }


    public ResultSet queryDatabase(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException ignored) {
        }
        return null;
    }
}
