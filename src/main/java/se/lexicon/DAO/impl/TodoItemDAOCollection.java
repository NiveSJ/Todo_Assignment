package se.lexicon.DAO.impl;

import se.lexicon.DAO.ITodoItemDAO;
import se.lexicon.Person;
import se.lexicon.TodoItem;
import se.lexicon.sequencers.PersonIdSequencer;
import se.lexicon.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements ITodoItemDAO {

    List<TodoItem> todoItemList;

    @Override
    public TodoItem create(TodoItem todoItem) {

        if (todoItem == null) throw new IllegalArgumentException("App user is  null");

        TodoItem name = findById(todoItem.getId());

        if (name != null) throw new IllegalArgumentException("Name already present!!");
        todoItem.setId(TodoItemIdSequencer.nextId());
        todoItemList.add(name);
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

    @Override
    public void update(TodoItem model) {

        if (model == null) throw new IllegalArgumentException("toUpdate data was null");

        todoItemList.stream().filter(todoItem -> todoItem.getId()== model.getId()).
                map(todoItem -> {
            todoItem.setTitle(model.getTitle()); todoItem.setAssignee(model.getAssignee());
            todoItem.setDeadline(model.getDeadline());
            todoItem.setTaskDescription(model.getTaskDescription());todoItem.setDone(model.isDone());
            return todoItem; });
    }



       /* for (TodoItem original : todoItemList){
            if (original.getId() == (model.getId())) {
                original.setTitle(model.getTitle());
                original.setTaskDescription(model.getTaskDescription());
                original.setDeadline(model.getDeadline());
                original.setDone(model.isDone());

                original.setAssignee(model.getAssignee());
                break;
            }
        }*/




    @Override
    public Consumer<TodoItem> findAll() {

        Consumer<TodoItem> findtodo = (print) -> System.out.println(print);
        todoItemList.forEach(findtodo);
        return findtodo;

    }

    @Override
    public List<TodoItem> findAllAvailable() {


        List<TodoItem> todo = todoItemList.stream().
                filter(todoItem -> todoItem.getAssignee().equals(null)).collect(Collectors.toList());
        return todo;
    }

    @Override
    public List<TodoItem> findExpiredAndInCompleted() {

        //Expired and incomplete

        List<TodoItem> filteredlist = todoItemList.stream().filter(todoItem -> todoItem.isOverdue() &&
                !todoItem.isDone()).collect(Collectors.toList());
        return filteredlist;
    }
}
