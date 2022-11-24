package se.lexicon.DAO;

import se.lexicon.Person;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IPersonDAO extends IBaseDAO<Person> {

    List<Person> findByUsername(String username);

}
