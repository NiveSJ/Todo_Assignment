package se.lexicon.DBA.Impl;

import se.lexicon.DBA.IpeopleDBA;
import se.lexicon.DBA.SQLConnection;
import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class peopleDBA implements IpeopleDBA {


    @Override
    public Person create(Person person) {

        String query = "insert into todoit.person(first_name,last_name) values(?,?); ";

        try (
                Connection connection = SQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);) {
            connection.setAutoCommit(false);

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());


            int AffectedRows = preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {

                if (resultSet.next()) {
                    person.setId(resultSet.getInt(1));
                    System.out.println("Person Created");
                }
            }
            connection.commit();

        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return person;


    }

    @Override
    public Collection<Person> findAll() {
        ArrayList<Person> personList = new ArrayList<>();

        Person person = new Person();

        String query = "select * from todoit.person";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            try (ResultSet rs = preparedStatement.executeQuery();) {

                while (rs.next()) {

                    person.setId(rs.getInt("person_id"));
                    person.setFirstName(rs.getString("first_name"));
                    person.setFirstName(rs.getString("last_name"));


                    personList.add(person);

                }
            }


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }

        return personList;
    }

    @Override
    public Person findById(int id) {

        Person person = new Person();

        String query = "select * from todoit.person where person_id = ?";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery();) {


                while (rs.next()) {

                    person.setId(rs.getInt("person_id"));
                    person.setFirstName(rs.getString("first_name"));
                    person.setFirstName(rs.getString("last_name"));

                }
            }


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }

        return person;
    }

    @Override
    public Person update(Person person) {
        String query = "update todoit.person set first_name = ?, last_name =  ?  where id = ?";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            connection.setAutoCommit(false);
            // set parameters
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getId());


            try (ResultSet rowsAffected = preparedStatement.executeQuery();) {
                System.out.println("Number of rows Affected with update:" + rowsAffected);
            }
            connection.commit();

        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();

        }


        return person;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "delete from todoit.person where person_id = ? ";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                System.out.println("Number of rows Deleted" + rs);
            }


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }


        return true;
    }

    @Override
    public Collection<Person> findByName(String name) {
        Person person = new Person();
        List<Person> personList = new ArrayList<>();

        String query = "select * from todoit.person where concat (first_name,\" \", last_name) = ?;";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setString(1, name);
            try (ResultSet rs = preparedStatement.executeQuery();) {


                while (rs.next()) {

                    person.setId(rs.getInt("person_id"));
                    person.setFirstName(rs.getString("first_name"));
                    person.setFirstName(rs.getString("last_name"));
                    personList.add(person);

                }
            }


        } catch (DBConnectionException | SQLException e) {
            System.err.println(e.getMessage());
        }

        return personList;
    }
}
