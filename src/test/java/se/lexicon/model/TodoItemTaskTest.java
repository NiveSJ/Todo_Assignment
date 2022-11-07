package se.lexicon.model;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;


import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class TodoItemTaskTest {


    @Test
    public void todoitemtaskTest() {

        Person person =new Person(1001, "Nivethitha", "Jayanth", "nive@gmail.com");

        TodoItem todoItem = new TodoItem(2001, "Project Meeting", "Discuss",
                LocalDate.parse("2022-11-01"), person);

        TodoItemTask todoItemTask = new TodoItemTask(3001, todoItem, person);


        int id = todoItemTask.getId();
        assertEquals(3001, id);

        TodoItem todo1=todoItemTask.getTodoItem();
        assertEquals(todoItem,todo1);

        Person per1=todoItemTask.getAssignee();
        assertEquals(person,per1);





    }


}
