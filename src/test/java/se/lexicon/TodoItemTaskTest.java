package se.lexicon;


import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import se.lexicon.*;
import se.lexicon.sequencers.PersonIdSequencer;
import se.lexicon.sequencers.TodoItemTaskIdSequencer;

import static org.junit.jupiter.api.Assertions.*;


public class TodoItemTaskTest {


    @Test
    public void todoitemtaskTest() {
        AppUser appUser1 = new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN);

        Person person = new Person("Nivethitha", "Jayanth", "nive@gmail.com", appUser1);
        TodoItem todoItem = new TodoItem("Project Meeting", "Discuss",
                LocalDate.parse("2022-11-01"), person);

        TodoItemTask todoItemTask = new TodoItemTask(todoItem, person);


        int id = todoItemTask.getId();
        assertEquals(TodoItemTaskIdSequencer.getCurrentId(), id);

        TodoItem todo1 = todoItemTask.getTodoItem();
        assertEquals(todoItem, todo1);

        Person per1 = todoItemTask.getAssignee();
        assertEquals(person, per1);


    }


}
