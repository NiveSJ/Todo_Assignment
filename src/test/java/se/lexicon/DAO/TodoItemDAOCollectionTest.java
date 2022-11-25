package se.lexicon.DAO;

import org.junit.jupiter.api.Test;
import se.lexicon.DAO.impl.AppUserDAOCollection;
import se.lexicon.DAO.impl.PersonDAOCollection;
import se.lexicon.DAO.impl.TodoItemDAOCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoItemDAOCollectionTest {
   /* @Test
    public void personDAOCollectionTest() {
        List<AppUser> appUser = new ArrayList<>();
        List<Person> person = new ArrayList<>();
        List<TodoItem> Item = new ArrayList<>();

        ITodoItemDAO todoItemDAOCollection = new TodoItemDAOCollection(Item);
        IPersonDAO personDAOCollection = new PersonDAOCollection(person);
        IAppUserDAO appUserDAOCollection = new AppUserDAOCollection(appUser);

        AppUser createdAppUser = appUserDAOCollection.persist(new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN));

        Person createdPerson1 = personDAOCollection.persist(new Person("Nivethitha", "Jayanth", "nive@gmail.com", createdAppUser));

        TodoItem todo1 = todoItemDAOCollection.persist(new TodoItem("Project Meeting", "Discuss about project setup",
                LocalDate.parse("2022-11-01"), createdPerson1));

        // Checking persisted person
        assertEquals(Item.get(0), todo1);


        Collection<TodoItem> item1 = todoItemDAOCollection.findAll();

        for (TodoItem item : item1)
            assertEquals(Item.get(0), item);

        TodoItem id = todoItemDAOCollection.findById(todo1.getId());
        assertEquals(Item.get(0), id);

        Collection<TodoItem> personById = todoItemDAOCollection.findByPersonId(todo1.getCreator().getId());

        for (TodoItem item : personById)

            assertEquals(Item.get(0), item);

       Collection<TodoItem> tasks = todoItemDAOCollection.findByDeadlineAfter(LocalDate.parse("2022-11-01"));

        for (TodoItem item : tasks)
            assertEquals(Item.get(0),item);



        Collection<TodoItem> task1 = todoItemDAOCollection.findByDeadlineBefore(LocalDate.now());
        for (TodoItem item : task1)
            assertEquals(Item.get(0), item);

        Collection<TodoItem> task2 = todoItemDAOCollection.findAllByDoneStatus(true);

        for (TodoItem item : task2)
            assertEquals(Item.get(0), item);

        Collection<TodoItem> task3 = todoItemDAOCollection.findByTitleContains("Project Meeting");
        for (TodoItem item : task3)
            assertEquals(Item.get(0), item);


        todoItemDAOCollection.remove(todo1.getId());

        TodoItem Task = todoItemDAOCollection.findById(todo1.getId());

        assertEquals(null, Task);


    } */


}
