package se.lexicon.DAO.impl;


import se.lexicon.DAO.IPersonDAO;
import se.lexicon.model.Person;
import se.lexicon.sequencers.PersonIdSequencer;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PersonDAOCollection implements IPersonDAO {

    private List<Person> personList;
    private static PersonDAOCollection instance;

    private PersonDAOCollection() {
        this.personList = new ArrayList<>();

    }

    public static PersonDAOCollection getInstance() {

        if (instance == null) instance = new PersonDAOCollection();
        return instance;

    }

    @Override
    public Person create(Person person) {


        if (person == null) throw new IllegalArgumentException("Person is null");

        if (person.getCredentials() == null) throw new RuntimeException("UserCredentials was null");
        Optional<Person> checkUsername = findByUsername(person.getCredentials().getUserName());
        if (checkUsername.isPresent()) throw new IllegalArgumentException("UserName already present!!");


        person.setId(PersonIdSequencer.nextId());
        personList.add(person);
        return person;

    }


    @Override
    public Person findById(Integer id) {

        //if (id == null) throw new IllegalArgumentException("Person is  null");
        Optional<Person> optional = personList.stream().filter(person ->
                person.getId().equals(id)).findFirst();
        return optional.orElse(null);

    }

    @Override
    public boolean deleteById(Integer id) {
        boolean remove = personList.removeIf(person -> person.getId() == id);

        return remove;
    }

    @Override
    public void update(Person model) {
        if (model == null) throw new IllegalArgumentException("Person to update is null");

        // personList.stream().filter(person -> person.getId() == model.getId()).anyMatch()

        for (Person person : personList) {
            if (person.getId() == (model.getId())) {
                person.setEmail(model.getEmail());
                person.setFirstName(model.getFirstName());
                person.setLastName(model.getLastName());
                person.setCredentials(model.getCredentials());
                break;
            }
        }


    }

    @Override
    public List<Person> findAll() {

        return new ArrayList<>(personList);
    }

    @Override
    public  Optional<Person> findByUsername(String username) {


        Optional<Person> optional = personList.stream().filter(person ->
                        person.getCredentials().getUserName().equalsIgnoreCase(username)).
                findFirst();

        return optional;
    }


}
