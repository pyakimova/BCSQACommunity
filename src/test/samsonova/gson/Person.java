package samsonova.gson;

public class Person {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String age;

    public Person(String firstName, String lastName, String birthdate, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.age = age;
    }

    public Person() {
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