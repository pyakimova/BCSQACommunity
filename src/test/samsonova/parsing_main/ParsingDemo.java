package samsonova.parsing_main;

import samsonova.parsing.Parsing;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParsingDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь до файла: ");
        String path = scanner.nextLine();

        System.out.println("Введите выражение для поиска: ");
        String searchedString = scanner.nextLine();

        Parsing.substringsCount(searchedString, path);
        //Parsing.linesCount();
        System.out.println();
        Parsing.printReversedText(path);

        System.out.println();
        Parsing.spacesCount(path);


        }
    }

