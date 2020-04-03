package samsonova.restful_main;

import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import static io.restassured.RestAssured.get;

public class RestDemoTest {
    @Test
    public void getRequestExampleTest() throws JSONException {
        Response response = get("http://google.com");
//        JSONArray jsonResponse = new JSONArray(response.asString());
//        String capital = jsonResponse.getJSONObject(0).getString("capital");
       // Assert.assertEquals(responseCode, 200);
    }



    }


