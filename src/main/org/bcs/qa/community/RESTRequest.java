package org.bcs.qa.community;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        String url = "https://www.google.com";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", USER__AGENT);
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


    }
}
