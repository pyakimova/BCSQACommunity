package agolova2;

import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeserializationProcess {

    public static void main(String args[]) throws Exception {

        deserializationJson();
    }

    public static void deserializationJson() throws Exception {
        agolova2.Portfolio portfolio = new agolova2.Portfolio("Инвестиционное преложение от 30.03.2020",2500000,"RUB","Rational",24,0.14,0.12);
        String filePath = "C:\\Users\\sasib\\OneDrive\\Documents\\GitHub\\BCSQACommunity1\\serialization.txt";
        String json = new String(Files.readAllBytes(Paths.get(filePath)));
        Portfolio targetPortfolio = new Gson().fromJson(json, Portfolio.class);

    }
}
