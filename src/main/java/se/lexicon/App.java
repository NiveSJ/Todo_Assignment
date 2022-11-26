package se.lexicon;

import se.lexicon.DAO.*;
import se.lexicon.DAO.impl.AppUserDAOCollection;
import se.lexicon.controller.Controller;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

import java.util.*;

/**
 * Todo Assignment
 */
public class App {
    public static void main(String[] args) throws MyOwnRuntimeException {

        Controller controller = new Controller();
        controller.doMainMenu();

    }
}
