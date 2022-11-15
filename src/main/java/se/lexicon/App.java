package se.lexicon;

import se.lexicon.DAO.AppUserDAOCollection;
import se.lexicon.DAO.PersonDAOCollection;
import se.lexicon.DAO.TodoItemDAOCollection;
import se.lexicon.DAO.TodoItemTaskDAOCollection;
import se.lexicon.model.*;
import se.lexicon.sequencers.PersonIdSequencer;
import se.lexicon.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Moving data to arrayList
 * Reading from and writing List data to JSON file.
 */
public class App {
    public static void main(String[] args) {

        System.out.println(PersonIdSequencer.nextId()); // 101
        System.out.println(PersonIdSequencer.getCurrentId()); // 101
        System.out.println(PersonIdSequencer.nextId()); // 102
        System.out.println(PersonIdSequencer.getCurrentId()); // 102

        System.out.println("--------------------------");


        List<AppUser> appUser = new ArrayList<>();
        List<Person> person = new ArrayList<>();
        List<TodoItem> task = new ArrayList<>();
        List<TodoItemTask> Todotask = new ArrayList<>();

        AppUserDAOCollection appUserDAOCollection = new AppUserDAOCollection(appUser);

        AppUser createdAppUser = appUserDAOCollection.persist(new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN));
        AppUser createdAppUser1 = appUserDAOCollection.persist(new AppUser("Test1", "20wqfj", AppRole.ROLE_APP_USER));
        AppUser createdAppUser2 = appUserDAOCollection.persist(new AppUser("Test2", "20wqfj", AppRole.ROLE_APP_USER));

        System.out.println("------");
        System.out.println(createdAppUser.toString() + " " + createdAppUser1 + " " + createdAppUser2);
        System.out.println("------");

        PersonDAOCollection personDAOCollection = new PersonDAOCollection(person);

        Person createdperson1 = personDAOCollection.persist(new Person("Nivethitha", "Jayanth", "nive@gmail.com", appUser.get(0)));
        Person createdperson2 = personDAOCollection.persist(new Person("Jayanth", "Solai", "jay@gmail.com", appUser.get(1)));
        Person createdperson3 = personDAOCollection.persist(new Person("Test", "Test", "Test@gmail.com", appUser.get(2)));

        System.out.println(createdperson1.toString() + " " + createdperson2 + " " + createdperson3);

        System.out.println("##################### Created Task ###################################");

        System.out.println(TodoItemIdSequencer.nextId());
        System.out.println(TodoItemIdSequencer.getCurrentId());
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection(task);


        TodoItem todo1=todoItemDAOCollection.persist(new TodoItem("Project Meeting", "Discuss about project setup",
                LocalDate.parse("2022-11-01"), person.get(0)));
        System.out.println(todo1.getId());

        Collection<TodoItem> createdTask = todoItemDAOCollection.findAll();

        System.out.println("#################Created Todo Information by find all()#################");

        System.out.println(createdTask);
        TodoItem todo2=todoItemDAOCollection.persist(new TodoItem("Project Meeting1", "Discuss about project setup",
                LocalDate.parse("2022-11-10"), person.get(0)));



        //
        Collection<TodoItem> createdTask1 = todoItemDAOCollection.findAll();

        System.out.println("#################Created Todo Information by find all()#################");

        System.out.println(createdTask1);

        System.out.println("##################TodoItem task information Information##################");
        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection(Todotask);
        TodoItemTask todoItemTask=todoItemTaskDAOCollection.persist(new TodoItemTask(todo1, createdperson2));
        TodoItemTask todoItemTask1=todoItemTaskDAOCollection.persist(new TodoItemTask(todo2, createdperson3));

        Collection<TodoItemTask> ItemTask = todoItemTaskDAOCollection.findAll();

        System.out.println(ItemTask);


    }
}
