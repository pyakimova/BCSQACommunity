package agolova;

import com.fasterxml.jackson.core.JsonEncoding;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import java.io.File;
import java.io.IOException;

public class JsonCreator {
    private static final String FILENAME = "C:\\Users\\sasib\\OneDrive\\Documents\\GitHub\\BCSQACommunity1\\flatJsonTask.txt";

    public static void main(String[] args) {
        JsonFactory jsonFactory = new JsonFactory();

        try (JsonGenerator jsonGenerator = jsonFactory.createJsonGenerator(JsonEncoding.UTF8, new File(FILENAME))
        {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("proposalName", "Инвестиционное преложение от 30.03.2020");
            jsonGenerator.writeNumberField("sumOfInvestment", 2500000);
            jsonGenerator.writeStringField("currency","RUB");
            jsonGenerator.writeStringField("riskProfile", "Rational");
            jsonGenerator.writeNumberField("termOfInvestment",24);
            jsonGenerator.writeNumberField("excpectedReturn", 0.14);
            jsonGenerator.writeNumberField("var", 0.12);
            jsonGenerator.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Что-то пошло не так :(");
        }

    }

}
