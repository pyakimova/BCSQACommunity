package agolova;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;


public class serializationProcess {

    public static void main(String args[]) throws IOException {

        serializationJson();
    }

    public static void serializationJson() throws IOException {
        Portfolio portfolio = new Portfolio("Инвестиционное преложение от 30.03.2020",2500000,"RUB","Rational",24,0.14,0.12);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(portfolio);
        FileWriter writer = new FileWriter("serialization.txt", false);
        writer.write(json);
        System.out.println(json);
        writer.flush();
        writer.close();

    }
}
