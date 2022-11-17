package se.lexicon.DAO;

import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOCollection implements ITodoItemDAO {

    private List<TodoItem> todoItemList;

    public TodoItemDAOCollection(List<TodoItem> todoItemList) {
        this.todoItemList = todoItemList;
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if (todoItem == null) throw new IllegalArgumentException("TodoItem is null");
        TodoItem todoId = findById(todoItem.getId());
        if (todoId != null) throw new IllegalArgumentException("Item already present");
        todoItemList.add(todoItem);

        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        if (id == 0) throw new IllegalArgumentException("Id is null");
        for (TodoItem itr1 : todoItemList) {
            if (itr1.getId() != 0 && itr1.getId() == id) {
                return itr1;
            }
        }

        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItemList);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(Boolean done) {
        List<TodoItem> doneList = new ArrayList<>();
        for (TodoItem itr1 : todoItemList) {
            if (itr1.isDone()) {

                doneList.add(itr1);
            }
        }
        return doneList;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        if (title == null) throw new IllegalArgumentException("Title is null");
        List<TodoItem> titleList = new ArrayList<>();

        for (TodoItem itr1 : todoItemList) {
            if (!(itr1.getTitle().equals(null)) && itr1.getTitle() == title) {

                titleList.add(itr1);
            }
        }
        return titleList;

    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        if (personId == 0) throw new IllegalArgumentException("Person Id is null");
        List<TodoItem> personList = new ArrayList<>();

        for (TodoItem itr1 : todoItemList) {
            if ((itr1.getCreator().getId() != 0) && itr1.getCreator().getId() == personId) {

                personList.add(itr1);
            }
        }


        return personList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate deadline) {
        if (deadline == null) throw new IllegalArgumentException("Deadline was null");
        List<TodoItem> DeadlineBeforeList = new ArrayList<>();
        for (TodoItem itr1 : todoItemList) {

            if (!(itr1.getDeadline().equals(null)) && itr1.getDeadline().isBefore(deadline)) {

                DeadlineBeforeList.add(itr1);
            }
        }


        return DeadlineBeforeList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate deadline) {
        if (deadline.equals(null)) throw new IllegalArgumentException("Date was null");
        List<TodoItem> DeadlineAfterList = new ArrayList<>();
        for (TodoItem itr1 : todoItemList) {

            if (itr1.getDeadline().isAfter(deadline)) {

                DeadlineAfterList.add(itr1);
            }
        }


        return DeadlineAfterList;
    }

    @Override
    public void remove(int id) {
        if (id == 0) throw new IllegalArgumentException("Id is null");
        TodoItem removeId = findById(id);
        if (removeId == null) throw new IllegalArgumentException("Id Not found to remove");
        todoItemList.remove(removeId);

    }
}
