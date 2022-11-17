package se.lexicon.DAO;

import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface ITodoItemDAO {

    TodoItem persist(TodoItem todoItem);

    TodoItem findById(int id);

    Collection<TodoItem> findAll();

    Collection<TodoItem> findAllByDoneStatus(Boolean done);

    Collection<TodoItem> findByTitleContains(String title);


    Collection<TodoItem> findByPersonId(int personId);

    Collection<TodoItem> findByDeadlineBefore(LocalDate deadline);

    Collection<TodoItem> findByDeadlineAfter(LocalDate deadline);

    void remove(int id);


}
