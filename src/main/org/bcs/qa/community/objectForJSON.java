package org.bcs.qa.community;

import org.json.JSONObject;

public class objectForJSON {
    int objectInt;
    String objectString;

    public objectForJSON(){
        objectInt = 888888888;
        objectString = "88888888";
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("objectInt",objectInt);
        json.put("objectString",objectString);
        return json;
    }
}
