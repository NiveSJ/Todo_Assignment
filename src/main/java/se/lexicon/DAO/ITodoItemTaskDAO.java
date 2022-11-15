package se.lexicon.DAO;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItemTask;

import java.util.Collection;

public interface ITodoItemTaskDAO {

    TodoItemTask persist(TodoItemTask todoItemTask);

    TodoItemTask findById(int id);

    Collection<TodoItemTask> findAll();

    Collection<TodoItemTask> findByAssignedStatus(boolean status);


    Collection<TodoItemTask> findByPersonId(Person personId);


    void remove(int id);
}
