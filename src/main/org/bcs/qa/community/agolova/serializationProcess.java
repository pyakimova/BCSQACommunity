package agolova;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class serializationProcess {

    public static void main(String args[]){
        writeValue();
    }

    public static void writeValue(){
        Portfolio portfolio = new Portfolio("Инвестиционное преложение от 30.03.2020",2500000,"RUB","Rational",24,0.14,0.12);
        ObjectMapper mapper = new ObjectMapper();

        try { mapper.writeValue(new FileOutputStream("C:\\Users\\sasib\\OneDrive\\Documents\\GitHub\\BCSQACommunity1\\serializationOfJson.txt"), portfolio);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
