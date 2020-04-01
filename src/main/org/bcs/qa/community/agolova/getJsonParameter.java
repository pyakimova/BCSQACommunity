package agolova;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class getJsonParameter{

    public static void main(String args[]) throws IOException {

        getJsonParameter();
    }

    public static void getJsonParameter() throws IOException {
        String filePath = "C:\\Users\\sasib\\OneDrive\\Documents\\GitHub\\BCSQACommunity1\\serialization.txt";
        String json = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println(jsonObj.get("proposalName"));



    }




    }

