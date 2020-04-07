package samsonova.restful_main;

import samsonova.restful.Rest;

public class RestDemoTest {
    public static void main(String[] args) throws Exception {
        Rest rest = new Rest();

        //get request, returns status and response body
        String url1 = "https://www.google.com";
        rest.get(url1);

        //get request, returns status and response body (as file with predefined path)
        String uri = "https://www.google.com";
        rest.getResponseAsFile(uri);

        //post request, returns status
        String url2 = "https://httpbin.org/post";
        String data = "{\"lastName\":\"Doe\",\"birthdate\":\"03.03.1991\",\"age\":\"29\"}";
        rest.post(url2, data);

        //get request with predefined URL
        System.out.println("Sending Http GET request: ");
        rest.sendGet();

        //post request with predefined URL
        System.out.println("Sending Http POST request: ");
        rest.sendPost();
    }
}