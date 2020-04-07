package main.org.bcs.qa.community.rezyapkinaes;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class flatJson {
    public static void main(String[] args) {
        System.out.println("Created flat JSON:");
        creatorOfJson();
    }

    private static void creatorOfJson() {
    JSONObject j = new JSONObject();
    j.put("firstName", "Olive");
    j.put("lastName", "Oil");
    j.put("matchesPfpCriteria", "true");
    j.put("summOfActives", "999,99");

    System.out.print(j.toString());

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        try {
            PrintWriter out = new PrintWriter(Paths.get("").toAbsolutePath().toString() + "\\src\\generatedJsonFiles\\flatJsonTest.json");
            out.write(j.toString());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
/*Реализовать метод, который будет генерировать плоский JSON(с 0 вложенностью)
Пусть он сохраняет все это в файл*/