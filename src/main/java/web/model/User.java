package web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "year")
   private String year;

   public User() {}
   
   public User(String firstName, String lastName, String year) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.year = year;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
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

   public String getYear() {
      return year;
   }

   public void setYear(String year) {
      this.year = year;
   }
}
