package se.lexicon.DAO.impl;

import se.lexicon.DAO.ITodoItemDAO;
import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class TodoItemDAOCollection implements ITodoItemDAO {


    @Override
    public TodoItem create(TodoItem model) {
        return null;
    }

    @Override
    public TodoItem findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public void update(TodoItem model) {

    }

    @Override
    public Consumer<TodoItem> findAll() {
        return null;
    }
}
