package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    private Integer id;
    private String firstName;
    private String LastName;
    private String email;


    private List<TodoItem> todoItems;

    private AppUser credentials;

    public Person() { // for Json file throws error if a default constructor not present
    }

    public Person(Integer id, String firstName, String LastName, String email, AppUser credentials, List<TodoItem> todoItems) {
        setId(id);
        setFirstName(firstName);
        setLastName(LastName);
        setEmail(email);
        setCredentials(credentials);
        setTodoItems(todoItems);


    }


    public Person(String firstName, String LastName, String email, AppUser credentials) {
        this.id = id;
        setFirstName(firstName);
        setLastName(LastName);
        setEmail(email);
        setCredentials(credentials);
        this.todoItems = new ArrayList<>();

    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {


        if (this.todoItems == null) todoItems = new ArrayList<>();
        this.todoItems = todoItems;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        if (credentials == null) throw new IllegalArgumentException("Credentials cannot be null");

        this.credentials = credentials;
    }

    public Integer getId() {
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
                '}' + "\n";
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