package se.lexicon.DAO;

import org.junit.jupiter.api.Test;
import se.lexicon.DAO.impl.AppUserDAOCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppUserDAOCollectionTest {

/*
    @Test
    public void appUserDAOCollectionTest() {

        List<AppUser> appUser = new ArrayList<>();
        IAppUserDAO appUserDAOCollection = new AppUserDAOCollection(appUser);

        AppUser createdAppUser = appUserDAOCollection.persist(new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN));
        assertEquals(appUser.get(0), createdAppUser);


        Collection<AppUser> allUser = appUserDAOCollection.findAll();

        for (AppUser User : allUser)
            assertEquals(appUser.get(0), User);


        appUserDAOCollection.remove("Test");

        AppUser username1 = appUserDAOCollection.findByUserName("Test");

        assertEquals(null, username1);


    }
*/

}
