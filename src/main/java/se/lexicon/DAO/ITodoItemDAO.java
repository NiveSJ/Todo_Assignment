package se.lexicon.DAO;

import se.lexicon.model.TodoItem;

import java.util.List;

public interface ITodoItemDAO extends IBaseDAO<TodoItem> {

    List<TodoItem> findAllAvailable();

    List<TodoItem> findExpiredAndInCompleted();

}
