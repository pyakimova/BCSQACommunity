package agolova;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

public class JsonCreator {
    private static final String FILENAME = "C:\\Users\\sasib\\OneDrive\\Documents\\GitHub\\BCSQACommunity1\\flatJsonTask.txt";

    public static void main(String[] args) {
        JsonFactory jsonFactory = new JsonFactory();

        try (JsonGenerator jsonGenerator = jsonFactory.createJsonGenerator(new File(FILENAME), JsonEncoding.UTF8)) {
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
