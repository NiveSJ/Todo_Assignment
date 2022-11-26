package se.lexicon.DAO;

import org.junit.jupiter.api.Test;
import se.lexicon.DAO.impl.AppUserDAOCollection;
import se.lexicon.DAO.impl.PersonDAOCollection;
import se.lexicon.MyOwnRuntimeException;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonDAOCollectionTest {
    @Test
    public void personDAOCollectionTest() throws MyOwnRuntimeException {
        AppUser user1 = new AppUser("Nive", "12345", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser("Anika", "12345", AppRole.ROLE_APP_USER);
        AppUser user3 = new AppUser("Ananya", "12345", AppRole.ROLE_APP_USER);
        AppUserDAOCollection.getInstance().create(user1);
        AppUserDAOCollection.getInstance().create(user2);

        Person person1 = new Person("Nive", "Jay", "Nive@gmail.com", user1);
        Person person2 = new Person("Anika", "Jay", "Anika@gmail.com", user2);
        Person person3 = new Person("Ananya", "Jay", "Ananya@gmail.com", user3);

        PersonDAOCollection.getInstance().create(person1);
        PersonDAOCollection.getInstance().create(person2);

        System.out.println("All Person by findall()" + PersonDAOCollection.getInstance().findAll());

        Optional<Person> updatedPerson = PersonDAOCollection.getInstance().update("Anika", person3);

        System.out.println("\nUpdated Statement " + updatedPerson.get());


    }
}
