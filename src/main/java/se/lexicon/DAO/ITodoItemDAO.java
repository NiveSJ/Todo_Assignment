package se.lexicon.DAO;

import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface ITodoItemDAO extends IBaseDAO<TodoItem> {

    List<TodoItem> findAllAvailable();

    List<TodoItem> findExpiredAndInCompleted();

}
