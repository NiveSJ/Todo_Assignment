package se.lexicon.DAO;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOCollection implements ITodoItemDAO {

    private List<TodoItem> todoItemList;

    public TodoItemDAOCollection(List<TodoItem> todoItemList) {
        this.todoItemList = todoItemList;
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        TodoItem todoId = findById(todoItem.getId());
        if (todoId != null) throw new IllegalArgumentException("Item already present");
        todoItemList.add(todoId);

        return todoId;
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem itr1 : todoItemList) {
            if (itr1.getId() == id) {
                return itr1;
            }
        }

        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(Boolean done) {
        List<TodoItem> doneList = null;
        for (TodoItem itr1 : todoItemList) {
            if (itr1.isDone()) {

                 doneList = (List<TodoItem>) itr1;
            }
        }
        return doneList;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {

        List<TodoItem> titleList = null;

        for (TodoItem itr1 : todoItemList) {
            if (itr1.getTitle()== title) {

                titleList = (List<TodoItem>) itr1;
            }
        }
        return titleList;

    }

    @Override
    public Collection<TodoItem> findByPersonId(Person personId) {
        List<TodoItem> personList = null;

        for(TodoItem itr1 : todoItemList) {
            if (itr1.getCreator().getId() == personId.getId()  ){

                personList = (List<TodoItem>) itr1;
            }
        }



        return personList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate deadline) {
        List<TodoItem> DeadlineBeforeList = null;
        for(TodoItem itr1 : todoItemList) {

            if(itr1.getDeadline().isBefore(deadline)){

                DeadlineBeforeList = (List<TodoItem>) itr1;
            }
        }


        return DeadlineBeforeList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate deadline) {
        List<TodoItem> DeadlineAfterList = null;
        for(TodoItem itr1 : todoItemList) {

            if(itr1.getDeadline().isAfter(deadline)){

                DeadlineAfterList = (List<TodoItem>) itr1;
            }
        }


        return DeadlineAfterList;
    }

    @Override
    public void remove(int id) {
        TodoItem remve=findById(id);
        if(remve == null) throw new IllegalArgumentException("Id Not found to remove");
        todoItemList.remove(remve);

    }
}
