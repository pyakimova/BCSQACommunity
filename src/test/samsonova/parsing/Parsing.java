package samsonova.parsing;

import java.io.*;
import java.util.Scanner;

public class Parsing {
    public static void countSubstringInString(String substring, String filePath) throws FileNotFoundException {
        int substringCount = 0;

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                String scannedString = scanner.nextLine();
                int startIndex = 0;

                while (startIndex < scannedString.length()) {
                    int index = scannedString.indexOf(substring, startIndex);

                    if (index == -1) {
                        break;
                    }

                    substringCount++;
                    startIndex = index + substring.length();
                }
            }
        }

        System.out.println("Количество вхождений подстроки = " + substringCount + System.lineSeparator());
    }

    public static void countLines(String filePath) throws IOException {
        File myFile = new File(filePath);
        FileReader fileReader = new FileReader(myFile);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

        int linesNumber = 0;

        while (lineNumberReader.readLine() != null) {
            linesNumber++;
        }

        System.out.println("Количество строк = " + linesNumber + System.lineSeparator());

        lineNumberReader.close();
    }

    public static void countWords(String filePath) throws FileNotFoundException {
        int wordsCount = 0;

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                String scannedString = scanner.nextLine();
                int startIndex = 1;

                while (startIndex < scannedString.length()) {
                    if ((Character.isLetter(scannedString.charAt(startIndex)) && startIndex - 2 == -1)
                            || (Character.isLetter(scannedString.charAt(startIndex)) &&
                            Character.isWhitespace(scannedString.charAt(startIndex - 1)))
                            || (Character.isLetter(scannedString.charAt(startIndex - 1)) && Character.isWhitespace(scannedString.charAt(startIndex)) && startIndex - 2 == -1)) {
                        wordsCount++;
                    }

                    startIndex++;
                }
            }
        }

        System.out.println("Количество слов = " + wordsCount + System.lineSeparator());
    }

    public static void countSpaces(String filePath) throws FileNotFoundException {
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

        System.out.println("Количество пробелов = " + spacesCount + System.lineSeparator());
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