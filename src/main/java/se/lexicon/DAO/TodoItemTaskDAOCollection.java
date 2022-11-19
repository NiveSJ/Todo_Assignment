package se.lexicon.DAO;

import se.lexicon.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemTaskDAOCollection implements ITodoItemTaskDAO {
    private List<TodoItemTask> todoItemTaskList;

    public TodoItemTaskDAOCollection(List<TodoItemTask> todoItemTaskList) {
        this.todoItemTaskList = todoItemTaskList;


    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {

        TodoItemTask todoTaskId = findById(todoItemTask.getId());
        if (todoTaskId != null) throw new IllegalArgumentException("Item already present");
        todoItemTaskList.add(todoItemTask);

        return todoItemTask;

    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask itr1 : todoItemTaskList) {
            if (itr1.getId() != 0 && itr1.getId() == id) {
                return itr1;
            }

        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTaskList);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        List<TodoItemTask> assignedList = new ArrayList<>();
        for (TodoItemTask itr1 : todoItemTaskList) {
            if (itr1.isAssigned())
                assignedList.add(itr1);


        }
        return assignedList;
    }


    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        if (personId == 0) throw new IllegalArgumentException("Person id is null");
        List<TodoItemTask> perlist = new ArrayList<>();
        for (TodoItemTask itr1 : todoItemTaskList) {
            System.out.println(itr1.getAssignee().getId());
            if (itr1.getAssignee().getId() != 0 && itr1.getAssignee().getId() == personId) {
                perlist.add(itr1);

            }
        }

        return perlist;
    }


    @Override
    public void remove(int id) {
        if (id == 0) throw new IllegalArgumentException("Id is null");
        TodoItemTask remId = findById(id);
        if (remId == null) throw new IllegalArgumentException("No such task found to remove");
        todoItemTaskList.remove(remId);

    }
}
