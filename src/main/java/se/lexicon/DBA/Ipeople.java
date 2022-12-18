package se.lexicon.DBA;

import se.lexicon.model.Person;

import java.util.Collection;

public interface Ipeople extends IBaseDBA<Person> {

    Person create(Person person);

    Collection<Person> findAll();

    Person findById(int id);

    Person update(Person person);

    boolean deleteById(int id);

    Collection<Person> findByName(String name);


}
