package samsonova.restful_main;

import samsonova.restful.Rest;

public class RestDemoTest {
    public static void main(String[] args) throws Exception {
        Rest rest = new Rest();

        //returns response body
        rest.get("https://www.google.com");

        //returns response body as file with predefined path
        rest.getResponseAsFile("https://www.google.com");

        //request with predefined URL
        System.out.println("Send Http GET request: ");
        rest.sendGet();

        //request with predefined URL
        System.out.println("Send Http POST request: ");
        rest.sendPost();
    }
}