package samsonova.parsing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parsing {
    public static void substringsCount(String substring, String filePath) throws FileNotFoundException {
        int substringsCount = 0;

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                String scannedString = scanner.nextLine();
                int startIndex = 0;

                while (startIndex < scannedString.length()) {
                    int index = scannedString.indexOf(substring, startIndex);

                    if (index == -1) {
                        break;
                    }

                    substringsCount++;
                    startIndex = index + substring.length();
                }
            }
        }

        System.out.println("Число вхождений = " + substringsCount);
    }

    public static void linesCount(String filePath) throws FileNotFoundException {
        int linesCount = 0;

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                linesCount++;
            }
        }

        System.out.println("Количество строк = " + linesCount);
    }

    public static void wordsCount(String filePath) throws FileNotFoundException {

    }

    public static void spacesCount(String filePath) throws FileNotFoundException {
        int spacesCount = 0;

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                String scannedString = scanner.nextLine();

                for (int i = 0; i < scannedString.length(); ++i) {
                    if (Character.isWhitespace(scannedString.charAt(i))) {
                        spacesCount++;
                    }
                }
            }
        }

        System.out.println("Число пробелов = " + spacesCount);
    }

    public static void printReversedText(String filePath) throws FileNotFoundException {
        String allLines;

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            StringBuilder allLinesBuilder = null;

            while (scanner.hasNextLine()) {
                String scannedString = scanner.nextLine();

                if (allLinesBuilder == null) {
                    allLinesBuilder = new StringBuilder(scannedString);
                } else {
                    allLinesBuilder.append(scannedString);
                }
            }

            assert allLinesBuilder != null;
            allLines = allLinesBuilder.toString();
        }

        StringBuffer buffer = new StringBuffer(allLines);
        buffer.reverse();

        System.out.println(buffer);
    }
}


//    Реализовать метод, который будет парсить указанный файл
//1. Посчитает колличество вхождений переданной строки
//        2. Посчитает колличество строк / слов / пробелов
//        3. Выведет текст в обратном порядке
