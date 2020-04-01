package samsonova.flat_json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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

    public static void generateFlatJson(HashMap<String, String> hashMap) {
        String start = "{ ";
        String end = " }";
        StringBuilder allLinesBuilder = new StringBuilder(start);

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String value = entry.getValue();

            if (isDigit(value) || value.equals("null")) {
                allLinesBuilder.append(", ").append("\"").append(entry.getKey()).append("\"").append(" : ").
                        append(entry.getValue());
            } else {
                allLinesBuilder.append(", ").append("\"").append(entry.getKey()).append("\"").append(" : ").append("\"").
                        append(entry.getValue()).append("\"");
            }
        }

        allLinesBuilder.append(end);
        allLinesBuilder.replace(2, 4, "");

        try (FileWriter writer = new FileWriter("src/newJson", false)) {
            writer.write(allLinesBuilder.toString());
            writer.flush();
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}



