package se.lexicon.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Person {

    private Integer id;
    private String firstName;
    private String LastName;
    private List<TodoItem> todoItems;
    private AppUser credentials;

    public Person() {
    }



    public Person(String firstName, String LastName) {
        setFirstName(firstName);
        setLastName(LastName);
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


    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }




    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(LastName, person.LastName) && Objects.equals(todoItems, person.todoItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, LastName, todoItems);
    }


}