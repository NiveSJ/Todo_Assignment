package se.lexicon.DBA;

import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.util.Collection;

public interface ITodoDBA extends IBaseDBA<TodoItem> {

    TodoItem create(TodoItem todoItem) ;

    Collection<TodoItem> findAll();

    TodoItem findById(int id);

    TodoItem update(TodoItem todoItem);

    boolean deleteById(int id);

    Collection<TodoItem> findByDoneStatus(boolean status);

    Collection<TodoItem> findByAssignee(int id);

    Collection<TodoItem> findByAssignee(Person person);

    Collection<TodoItem> findByUnassignedTodoItem();

}
