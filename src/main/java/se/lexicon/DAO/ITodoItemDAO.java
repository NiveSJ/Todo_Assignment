package se.lexicon.DAO;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface ITodoItemDAO {

    TodoItem persist(TodoItem todoItem);

    TodoItem findById(int id);

    Collection<TodoItem> findAll();

    Collection<TodoItem> findAllByDoneStatus(Boolean done);

    Collection<TodoItem> findByTitleContains(String title);

    Collection<TodoItem> findByPersonId(Person personId);

    Collection<TodoItem> findByDeadlineBefore(LocalDate deadline);

    Collection<TodoItem> findByDeadlineAfter(LocalDate deadline);

    void remove(int id);


}
