package se.lexicon;

import se.lexicon.controller.Controller;
import se.lexicon.exceptions.MyOwnRuntimeException;

/**
 * Todo Assignment
 */
public class App {
    public static void main(String[] args) throws MyOwnRuntimeException {

        Controller controller = new Controller();
        controller.doMainMenu();

    }
}
