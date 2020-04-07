package samsonova.flat_json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FlatJson {
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void generateFlatJson(Map<String, String> hashMap) {
        final int REPLACEMENT_START_INDEX = 2;
        final int REPLACEMENT_END_INDEX = 4;
        String startJson = "{ ";
        String endJson = " }";
        String replaceStartComma = "";

        StringBuilder allLinesBuilder = new StringBuilder(startJson);

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            if (isDigit(value) || value.equals("null")) {
                allLinesBuilder.append(", ").append("\"").append(key).append("\"").append(" : ").
                        append(value);
            } else {
                allLinesBuilder.append(", ").append("\"").append(key).append("\"").append(" : ").
                        append("\"").append(value).append("\"");
            }
        }

        allLinesBuilder.append(endJson);
        allLinesBuilder.replace(REPLACEMENT_START_INDEX, REPLACEMENT_END_INDEX, replaceStartComma);

        try (FileWriter writer = new FileWriter("src/newJson.json", false)) {
            writer.write(allLinesBuilder.toString());
            writer.flush();
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void generateFlatJson1(String[] objectFields, String[] fieldsValues) {
        final int REPLACEMENT_START_INDEX = 2;
        final int REPLACEMENT_END_INDEX = 4;
        String startJson = "{ ";
        String endJson = " }";
        String replaceStartComma = "";
        StringBuilder allLinesBuilder = new StringBuilder(startJson);

        for (int i = 0; i < objectFields.length; i++) {
            if (isDigit(fieldsValues[i]) || fieldsValues[i].equals("null")) {
                allLinesBuilder.append(", ").append("\"").append(objectFields[i]).append("\"").append(" : ").
                        append(fieldsValues[i]);
            } else {
                allLinesBuilder.append(", ").append("\"").append(objectFields[i]).append("\"").append(" : ").
                        append("\"").append(fieldsValues[i]).append("\"");
            }
        }

        allLinesBuilder.append(endJson);
        allLinesBuilder.replace(REPLACEMENT_START_INDEX, REPLACEMENT_END_INDEX, replaceStartComma);

        try (FileWriter writer = new FileWriter("src/newJson1.json", false)) {
            writer.write(allLinesBuilder.toString());
            writer.flush();
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}