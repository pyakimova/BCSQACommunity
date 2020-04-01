package org.bcs.qa.community;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * С помощью любой библиотеки реализовать методы по отправке REST запросов
 */
public class RESTRequest {
    private final String USER__AGENT = "Chrome/80.0.3987.149";

    public static void main(String[] args) throws Exception {
        RESTRequest http = new RESTRequest();
        System.out.println("Send Http GET request");
        http.sendGet();

        System.out.println("\n");
        System.out.println("Send Http POST request");
        http.sendPost();
    }

    private void sendGet() throws Exception {
        String url = "https://www.google.com/search?q=rest";
        URL obj = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER__AGENT);

        int responseCode = connection.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
    }

    private void sendPost() throws Exception {
        URL url = new URL ("http://example.com/index.php");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");

        con.setDoOutput(true);
        String jsonInputString = "{\"name\": \"Anton\", \"job\": \"QAengineer\"}";
        try(OutputStream os = con.getOutputStream()){
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int code = con.getResponseCode();
        System.out.println(code);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
}