package se.lexicon.DAO;

import se.lexicon.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonDAO extends IBaseDAO<Person> {

    Optional<Person> findByUsername(String username);

}
