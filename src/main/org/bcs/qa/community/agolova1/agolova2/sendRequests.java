package agolova2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import static io.restassured.RestAssured.get;

public class sendRequests {

    public void sendPostRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("proposalName", "Инвестиционное преложение от 30.03.2020");
        requestBody.put("sumOfInvestment", 15000);
        requestBody.put("currency" , "USD");
        requestBody.put("riskProfile", "Conservative");
        requestBody.put("termOfInvestment",24);
        requestBody.put("excpectedReturn", 0.14);
        requestBody.put("var", 0.12);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("здесь ссыль");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }

    public void sendGetRequest() {
        String link = "здесь ссыль";
        Response response = get(link);
        JSONArray jsonResponse = new JSONArray(response.asString());
        System.out.println(jsonResponse);
    }
}
