package se.lexicon.model;


import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;


import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TodoItemTest {


    @Test
    public void overdueTest() {
        AppUser appUser1 = new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN);
        Person person[] = new Person[1];
        person[0] = new Person(1001, "Nivethitha", "Jayanth", "nive@gmail.com",appUser1);

        TodoItem todoItem[] = new TodoItem[1];
        todoItem[0] = new TodoItem(2001, "Project Meeting", "Discuss",
                LocalDate.parse("2022-11-01"), person[0]);


        //id getter
        int id = todoItem[0].getId();
        assertEquals(2001, id);
    //
        Person personcheck = todoItem[0].getCreator();
        assertEquals(person[0], personcheck);

        String desc = todoItem[0].getTaskDescription();
        assertEquals("Discuss", desc);

        String title = todoItem[0].getTitle();
        assertEquals("Project Meeting", title);

        LocalDate DL = todoItem[0].getDeadline();
        assertEquals(LocalDate.parse("2022-11-01"), DL);

        // setter throws null pointer expression

        assertThrows(IllegalArgumentException.class, () -> {
            todoItem[0].setDeadline(null);
        });

        //overdue test
        boolean expected = true;
        boolean value = todoItem[0].isOverdue();
        assertEquals(true, value);


    }

}
