package agolova2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Prop {
    public static final String PATH_FILE_PROPERTIES = "config.properties";

    public static void getProperties(String filePath){
        filePath = PATH_FILE_PROPERTIES;

        FileInputStream fileInputStream;
        Properties property = new Properties();
        try{
            fileInputStream = new FileInputStream(filePath);
            property.load(fileInputStream);
            String baseURL = property.getProperty("baseURL");
            String loging = property.getProperty("loging");
            String password = property.getProperty("password");
            String pfpId = property.getProperty("pfpId");

            System.out.println("URL: " + baseURL + "\nloging: " + loging + "\npassword: " + password + "\npfpId: " + pfpId);

        } catch(IOException e){
            System.out.println("Файла " + filePath + "обнаружено");
            e.printStackTrace();

        }
    }

    public static void main(String args[]){
        getProperties(PATH_FILE_PROPERTIES);
    }

}
