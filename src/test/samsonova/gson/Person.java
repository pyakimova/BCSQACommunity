package samsonova.gson;

public class Person {
   private String firstName;
   private String lastName;
   private String birthdate;

   public Person(String firstName, String lastName, String birthdate) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthdate = birthdate;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getBirthdate() {
      return birthdate;
   }

   public void setBirthdate(String birthdate) {
      this.birthdate = birthdate;
   }
   }
