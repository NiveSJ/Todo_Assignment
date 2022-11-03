package se.lexicon;

/* boolean assigned is encapsulated and set to true if assignee  is not null
 */

public class TodoItemTask {

    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this.id = id;
        this.assigned = false;
        this.todoItem = todoItem;
        this.assignee = assignee;
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

        if(todoItem.equals(null))throw new IllegalArgumentException("Todo Item cannot be null");
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {

        if(!assignee.equals(null)){
            this.assignee = assignee;
            this.assigned=true;
        }

    }

    public String getSummary() {

        return "TodoItemTaskId:" + this.id + "\t" + "Task:" + this.todoItem.getTitle()  +"\t" + "by assignee:" +  this.assignee.getFirstName();
    }


}
