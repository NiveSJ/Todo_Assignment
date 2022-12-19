package se.lexicon.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Person {

    private Integer id;

    private String firstName;
    private String LastName;
    private List<TodoItem> todoItems;

    private AppUser credentials;
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", todoItems=" + todoItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(LastName, person.LastName) && Objects.equals(email, person.email) && Objects.equals(todoItems, person.todoItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, LastName, email, todoItems);
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }




    public Person(String firstName, String LastName, String email, AppUser credentials, List<TodoItem> todoItems) {
        setFirstName(firstName);
        setLastName(LastName);
        setEmail(email);
        setCredentials(credentials);
        setTodoItems(todoItems);

    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    public Person(String firstName, String LastName, String email, AppUser credentials) {

        setFirstName(firstName);
        setLastName(LastName);
        setEmail(email);
        setCredentials(credentials);
        this.todoItems = new ArrayList<>();

    }


}