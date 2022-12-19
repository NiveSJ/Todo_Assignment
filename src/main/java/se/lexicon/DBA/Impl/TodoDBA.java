package se.lexicon.DBA.Impl;

import se.lexicon.DBA.ITodoDBA;
import se.lexicon.DBA.SQLConnection;
import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class TodoDBA implements ITodoDBA {
    @Override
    public TodoItem create(TodoItem todoItem) {
        String query = "Insert into todoit.todo_item(title,description, deadline,done,assignee_id) values (?,?,?,?,?); ";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setString(1,todoItem.getTitle());
            preparedStatement.setString(2,todoItem.getTaskDescription());
            preparedStatement.setDate(3, Date.valueOf(todoItem.getDeadline()));
            preparedStatement.setBoolean(4,todoItem.isDone());
            preparedStatement.setInt(5,todoItem.getAssignee().get);



        } catch (DBConnectionException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<TodoItem> findAll() {
        return null;
    }

    @Override
    public TodoItem findById(int id) {
        return null;
    }

    @Override
    public TodoItem update(TodoItem todoItem) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public Collection<TodoItem> findByDoneStatus(boolean status) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByAssignee(int id) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByAssignee(Person person) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByUnassignedTodoItem() {
        return null;
    }
}
