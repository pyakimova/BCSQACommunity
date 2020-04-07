package samsonova.propertiesReader_main;

import samsonova.properties_reader.*;

import java.io.FileNotFoundException;

public class PropertiesReaderDemo {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(MyPropReader.getProperties("firstName", "src/out.json"));

        System.out.println(MyPropReader.getProperties("firstName"));
    }
}