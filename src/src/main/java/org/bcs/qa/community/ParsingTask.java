package org.bcs.qa.community;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Реализовать метод, который будет парсить указанный файл
 * 1. Посчитает колличество вхождений переданной строки
 * 2. Посчитает колличество строк / слов / пробелов
 * 3. Выведет текст в обратном порядке
 */
public class ParsingTask {
    public static void main(String[] args) {
        String fileName = "src\\test\\resources\\randomText.txt";
        try {
            String contents = readUsingBufferedReader(fileName);
            String[] words = contents.split("\\s");
            String reverse = new StringBuffer(contents).reverse().toString();
            System.out.println("Количество слов в тексте: " + words.length);
            System.out.println("Текст в обратном порядке:");
            System.out.println(reverse);
            System.out.println("\n");
            for (int i = words.length - 1; i >= 0; i--) {
                System.out.print(words[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static String readUsingFiles(String fileName) throws IOException {
//        return new String(Files.readAllBytes(Paths.get(fileName)));
//    }

    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        int number_of_line = 0;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            number_of_line++;
            stringBuilder.append(ls);
        }
        System.out.println("Количество строк в тексте: " + number_of_line);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println("Количество пробелов в тексте: " + stringBuilder.toString().replaceAll("[^ ]", "").length());
        return stringBuilder.toString();
    }
}