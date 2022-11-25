package se.lexicon.controller;

import se.lexicon.DAO.impl.AppUserDAOCollection;
import se.lexicon.DAO.impl.PersonDAOCollection;
import se.lexicon.DAO.impl.TodoItemDAOCollection;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.sequencers.PersonIdSequencer;
import se.lexicon.view.ConsoleUI;
import se.lexicon.view.MainMenu;

import java.sql.SQLOutput;
import java.util.List;
import java.util.function.Consumer;

public class Controller {
    ConsoleUI ui;
    PersonDAOCollection personDao;
    AppUserDAOCollection appUserDao;
    TodoItemDAOCollection todoItemDao;

    public Controller() {
        ui = new ConsoleUI();
        personDao = PersonDAOCollection.getInstance();
        appUserDao = AppUserDAOCollection.getInstance();
        todoItemDao = TodoItemDAOCollection.getInstance();

    }

    public void doMainMenu() {

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

    public void doRegister() {
        Person personData = ui.getPersonInfo();

        System.out.println("Person id seq " + PersonIdSequencer.nextId());
        System.out.println(personData);

        AppUser appUserData = personData.getCredentials();

        System.out.println("App user data+" + appUserData);

        AppUser createdAppUser = appUserDao.create(appUserData);

        //System.out.println(" from controller    " + createdAppUser);

        personData.setCredentials(createdAppUser);
        //System.out.println("to debug" + personData.getCredentials());
        // System.out.println(personData);

        Person createdPerson = personDao.create(personData);

        ui.displayPersonInformation(createdPerson);

    }

    public void doCreateTodoItem() {
        TodoItem todoItemData = ui.getTodoItemData();

        Person personData = todoItemData.getAssignee();
        System.out.println(personDao.findAll());

        System.out.println("At do create todo " + personData);
        Person foundPerson = personDao.findById(personData.getId());
        todoItemData.setAssignee(foundPerson);
        TodoItem createdTodoItem = todoItemDao.create(todoItemData);
        ui.displayTodoItemInformation(createdTodoItem);

    }

    public void doDisplayTodoItems() {
        List<TodoItem> todoItemList = todoItemDao.findAll();
        ui.displayTodoItemInformation(todoItemList);
    }

    public void doUpdatePerson() {
        String username = ui.usernameUpdate();
        Person toUpdate = ui.personUpdate();
        personDao.update(username, toUpdate);

        System.out.println(personDao.findByUsername(username));

    }


}


