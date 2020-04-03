package main.org.bcs.qa.community.rezyapkinaes;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {
    public static void main(String[] args) {
        System.out.println("Generate string:");
        generator();
    }

    public static void generator() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);

        System.out.println(generatedString);
    }
}

//Реализовать метод, который будет генерировать рандомное значение String