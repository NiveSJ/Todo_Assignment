package se.lexicon.DBA.Impl;

import se.lexicon.DBA.ITodoDBA;
import se.lexicon.DBA.SQLConnection;
import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoDBA implements ITodoDBA {



    @Override
    public TodoItem create(TodoItem todoItem) {
        String query = "Insert into todoit.todo_item(title,description, deadline,done,assignee_id) values (?,?,?,?,?); ";

        try (
                Connection connection = SQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
            connection.setAutoCommit(false);

            preparedStatement.setString(1, todoItem.getTitle());
            preparedStatement.setString(2, todoItem.getTaskDescription());
            preparedStatement.setDate(3, Date.valueOf(todoItem.getDeadline()));
            preparedStatement.setBoolean(4, todoItem.isDone());
            preparedStatement.setInt(5, todoItem.getAssignee().getId());

            int AffectedRows = preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {

                if (resultSet.next()) {
                    todoItem.setId(resultSet.getInt(1));
                }
            }
            connection.commit();

        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return todoItem;
    }

    @Override
    public Collection<TodoItem> findAll() {

        ArrayList<TodoItem> todoItemsList = new ArrayList<>();
        TodoItem todoItem;


        String query = "select * from todoit.todo_item as todo,todoit.person as person where person.person_id = todo.assignee_id ";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            try (ResultSet rs = preparedStatement.executeQuery();) {

                while (rs.next()) {


                    todoItemsList.add(new
                            TodoItem(rs.getInt("todo_id"), rs.getString("title"),
                            rs.getString("description"), rs.getDate("deadline").toLocalDate(),
                            rs.getBoolean("done"), new Person(rs.getInt("person_id"),
                            rs.getString("first_name"), rs.getString("last_name"))));

                }
            }


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }

        return todoItemsList;
    }

    @Override
    public TodoItem findById(int id) {
        TodoItem todoItem = new TodoItem();
        Person person = new Person();


        String query = " select * from todoit.todo_item as todo,todoit.person as person where todo_id = ? and person.person_id = todo.assignee_id  ";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery();) {

                while (rs.next()) {

                    todoItem = new TodoItem(rs.getInt("todo_id"), rs.getString("title"),
                            rs.getString("description"), rs.getDate("deadline").toLocalDate(),
                            rs.getBoolean("done"), new Person(rs.getInt("person_id"),
                            rs.getString("first_name"), rs.getString("last_name")));
                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


        return todoItem;
    }

    @Override
    public TodoItem update(TodoItem todoItem) {

        String query = "update todoit.todo_item set title = ?, description=?, deadline = ?, done = ?, assignee_id =? where todo_id=? ";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            connection.setAutoCommit(false);
            // set parameters
            preparedStatement.setString(1, todoItem.getTitle());
            preparedStatement.setString(2, todoItem.getTaskDescription());
            preparedStatement.setDate(3, Date.valueOf((todoItem.getDeadline())));
            preparedStatement.setBoolean(4, todoItem.isDone());
            preparedStatement.setInt(5, todoItem.getAssignee().getId());
            preparedStatement.setInt(6, todoItem.getId());

            try (ResultSet rowsAffected = preparedStatement.executeQuery();) {
                System.out.println("Number of rows Affected with update:" + rowsAffected);
            }
            connection.commit();

        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();

        }


        return todoItem;
    }

    @Override
    public boolean deleteById(int id) {

        String query = "delete from todoit.todo_item where todo_id = ? ";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, id);

           int RA= preparedStatement.executeUpdate();
                System.out.println("Number of rows Deleted" + RA);



        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }


        return true;
    }

    @Override
    public Collection<TodoItem> findByDoneStatus(boolean status) {
        TodoItem todoItem = new TodoItem();
        Person person = new Person();
        ArrayList<TodoItem> todoItemsList = new ArrayList<>();


        String query = "select * from todoit.todo_item as todo,todoit.person as person where " +
                "person.person_id = todo.assignee_id. and todo.done = ? ";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setBoolean(1, true);

            try (ResultSet rs = preparedStatement.executeQuery();) {

                while (rs.next()) {

                    todoItemsList.add(new
                            TodoItem(rs.getInt("todo_id"), rs.getString("title"),
                            rs.getString("description"), rs.getDate("deadline").toLocalDate(),
                            rs.getBoolean("done"), new Person(rs.getInt("person_id"),
                            rs.getString("first_name"), rs.getString("last_name"))));

                }
            }

        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return todoItemsList;
    }

    @Override
    public Collection<TodoItem> findByAssignee(int id) {

        List<TodoItem> todoItemsList = new ArrayList<>();
        TodoItem todoItem = new TodoItem();
        Person person = new Person();

        String query = "select * from todoit.todo_item as todo,todoit.person as person " +
                "where person.person_id = todo.assignee_id and todo.assignee_id = ?";


        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {

                while (rs.next()) {

                    todoItemsList.add(new
                            TodoItem(rs.getInt("todo_id"), rs.getString("title"),
                            rs.getString("description"), rs.getDate("deadline").toLocalDate(),
                            rs.getBoolean("done"), new Person(rs.getInt("person_id"),
                            rs.getString("first_name"), rs.getString("last_name"))));

                }

            }


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


        return todoItemsList;
    }

    @Override
    public Collection<TodoItem> findByAssignee(Person person) {

        List<TodoItem> todoItemsList = new ArrayList<>();
        TodoItem todoItem = new TodoItem();


        String query = "select * from todoit.todo_item as todo,todoit.person as person where " +
                "person.person_id = todo.assignee_id and person.person_id = ? ";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, person.getId());

            try (ResultSet rs = preparedStatement.executeQuery()) {

                while (rs.next()) {

                    todoItemsList.add(new
                            TodoItem(rs.getInt("todo_id"), rs.getString("title"),
                            rs.getString("description"), rs.getDate("deadline").toLocalDate(),
                            rs.getBoolean("done"), new Person(rs.getInt("person_id"),
                            rs.getString("first_name"), rs.getString("last_name"))));

                }

            }


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


        return todoItemsList;


    }

    @Override
    public Collection<TodoItem> findByUnassignedTodoItem() {

        List<TodoItem> todoItemsList = new ArrayList<>();
        TodoItem todoItem = new TodoItem();
        Person person = new Person();

        String query = " select * from todoit.todo_item where assignee_id is NULL";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {


            try (ResultSet rs = preparedStatement.executeQuery()) {

                while (rs.next()) {
                    todoItemsList.add(new
                            TodoItem(rs.getInt("todo_id"), rs.getString("title"),
                            rs.getString("description"), rs.getDate("deadline").toLocalDate(),
                            rs.getBoolean("done")));

                }

            }


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


        return todoItemsList;

    }
}
