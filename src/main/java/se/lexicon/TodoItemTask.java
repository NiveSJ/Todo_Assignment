package se.lexicon;

/* boolean assigned is encapsulated and set to true if assignee  is not null
 */

public class TodoItemTask {

    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(){

        this.assigned = false;
    }
    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this();
        this.id = id;
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

        if (assignee == null) throw new IllegalArgumentException("assignee cannot be null");
            this.assignee = assignee;
            this.assigned=true;
        System.out.println("assigned:"+this.assigned);


    }

    public String getSummary() {


        return "TodoItemTaskId:" + this.id + "\t" + "Task:" + this.todoItem.getTitle()  +"\t" + "by assignee:" +  this.assignee.getFirstName();
    }


}
