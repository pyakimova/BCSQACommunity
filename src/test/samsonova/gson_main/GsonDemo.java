package samsonova.gson_main;

import com.google.gson.Gson;
import samsonova.gson.GsonClass;
import samsonova.gson.Person;

import java.util.Arrays;

public class GsonDemo {
    public static void main(String[] args) {
        // Serialization from object
        Person person = new Person("Anton", "Berezin", "01.01.1991", "29");
        Gson gson = new Gson();
        System.out.println(gson.toJson(person));

        // Serialization from primitives, array
        int[] values = {1, 2, 3, 4, 5};
        System.out.println(gson.toJson(values));

        // Serialization fron Strings, array
        String[] strings = {"abc", "def", "ghi"};
        System.out.println(gson.toJson(strings));

        //Deserialization to object
        Person person1 = new Person("John", "Doe", "02.02.1992", "28");
        String json1 = gson.toJson(person1);

        Person p = gson.fromJson(json1, Person.class);

        String name = p.getFirstName();
        String lastname = p.getLastName();
        String date = p.getBirthdate();

        System.out.println(name + " " + lastname + " " + date);

        // Deserialization to array
        int[] integers = {1, 2, 3, 4, 5, 22, 33, 101};
        gson.toJson(integers);

        int[] integers1 = gson.fromJson("[1,2,3,4,5,22, 33, 101]", int[].class);
        System.out.println(Arrays.toString(integers1));

        //getting parameter value
        Person person2 = new Person("Jane", "Doe", "03.03.1991", "29");
        String json2 = gson.toJson(person2);
        String age = "age";
        String firstName = "firstName";
        String lastName = "lastName";
        System.out.println(GsonClass.getParameterValue(age, json2));
        System.out.println(GsonClass.getParameterValue(firstName, json2));
        System.out.println(GsonClass.getParameterValue(lastName, json2));

        //setting parameter value
        String newValue1 = "Jeanne";
        String filePath1 = "src/out1.json";
        String resultingJson1 = GsonClass.setParameterValue(firstName, newValue1, json2);
        GsonClass.writeJsonToFile(resultingJson1, filePath1);
        System.out.println(GsonClass.getParameterValue(firstName, json2));

        //deleting parameter
        String filePath2 = "src/out2.json";
        String resultingJson2 = GsonClass.deleteParameter(firstName, json2);
        GsonClass.writeJsonToFile(resultingJson2, filePath2);
        System.out.println(json2);

        //adding new parameter
        String newParameter = "newParam";
        String newValue2 = "something";
        String filePath3 = "src/out3.json";
        String resultingJson3 = GsonClass.setParameterValue(newParameter, newValue2, json2);
        GsonClass.writeJsonToFile(resultingJson3, filePath3);
        System.out.println(GsonClass.getParameterValue(firstName, json2));
    }
}
