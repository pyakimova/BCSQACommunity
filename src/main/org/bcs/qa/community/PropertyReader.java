package org.bcs.qa.community;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Реализовать метод getProperties(String propName, String filePath) который будет читать свойство из указанного файла
 * Реализовать метод getProperties(String propName) который будет читать свойство из дефолтного файла
 */
public class PropertyReader {
    public static void main(String[] args) {
        String propNameEmail = "email";
        String firstName = "firstname";
        String filePath = "src/test/resources/propertyReader.json";
        System.out.println(getProperties(firstName));
        System.out.println(getProperties(propNameEmail, filePath));
    }

    private static String getProperties(String propName, String filePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject.get(propName).toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "fuck";
    }

    private static String getProperties(String propName) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/propertyReader.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject.get(propName).toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "fuck";
    }
}
