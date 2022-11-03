package se.lexicon;

import org.junit.Test;
import org.junit.Assert;


import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TodoItemTest {


    @Test
    public void overdueTest() {

        Person person[] = new Person[1];
        person[0] = new Person(1001, "Nivethitha", "Jayanth", "nive@gmail.com");

        TodoItem todoItem[] = new TodoItem[1];
        todoItem[0] = new TodoItem(2001, "Project Meeting", "Discuss",
                LocalDate.parse("2022-11-01"), person[0]);

        //Firstname getter
          String title= todoItem[0].getTitle();
          assertEquals("Project Meeting",title);

        LocalDate DL=  todoItem[0].getDeadline();
        assertEquals(LocalDate.parse("2022-11-01"),DL);

        assertThrows(IllegalArgumentException.class, () -> {
            todoItem[0].setDeadline(null); });



        boolean expected = true;
        boolean value = todoItem[0].isOverdue();
        assertEquals(true, value);


    }

}
