package se.lexicon.DAO;

import se.lexicon.Person;

import java.util.Collection;
import java.util.Optional;

public interface IPersonDAO extends IBaseDAO<Person> {

    Optional<Person> findByUsername(String username);

}
