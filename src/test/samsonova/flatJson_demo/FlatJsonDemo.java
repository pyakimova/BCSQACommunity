package samsonova.flatJson_demo;

import samsonova.flat_json.FlatJson;

import java.util.HashMap;

public class FlatJsonDemo {
    public static void main(String[] args) {
        HashMap<String, String> myHashMap = new HashMap<>();
        myHashMap.put("property1", "abc");
        myHashMap.put("property2", "def");
        myHashMap.put("property3", "hhh");
        myHashMap.put("property4", "22");
        myHashMap.put("property5", "null");

        FlatJson.generateFlatJson(myHashMap);
    }
}
