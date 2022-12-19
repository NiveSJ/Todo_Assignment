package se.lexicon.exception;

public class DBConnectionException extends Exception {

    String message;

    public DBConnectionException(String message) {
        super(message);

    }
}
