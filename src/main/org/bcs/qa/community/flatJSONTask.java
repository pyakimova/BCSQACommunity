package org.bcs.qa.community;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class flatJSONTask
{
    public static void main( String[] args ) throws IOException {
        JSONObject json = generateJSON();
        createJSONFile(json);
    }

    private static JSONObject generateJSON(){
        JSONObject json = new JSONObject();

        json.put("String", "qwe");
        json.put("StringEmpty", "");
        json.put("booleanTrue", true);
        json.put("booleanFalse", false);
        json.put("integer",999999999);
        json.put("double",9999999.555556);
        json.put("doubleE",9999999.999999999999);

        ArrayList<String> array = new ArrayList<>();
        array.add("arr0");
        array.add("arr1");
        json.put("array",array);
        ArrayList<String> arrayEmpty = new ArrayList<>();
        json.put("arrayEmpty",arrayEmpty);
/*
        HashMap map = new HashMap();
        map.put("mapString","asd");
        map.put("mapInteger",12345);
        json.put("map",map);

        objectForJSON object = new objectForJSON();
        json.put("object", object.toJSON());
*/
        return json;
    }

    private static void createJSONFile(JSONObject json) throws IOException {
        String fileName = RandomStringUtils.randomAlphanumeric(10) + ".json";
        Writer file = new FileWriter("src/main/org/bcs/qa/community/jsons/flatJSON" + fileName);
        json.write(file);
        file.close();
    }
}
