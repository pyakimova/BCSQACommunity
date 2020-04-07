package samsonova.parsing_main;

import samsonova.parsing.Parsing;

import java.io.IOException;
import java.util.Scanner;

public class ParsingDemo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь до файла: "); // ввести src/input.txt
        String path = scanner.nextLine();

        System.out.println("Введите подстроку для поиска: ");
        String searchedString = scanner.nextLine();

        Parsing.countSubstringInString(searchedString, path);

        Parsing.countWords(path);

        Parsing.countLines(path);

        Parsing.countSpaces(path);

        Parsing.printReversedText(path);
    }
}