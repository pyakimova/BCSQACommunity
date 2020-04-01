package samsonova.properties_reader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.Scanner;

public class MyPropReader {
    public static String getProperties(String propName, String filePath) throws FileNotFoundException {
        String allLines;

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            StringBuilder allLinesBuilder = null;

            while (scanner.hasNextLine()) {
                String scannedString = scanner.nextLine();

                if (allLinesBuilder == null) {
                    allLinesBuilder = new StringBuilder(scannedString);
                } else {
                    allLinesBuilder.append(scannedString);
                }
            }

            assert allLinesBuilder != null;
            allLines = allLinesBuilder.toString();

            JsonObject newObj = new JsonParser().parse(allLines).getAsJsonObject();
            JsonElement param = newObj.get(propName);

            if (param != null) {
                return param.toString();
            }

            return "Параметр не найден";
        }
    }

    public static String getProperties(String propName) throws FileNotFoundException {
        String allLines;

        try (Scanner scanner = new Scanner(new FileInputStream("src/out.json"))) {
            StringBuilder allLinesBuilder = null;

            while (scanner.hasNextLine()) {
                String scannedString = scanner.nextLine();

                if (allLinesBuilder == null) {
                    allLinesBuilder = new StringBuilder(scannedString);
                } else {
                    allLinesBuilder.append(scannedString);
                }
            }

            assert allLinesBuilder != null;
            allLines = allLinesBuilder.toString();

            JsonObject newObj = new JsonParser().parse(allLines).getAsJsonObject();
            JsonElement param = newObj.get(propName);

            if (param != null) {
                return param.toString();
            }

            return "Параметр не найден";
        }
    }
}
//    Реализовать метод getProperties(String propName, String filePath) который будет читать свойство из указанного файла
//    Реализовать метод getProperties(String propName) который будет читать свойство из дефолтного файла