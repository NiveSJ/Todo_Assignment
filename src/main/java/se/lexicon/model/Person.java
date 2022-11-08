package se.lexicon.model;

import java.util.Objects;

public class Person {

    private int id;
    private String firstName;
    private String LastName;
    private String email;

    private AppUser credentials;

    public Person(int id, String firstName, String LastName, String email, AppUser credentials) {
        this.id = id;
        setFirstName(firstName);
        setLastName(LastName);
        setEmail(email);
        setCredentials(credentials);

    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
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
        if (firstName == null) throw new IllegalArgumentException("First name cannot be null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        if (LastName == null) throw new IllegalArgumentException("Last name cannot be null");
        this.LastName = LastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Email cannot be null");
        this.email = email;
    }




    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override  // Excluded Credentials from equals and hashcode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        return id == this.id && firstName.equals(this.firstName) &&
                LastName.equals(this.LastName) && email.equals(this.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, LastName, email);
    }
}
