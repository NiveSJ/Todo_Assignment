package se.lexicon.DAO;

import org.junit.jupiter.api.Test;
import se.lexicon.*;
import se.lexicon.DAO.impl.AppUserDAOCollection;
import se.lexicon.DAO.impl.PersonDAOCollection;
import se.lexicon.DAO.impl.TodoItemDAOCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoItemTaskDAOCollectionTest {


    @Test
    public void todoItemDAOCollectionTest() {
        List<AppUser> appUser = new ArrayList<>();
        List<Person> person = new ArrayList<>();
        List<TodoItem> Item = new ArrayList<>();
        List<TodoItemTask> ItemTask = new ArrayList<>();

        ITodoItemDAO todoItemDAOCollection = new TodoItemDAOCollection(Item);
        IPersonDAO personDAOCollection = new PersonDAOCollection(person);
        IAppUserDAO appUserDAOCollection = new AppUserDAOCollection(appUser);
        ITodoItemTaskDAO todoItemTaskDAOCollection = new TodoItemTaskDAOCollection(ItemTask);


        AppUser createdAppUser = appUserDAOCollection.persist(new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN));

        Person createdPerson1 = personDAOCollection.persist(new Person("Nivethitha", "Jayanth", "nive@gmail.com", createdAppUser));

        TodoItem todo1 = todoItemDAOCollection.persist(new TodoItem("Project Meeting", "Discuss about project setup",
                LocalDate.parse("2022-11-01"), createdPerson1));


        TodoItemTask todoItemTask = todoItemTaskDAOCollection.persist(new TodoItemTask(todo1, createdPerson1));


        Collection<TodoItemTask> task1 = todoItemTaskDAOCollection.findAll();
        for (TodoItemTask itr1 : task1)

            assertEquals(ItemTask.get(0), itr1);

        TodoItemTask task2 = todoItemTaskDAOCollection.findById(todoItemTask.getId());
        assertEquals(ItemTask.get(0), task2);

        Collection<TodoItemTask> task3 = todoItemTaskDAOCollection.findByPersonId(todoItemTask.getAssignee().getId());
        for (TodoItemTask itr1 : task3)
        assertEquals(ItemTask.get(0), itr1);

        Collection<TodoItemTask> task4 = todoItemTaskDAOCollection.findByAssignedStatus(true);

        for (TodoItemTask itr1 : task4)
        assertEquals(ItemTask.get(0), itr1);

        todoItemTaskDAOCollection.remove(todoItemTask.getId());

        TodoItemTask task5 = todoItemTaskDAOCollection.findById(todoItemTask.getId());
        assertEquals(null, task5);


    }
}
