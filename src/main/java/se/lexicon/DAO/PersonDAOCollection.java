package se.lexicon.DAO;

import se.lexicon.model.Person;

import java.util.Collection;
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
            if (itr1.getId() == id) return itr1;

        }

        return null;
    }

    @Override
    public Person findByEmail(String email) {

        for (Person itr1 : personList) {

            if (itr1.getEmail() == email) return itr1;

        }

        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return personList;
    }

    @Override
    public void remove(int id) {
        Person perId = findById(id);
        if (perId == null) throw new IllegalArgumentException("Person not available to remove");
        personList.remove(perId);

    }
}
