package main.org.bcs.qa.community.rezyapkinaes;

import java.util.Random;

public class RandomStringGeneratorV2 {

    private static Random cyrillicFirstName = new Random();
    private static char[] cyrillicAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    private static int varLength = cyrillicAlphabet.length;

    public static char RandomCyrillicLetter() {
        return cyrillicAlphabet[cyrillicFirstName.nextInt(varLength)];
    }

    public static String RandomCyrillicString(int length) {
        String name = "";
        for (int i=0; i<length; i++) {
            name += RandomCyrillicLetter();
        }
        return name;
    }

    public static void main(String[] args) {
        System.out.println(RandomCyrillicString(10) + "," + " " + RandomCyrillicString(10));
    }
}
//Реализовать метод, который будет генерировать рандомное значение String