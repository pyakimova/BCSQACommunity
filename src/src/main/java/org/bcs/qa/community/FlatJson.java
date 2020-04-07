package org.bcs.qa.community;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Реализовать метод, который будет генерировать плоский JSON( с 0 вложенностью)
 * Пусть он сохраняет все это в файл
 */
public class FlatJson {
    public static void main(String[] args) {
        JsonObject rootObject = new JsonObject();
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        rootObject.addProperty("message", "fuckingJson");
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            StringBuilder property = new StringBuilder();
            StringBuilder value = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                property.append(symbols.charAt(random.nextInt(symbols.length() - 1)));
                value.append(symbols.charAt(random.nextInt(symbols.length() - 1)));
            }
            rootObject.addProperty(property.toString(), value.toString());
        }
        Gson gson = new Gson();
        String json = gson.toJson(rootObject);

        try (FileWriter file = new FileWriter("src/test/resources/fileFlatJson.json")) {
            file.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}