package samsonova.gson_main;

import com.google.gson.Gson;
import samsonova.gson.Person;

import java.util.Arrays;

public class GsonDemo {
    public static void main(String[] args) {

        // Serialization from object
        Person person = new Person("Anton", "Berezin", "01.01.1991");
        Gson gson = new Gson();

        String json = gson.toJson(person);
        System.out.println(json);

        // Serialization from primitives, array
        int[] values = {1, 2, 3, 4, 5};
        System.out.println(gson.toJson(values));

        // Serialization fron Strings, array
        String[] strings = {"abc", "def", "ghi"};
        System.out.println(gson.toJson(strings));

        //Deserialization to object
        Person person1 = new Person("John", "Doe", "02.02.1992");
        String json1 = gson.toJson(person1);

        Person person3 = gson.fromJson(json1, Person.class);

        String name = person3.getFirstName();
        String lastname = person3.getLastName();
        String date = person3.getBirthdate();

        System.out.println(name + " " + lastname + " " + date);

        // Deserialization to array
        int[] integers = {1, 2, 3, 4, 5, 22, 33, 101};
        gson.toJson(integers);

        int[] integers1 = gson.fromJson("[1,2,3,4,5,22, 33, 101]", int[].class);
        System.out.println(Arrays.toString(integers1));

    }


}
