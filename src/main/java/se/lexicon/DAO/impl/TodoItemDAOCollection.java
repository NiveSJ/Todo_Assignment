package se.lexicon.DAO.impl;

import se.lexicon.DAO.ITodoItemDAO;
import se.lexicon.model.TodoItem;
import se.lexicon.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements ITodoItemDAO {

    private List<TodoItem> todoItemList;
    private static TodoItemDAOCollection instance;

    private TodoItemDAOCollection() {

        this.todoItemList = new ArrayList<>();
    }

    public static TodoItemDAOCollection getInstance() {
        if (instance == null) instance = new TodoItemDAOCollection();
        return instance;
    }


    @Override
    public TodoItem create(TodoItem todoItem) {

        if (todoItem == null) throw new IllegalArgumentException("Todo Item is null");

        todoItem.setId(TodoItemIdSequencer.nextId());
        todoItemList.add(todoItem);
        return todoItem;


    }

    @Override
    public TodoItem findById(Integer id) {
        Optional<TodoItem> optional = todoItemList.stream().filter(todoItem -> todoItem.getId() == id).
                findFirst();
        return optional.orElse(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        boolean remove = todoItemList.removeIf(todoItem -> todoItem.getId() == id);
        return remove;

    }


    public void update(Integer Id, TodoItem model) {

        if (model == null) throw new IllegalArgumentException("toUpdate data was null");

        todoItemList.stream().filter(todoItem -> todoItem.getId() == Id).
                forEach(todoItem -> {
                            todoItem.setTitle(model.getTitle());
                            todoItem.setAssignee(model.getAssignee());
                            todoItem.setDeadline(model.getDeadline());
                            todoItem.setTaskDescription(model.getTaskDescription());
                            todoItem.setDone(model.isDone());
                        }
                );
    }


    @Override
    public List<TodoItem> findAll() {
        return new ArrayList<>(todoItemList);

    }

    @Override
    public List<TodoItem> findAllAvailable() {
        // Objects.isNull(todoItem.getAssignee())

        return todoItemList.stream().
                filter(todoItem -> (todoItem.getAssignee().getId())== null)
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoItem> findExpiredAndInCompleted() {

        //Expired and incomplete

        return todoItemList.stream()
                .filter(todoItem -> todoItem.getDeadline().isBefore(LocalDate.now()) && !todoItem.isDone())
                .collect(Collectors.toList());
    }
}
