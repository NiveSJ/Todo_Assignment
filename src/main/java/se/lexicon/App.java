package se.lexicon;

import se.lexicon.DAO.*;
import se.lexicon.DAO.impl.AppUserDAOCollection;

import java.util.*;

/**
 * Todo Assignment
 */
public class App {
    public static void main(String[] args) {

        List<AppUser> appUsers = new ArrayList<>();

        IAppUserDAO appUserDAO = new AppUserDAOCollection(appUsers);

        AppUser appUser1 = new AppUser("Nive", "8294769", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("Nive1", "829476966", AppRole.ROLE_APP_USER);
        AppUser appUser3 = new AppUser("Test", "tidjfk", AppRole.ROLE_APP_USER);
        System.out.println("Created app user");
        appUserDAO.create(appUser1);
        appUserDAO.create(appUser2);
        appUserDAO.create(appUser3);

        System.out.println("Using find all()\n");
        appUserDAO.findAll();

        System.out.println("Find by Username\n");
        System.out.println(appUserDAO.findByUsername("Nive"));

        System.out.println("Find by Role\n");
        System.out.println(appUserDAO.findByRole(AppRole.ROLE_APP_USER));

        System.out.println("remove user 1\n");
        appUserDAO.deleteById(appUser1.getId());

        System.out.println("Find by Id" + appUserDAO.findById(appUser1.getId()) + "\n");

        System.out.println("Using find all");
        appUserDAO.findAll();

    }
}
