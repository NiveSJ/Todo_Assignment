package se.lexicon.DAO;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

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
            if (itr1.isAssigned() == true)
                assignedList.add(itr1);


        }
        return assignedList;
    }


    @Override
    public Collection<TodoItemTask> findByPersonId(Person personId) {
        if (personId == null) throw new IllegalArgumentException("Person id is nulll");
        List<TodoItemTask> personList = new ArrayList<>();
        for (TodoItemTask itr1 : todoItemTaskList) {
            if (itr1.getAssignee().getId() == personId.getId()) {
                personList.add(itr1);

            }
        }

        return personList;
    }


    @Override
    public void remove(int id) {
        if (id == 0) throw new IllegalArgumentException("Id is null");
        TodoItemTask remId = findById(id);
        if (remId == null) throw new IllegalArgumentException("No such task found to remove");
        todoItemTaskList.remove(remId);

    }
}
