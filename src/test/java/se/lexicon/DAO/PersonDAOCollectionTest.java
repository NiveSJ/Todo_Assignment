package se.lexicon.DAO;

import org.junit.jupiter.api.Test;
import se.lexicon.DAO.impl.AppUserDAOCollection;
import se.lexicon.DAO.impl.PersonDAOCollection;
import se.lexicon.exceptions.MyOwnRuntimeException;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonDAOCollectionTest {

    @Test
    public void updatePersonTestWithNoPerson() {

        AppUser user3 = new AppUser("Ananya", "12345", AppRole.ROLE_APP_USER);
        Person person3 = new Person("Ananya", "Jay", "Ananya@gmail.com", user3);

        Person updatedPerson = PersonDAOCollection.getInstance().update("Anika", person3);

        assertEquals(updatedPerson.getFirstName(), null);

    }

    @Test
    public void updatePersonTest() throws MyOwnRuntimeException {

        createUser();

        AppUser user3 = new AppUser("Ananya", "12345", AppRole.ROLE_APP_USER);
        Person person3 = new Person("Ananya", "Jay", "Ananya@gmail.com", user3);

        Person updatedPerson = PersonDAOCollection.getInstance().update("Anika", person3);
        assertEquals(person3.getFirstName(), updatedPerson.getFirstName());

    }

    private void createUser() throws MyOwnRuntimeException {

        AppUser user1 = new AppUser("Nive", "12345", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser("Anika", "12345", AppRole.ROLE_APP_USER);

        AppUserDAOCollection.getInstance().create(user1);
        AppUserDAOCollection.getInstance().create(user2);

        Person person1 = new Person("Nive", "Jay", "Nive@gmail.com", user1);
        Person person2 = new Person("Anika", "Jay", "Anika@gmail.com", user2);


        PersonDAOCollection.getInstance().create(person1);
        PersonDAOCollection.getInstance().create(person2);
    }

}
