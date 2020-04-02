package samsonova.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;

public class GsonClass {
    public static String getParameterValue(String parameter, String json) {
        JsonObject newObj = new JsonParser().parse(json).getAsJsonObject();
        JsonElement param = newObj.get(parameter);

        if (param != null) {
            return param.toString();
        }

        return "Параметр не найден";
    }

    public static String setParameterValue(String parameter, String newValue, String json) {
        JsonObject newObj = new JsonParser().parse(json).getAsJsonObject();
        newObj.addProperty(parameter, newValue);

        Gson gson = new Gson();

        return gson.toJson(newObj);
    }

    public static String deleteParameter(String parameter, String json) {
        JsonObject newObj = new JsonParser().parse(json).getAsJsonObject();

        if (newObj.has(parameter)) {
            newObj.remove(parameter);
        }

        Gson gson = new Gson();

        return gson.toJson(newObj);
    }

    public static void writeJsonToFile(String json, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(json);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}