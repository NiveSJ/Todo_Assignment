package se.lexicon.DAO;

import org.junit.jupiter.api.Test;
import se.lexicon.AppRole;
import se.lexicon.AppUser;
import se.lexicon.DAO.impl.AppUserDAOCollection;
import se.lexicon.DAO.impl.PersonDAOCollection;
import se.lexicon.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonDAOCollectionTest {
    @Test
    public void personDAOCollectionTest() {
        List<AppUser> appUser = new ArrayList<>();
        List<Person> person = new ArrayList<>();

        IPersonDAO personDAOCollection = new PersonDAOCollection(person);
        IAppUserDAO appUserDAOCollection = new AppUserDAOCollection(appUser);

        AppUser createdAppUser = appUserDAOCollection.persist(new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN));

        Person createdPerson1 = personDAOCollection.persist(new Person("Nivethitha", "Jayanth", "nive@gmail.com", createdAppUser));

        // Checking persisted person
        assertEquals(person.get(0), createdPerson1);

        // Checking find all since i have added 1 person i have given person.get(0)
        Collection<Person> allPerson = personDAOCollection.findAll();

        for (Person persn : person)
            assertEquals(person.get(0), persn);

        Person id = personDAOCollection.findById(createdPerson1.getId());
        assertEquals(person.get(0), id);

        Person email = personDAOCollection.findByEmail("nive@gmail.com");
        assertEquals(person.get(0), email);

        personDAOCollection.remove(createdPerson1.getId());

        Person per = personDAOCollection.findById(createdPerson1.getId());

        assertEquals(null, per);
    }
}
