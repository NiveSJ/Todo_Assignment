package se.lexicon.view;

import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    public MainMenu displayMenu() {

        System.out.println("1.Register");
        System.out.println("2.Create Task");
        System.out.println("3.Display all task");
        System.out.println("4.Update Person");
        System.out.println("5.Exit");

        System.out.println("Enter a number to perform operation");


        switch (getNumber()) {
            case 1:
                return MainMenu.REGISTER;
            case 2:
                return MainMenu.CREATE_TASK;

            case 3:
                return MainMenu.DISPLAY_TASK;
            case 4:
                return MainMenu.UPDATE_PERSON;
            default:
                return MainMenu.EXIT;
        }


    }

    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Person getPersonInfo() {
/*
        System.out.println("Username:");
        String username = getString();

        System.out.println("Password:");
        String pwd = getString();

        //AppUser user1 = new AppUser(username, pwd, AppRole.ROLE_APP_USER);*/



        System.out.println("FirstName:");
        String fn = getString();

        System.out.println("LastName:");
        String ln = getString();


        Person person1 = new Person(fn, ln);

        return person1;
    }

    public void displayPersonInformation(Person person) {
        System.out.println(person);
    }


    public TodoItem getTodoItemData() {

        System.out.println("Title:");
        String title = getString();

        System.out.println("Description:");
        String description = getString();

        System.out.println("Deadline (YYYY-MM-DD):");
        String deadline = getString();

        System.out.println("PersonId:");
        Integer personId = getNumber();

        // Creating todo Item
        TodoItem todoItemData = new TodoItem(title, description, LocalDate.parse(deadline));

        // Assigning it to person
        Person personData = new Person();

        personData.setId(personId);

        todoItemData.setAssignee(personData);

        return todoItemData;


    }

    public void displayTodoItemInformation(TodoItem todoItem) {
        System.out.println(todoItem);
    }

    public void displayTodoItemInformation(List<TodoItem> todoItemList) {
        for (TodoItem todoItem : todoItemList) {
            displayTodoItemInformation(todoItem);
        }
    }


    public String usernameUpdate() {
        System.out.println("Enter username to update");
        String username = getString();
        return username;
    }

    public Person personUpdate() {
        Person updatePerson = getPersonInfo();
        return updatePerson;


    }


}
