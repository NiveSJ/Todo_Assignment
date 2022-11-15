package se.lexicon.model;

/* boolean assigned is encapsulated and set to true if assignee  is not null
 */

import se.lexicon.sequencers.TodoItemTaskIdSequencer;

import java.util.Objects;

public class TodoItemTask  {

    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;



    public TodoItemTask( TodoItem todoItem, Person assignee) {
        TodoItemTaskIdSequencer.nextId();
        this.id=TodoItemTaskIdSequencer.getCurrentId();
        this.assigned = false;
        this.id = TodoItemTaskIdSequencer.getCurrentId();
        setTodoItem(todoItem);
        setAssignee(assignee);
    }
    public TodoItemTask(TodoItem todoItem) {
        TodoItemTaskIdSequencer.nextId();
        this.assigned = false;
        this.id=TodoItemTaskIdSequencer.getCurrentId();
        setTodoItem(todoItem);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        setAssignee(assignee);
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {

        if (todoItem == null) throw new IllegalArgumentException("Todo Item cannot be null");
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {

        if (assignee == null) throw new IllegalArgumentException("assignee cannot be null");
        this.assignee = assignee;
        this.assigned = true;
    }


    @Override  // Excluded Assignee person object
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id
                && assigned == that.assigned &&
                todoItem.equals(that.todoItem) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem);
    }
}
