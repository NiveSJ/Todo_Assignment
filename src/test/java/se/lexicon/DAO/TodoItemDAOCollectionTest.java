package se.lexicon.DAO;

import org.junit.jupiter.api.Test;
import se.lexicon.DAO.impl.AppUserDAOCollection;
import se.lexicon.DAO.impl.PersonDAOCollection;
import se.lexicon.DAO.impl.TodoItemDAOCollection;
import se.lexicon.MyOwnRuntimeException;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoItemDAOCollectionTest {


    IAppUserDAO appuser = AppUserDAOCollection.getInstance();
    IPersonDAO person = PersonDAOCollection.getInstance();
    ITodoItemDAO todoItemDAO = TodoItemDAOCollection.getInstance();

    @Test
    public void personDAOCollectionTest() throws MyOwnRuntimeException {

        AppUser user1 = new AppUser("Nive", "12345", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser("Anika", "12345", AppRole.ROLE_APP_USER);
        AppUser user3 = new AppUser("Ananya", "12345", AppRole.ROLE_APP_USER);
        AppUserDAOCollection.getInstance().create(user1);
        AppUserDAOCollection.getInstance().create(user2);

        Person person1 = new Person("Nive", "Jay", "Nive@gmail.com", user1);
        Person person2 = new Person("Anika", "Jay", "Anika@gmail.com", user2);

        PersonDAOCollection.getInstance().create(person1);
        PersonDAOCollection.getInstance().create(person2);

        TodoItem item1 = new TodoItem("Scrum", "Meeting", LocalDate.parse("2022-11-10"));
        TodoItem item2 = new TodoItem("Project Meeting", "Meeting", LocalDate.parse("2022-12-02"));
        TodoItem item3 = new TodoItem("Project Meeting1", "Meeting1", LocalDate.parse("2022-12-02"));

        todoItemDAO.create(item1);
        todoItemDAO.create(item2);
        todoItemDAO.create(item3);

        System.out.println(todoItemDAO.findAll());

        System.out.println(item1.getAssignee());


        List<TodoItem> list1 = todoItemDAO.findAllAvailable();
        System.out.println(list1);

        List<TodoItem> list2 = todoItemDAO.findExpiredAndInCompleted();


    }


}
