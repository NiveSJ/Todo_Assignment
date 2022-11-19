package se.lexicon.DAO;

import se.lexicon.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PersonDAOCollection implements IPersonDAO {

    private List<Person> personList;

    public PersonDAOCollection(List<Person> personList) {
        this.personList = personList;

    }

    @Override
    public Person persist(Person person) {

        Person perIdCheck = findById(person.getId());

        if (perIdCheck != null) throw new IllegalArgumentException("Person already exist cannot be added");
        personList.add(person);

        return person;
    }

    @Override
    public Person findById(int id) {

        for (Person itr1 : personList) {
            if (itr1.getId() != 0 && itr1.getId() == id) return itr1;

        }

        return null;
    }

    @Override
    public Person findByEmail(String email) {
        if (email.equals(null)) throw new IllegalArgumentException("Email is null");

        for (Person itr1 : personList) {

            if (!(itr1.getEmail().equals(null)) && itr1.getEmail().equalsIgnoreCase(email)) return itr1;

        }

        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(personList);
    }

    @Override
    public void remove(int id) {
        if (id == 0) throw new IllegalArgumentException("Id is null");
        Person perId = findById(id);
        if (perId == null) throw new IllegalArgumentException("Person not available to remove");
        personList.remove(perId);

    }
}
