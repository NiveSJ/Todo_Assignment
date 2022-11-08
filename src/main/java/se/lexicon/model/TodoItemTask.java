package se.lexicon.model;

/* boolean assigned is encapsulated and set to true if assignee  is not null
 */

import java.util.Objects;

public class TodoItemTask {

    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask() {

        this.assigned = false;
    }

    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this();
        this.id = id;
        setTodoItem(todoItem);
        setAssignee(assignee);
    }
    public TodoItemTask(int id, TodoItem todoItem) {
        this();
        this.id = id;
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

    public void setTodoItem(TodoItem todoItem) {   // Ask about object equals() check here

        if (todoItem == null) throw new IllegalArgumentException("Todo Item cannot be null");
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {    // Ask about object equals() check here

        if (assignee == null) throw new IllegalArgumentException("assignee cannot be null");
        this.assignee = assignee;
        this.assigned = true;
    }


    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                ", assignee=" + assignee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem, assignee);
    }
}
