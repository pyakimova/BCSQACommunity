package main.org.bcs.qa.community.rezyapkinaes;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {
    public static void main(String[] args) {
        System.out.println("Generated string:");
        generator();
    }

    public static void generator() {
        String generatedStringFirstName = RandomStringUtils.randomAlphanumeric(10);
        String generatedStringLastName = RandomStringUtils.randomAlphanumeric(10);

        System.out.println(generatedStringFirstName + "," + " " +  generatedStringLastName);
    }
}


//Реализовать метод, который будет генерировать рандомное значение String