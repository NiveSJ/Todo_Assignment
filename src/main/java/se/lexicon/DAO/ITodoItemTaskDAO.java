package se.lexicon.DAO;

import se.lexicon.TodoItemTask;

import java.util.Collection;

public interface ITodoItemTaskDAO {

    TodoItemTask persist(TodoItemTask todoItemTask);

    TodoItemTask findById(int id);

    Collection<TodoItemTask> findAll();

    Collection<TodoItemTask> findByAssignedStatus(boolean status);


    Collection<TodoItemTask> findByPersonId(int personId);


    void remove(int id);
}
