package se.lexicon.DAO;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItemTask;

import java.util.Collection;
import java.util.List;

public class TodoItemTaskDAOCollection implements ITodoItemTaskDAO {
    private List<TodoItemTask> todoItemTaskList;

    public TodoItemTaskDAOCollection(List<TodoItemTask> todoItemTaskList) {
        this.todoItemTaskList = todoItemTaskList;


    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        return null;
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask itr1 : todoItemTaskList) {
            if (itr1.getId() == id) {
                return itr1;
            }

        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return todoItemTaskList;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        List<TodoItemTask> assignedList = null;
        for (TodoItemTask itr1 : todoItemTaskList) {
            if (itr1.isAssigned() == true)
                assignedList = (List<TodoItemTask>) itr1;


        }
        return assignedList;
    }


    @Override
    public Collection<TodoItemTask> findByPersonId(Person personId) {
        List<TodoItemTask> personList = null;
        for (TodoItemTask itr1 : todoItemTaskList) {
            if (itr1.getAssignee().getId() == personId.getId()) {
                personList = (List<TodoItemTask>) itr1;

            }
        }

        return personList;
    }


    @Override
    public void remove(int id) {
        TodoItemTask remId = findById(id);
        if (remId == null) throw new IllegalArgumentException("No such task found to remove");
        todoItemTaskList.remove(remId);

    }
}
