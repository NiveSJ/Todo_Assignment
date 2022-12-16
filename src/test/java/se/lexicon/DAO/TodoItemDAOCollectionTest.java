package se.lexicon.DAO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.lexicon.DAO.impl.AppUserDAOCollection;
import se.lexicon.DAO.impl.PersonDAOCollection;
import se.lexicon.DAO.impl.TodoItemDAOCollection;
import se.lexicon.exceptions.MyOwnRuntimeException;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoItemDAOCollectionTest {


    IAppUserDAO appuser = AppUserDAOCollection.getInstance();
    IPersonDAO person = PersonDAOCollection.getInstance();
    ITodoItemDAO todoItemDAO = TodoItemDAOCollection.getInstance();

    @Test
    void findAllAndFindByIdTest() throws MyOwnRuntimeException {
        createObjects();


        List<TodoItem> personAll = todoItemDAO.findAll();
        Assertions.assertEquals(1, personAll.size());




        // List<TodoItem> list2 = todoItemDAO.findExpiredAndInCompleted();


    }

    @Test
    void findAllAvailable() throws MyOwnRuntimeException {
        createObjects();


        List<TodoItem> list1 = todoItemDAO.findAllAvailable();
        Assertions.assertEquals(1, list1.size());

    }

    private void createObjects() throws MyOwnRuntimeException {

        AppUser user1 = new AppUser("Nive", "12345", AppRole.ROLE_APP_USER);
        appuser.create(user1);

        Person person1 = new Person("Nive", "Jay", "Nive@gmail.com", user1);
        person.create(person1);

        TodoItem item1 = new TodoItem("Scrum", "Meeting", LocalDate.parse("2022-11-10"));
        todoItemDAO.create(item1);


    }


}
