package se.lexicon.controller;


import se.lexicon.DBA.Impl.TodoDBA;
import se.lexicon.DBA.Impl.peopleDBA;
import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import se.lexicon.view.ConsoleUI;
import se.lexicon.view.MainMenu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Controller {
    ConsoleUI ui;
    peopleDBA personDBA;
    TodoDBA todoDBA;


    public Controller() {
        ui = new ConsoleUI();

        todoDBA = todoDBA.getInstance();


    }

    public void doMainMenu() throws DBConnectionException {

        while (true) {
            MainMenu action = ui.displayMenu();
            switch (action) {
                case REGISTER:
                    doRegister();
                    break;
                case CREATE_TASK:
                    doCreateTodoItem();
                    break;
                case DISPLAY_TASK:
                    doDisplayTodoItems();
                    break;
                case UPDATE_PERSON:
                    doUpdatePerson();
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }

    public void doRegister() throws DBConnectionException {
        Person personData = ui.getPersonInfo();

        Person per =personDBA.create(personData);


        ui.displayPersonInformation(per);

    }

    public void doCreateTodoItem() {
        TodoItem todoItemData = ui.getTodoItemData();

        Person personData = todoItemData.getAssignee();
      //  System.out.println(personDBA.findAll());


        Person foundPerson = personDBA.findById(personData.getId());
        todoItemData.setAssignee(foundPerson);
        TodoItem createdTodoItem = todoDBA.create(todoItemData);
        ui.displayTodoItemInformation(createdTodoItem);

    }

    public void doDisplayTodoItems() {
        List<TodoItem> todo = (List<TodoItem>) todoDBA.findAll();
        ui.displayTodoItemInformation(todo);
    }

    public void doUpdatePerson() {

        Person toUpdate = ui.personUpdate();
        personDBA.update(toUpdate);



    }


}