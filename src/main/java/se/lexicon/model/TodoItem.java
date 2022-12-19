package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {


    private Integer id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;


    private Person assignee;

    public TodoItem() {
    }

    public TodoItem(String title, String taskDescription, LocalDate deadline, Person assignee) {


        setTitle(title);
        this.done = false;
        this.taskDescription = taskDescription;
        setDeadline(deadline);
        setDone(done);
        setAssignee(assignee);

    }

    public TodoItem(String title, String description, LocalDate deadline) {
        setTitle(title);
        this.taskDescription = description;
        setDeadline(deadline);

    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
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

        if (deadline == null) throw new IllegalArgumentException("Deadline cannot be null");
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    public boolean isOverdue() {

        if (this.deadline.isBefore(LocalDate.now()))
            return true;

        return false;
    }

    @Override
    public String toString() {

        String status = "Not done";
        if (this.done)
            status = "done";

        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}' + "\n";
    }

    @Override  // Excluded creator person objects
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id &&
                done == todoItem.done && title.equals(todoItem.title) &&
                taskDescription.equals(todoItem.taskDescription) &&
                deadline.equals(todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadline, done);
    }
}
