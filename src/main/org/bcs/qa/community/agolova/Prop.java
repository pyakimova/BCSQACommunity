package agolova;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Prop {
    public static final String PATH_FILE_PROPERTIES = "C:\\Users\\sasib\\OneDrive\\Documents\\GitHub\\BCSQACommunity1\\src\\main\\org\\bcs\\qa\\community\\agolova\\Resourse\\config.properties";

    public static void getProperties(){
        FileInputStream fileInputStream;
        Properties property = new Properties();
        try{
            fileInputStream = new FileInputStream(PATH_FILE_PROPERTIES);
            property.load(fileInputStream);
            String baseURL = property.getProperty("baseURL");
            String loging = property.getProperty("loging");
            String password = property.getProperty("password");
            String pfpId = property.getProperty("pfpId");

            System.out.println("URL: " + baseURL + "\nloging: " + loging + "\npassword: " + password + "\npfpId: " + pfpId);

        } catch(IOException e){
            System.out.println("Файла " + PATH_FILE_PROPERTIES + "обнаружено");
            e.printStackTrace();

        }
    }

    public static void main(String args[]){
        getProperties();
    }

}
