package agolova;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class serializationProcess {

    public static void main(String args[]) throws IOException {

        writingGenerationeJson();
    }

    public static void writingGenerationeJson() throws IOException {
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
