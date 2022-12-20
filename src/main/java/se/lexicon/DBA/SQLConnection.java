package se.lexicon.DBA;

import se.lexicon.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    private static final String DB_USER = "root";
    private static final String DB_PWD = "Nive";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1/todoit";


    public static Connection getConnection() throws DBConnectionException {

        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (SQLException e) {
            throw new DBConnectionException("Problem with Database connection,Please Troubleshoot!!");
        }

    }
}
