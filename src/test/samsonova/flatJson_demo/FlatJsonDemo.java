package samsonova.flatJson_demo;

import samsonova.flat_json.FlatJson;

import java.util.LinkedHashMap;
import java.util.Map;

public class FlatJsonDemo {
    public static void main(String[] args) {
        Map<String, String> myHashMap = new LinkedHashMap<>();
        myHashMap.put("property1", "abc");
        myHashMap.put("property2", "def");
        myHashMap.put("property3", "hhh");
        myHashMap.put("property4", "222");
        myHashMap.put("property5", "null");

        FlatJson.generateFlatJson(myHashMap);  //src.newJson.json
    }
}