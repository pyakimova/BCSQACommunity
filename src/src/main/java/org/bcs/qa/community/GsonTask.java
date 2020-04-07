package org.bcs.qa.community;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * https://sites.google.com/site/gson/gson-user-guide
 * Использую библиотеку GSon нужно сериализовать и десиреализовать какой нибудь Json
 * Нужно написать методы по получению / изменению / удалению параметров у Json
 * Сохранить полученный Json в файл
 */
public class GsonTask {
    public static void main(String[] args) {
        Employee employeeTest = new Employee(7777, "Василий", "Пупкин", "gsonserialization@gmail.com");
        Gson gson = new Gson();
        String jsonString = gson.toJson(employeeTest);
        System.out.println(jsonString);

        try (FileWriter file = new FileWriter("src/test/resources/fileGsonTask.json")) {
            file.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(getParamsFirstname(jsonString));
        System.out.println(updateParamFirstname(jsonString));
        deleteParams(jsonString);
    }

    private static String getParamsFirstname(String jsonString) {
        Gson gsonDeser = new Gson();
        Employee employee = gsonDeser.fromJson(jsonString, Employee.class);
        return employee.getFirstname();
    }

    private static String updateParamFirstname(String jsonString) {
        Gson gsonDeser = new Gson();
        Employee employee = gsonDeser.fromJson(jsonString, Employee.class);
        employee.setFirstname("Инокентий");
        jsonString = gsonDeser.toJson(employee);
        try (FileWriter file = new FileWriter("src/test/resources/fileGsonTask.json")) {
            file.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    private static void deleteParams(String jsonString) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/fileGsonTask.json"));
            JSONObject jsonObject = (JSONObject) obj;
            jsonObject.remove("email");
            System.out.println(jsonObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}