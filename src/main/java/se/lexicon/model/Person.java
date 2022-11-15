package se.lexicon.model;

import se.lexicon.sequencers.PersonIdSequencer;

import java.util.Objects;

public class Person {

    private int id;
    private String firstName;
    private String LastName;
    private String email;

    private AppUser credentials;

    public Person(String firstName, String LastName, String email, AppUser credentials) {
        PersonIdSequencer.nextId();
        this.id=PersonIdSequencer.getCurrentId();
        setFirstName(firstName);
        setLastName(LastName);
        setEmail(email);
        setCredentials(credentials);

    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        if (credentials == null) throw new IllegalArgumentException("Credentials cannot be null");

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && firstName.equals(person.firstName)
                && LastName.equals(person.LastName) && email.equals(person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, LastName, email);
    }
}