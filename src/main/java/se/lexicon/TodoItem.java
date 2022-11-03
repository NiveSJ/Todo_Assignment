package se.lexicon;

import java.time.LocalDate;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;
    private Person creator;

    public TodoItem(int id, String title, String taskDescription, LocalDate deadline, Person creator) {
        this.id = id;
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.done = false;
        this.creator = creator;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.equals(null)) throw new IllegalArgumentException("Title cannot be empty");
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {

        if(deadline == null) throw new IllegalArgumentException("Deadline cannot be null");
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        boolean value = isOverdue();
        if (value)

            this.done = false;

        else
            this.done = true;

    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue() {

        if (this.deadline.isBefore(LocalDate.now()))
            return true;

        return false;
    }

    public String getSummary() {
        String status="Not done";
        if (this.done)
            status="done";


            return "Taskid:" + this.id + "\t" + "with title:" + this.title + "\t" + "and taskDescription:" + this.taskDescription + "\t" + "with deadline: " + this.deadline +
                    "\t" + "has been created by:" + this.creator.getFirstName() + "\n\t" + "is " + status;

    }

}
