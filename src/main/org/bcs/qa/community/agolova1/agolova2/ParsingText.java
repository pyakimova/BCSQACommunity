package agolova2;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ParsingText {
    private static final String FILEPATH = "C:\\Users\\sasib\\OneDrive\\Documents\\GitHub\\BCSQACommunity1\\serialization.txt";
    private static final String FILENAME = "serialization.txt";
  
    public static void parseText() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILEPATH));
            System.out.println(lines);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void reverseText(){

    }

        public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(FILENAME);
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
    }
}
