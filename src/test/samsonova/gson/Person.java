package samsonova.gson;

public class Person {
    private String firstName;
    private String lastName;
    private String birthdate;
    private int age;

    public Person(String firstName, String lastName, String birthdate, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }
}