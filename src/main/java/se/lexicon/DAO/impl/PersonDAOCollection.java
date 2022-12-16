package se.lexicon.DAO.impl;


import se.lexicon.DAO.IPersonDAO;
import se.lexicon.exceptions.MyOwnRuntimeException;
import se.lexicon.model.Person;
import se.lexicon.sequencers.PersonIdSequencer;
import se.lexicon.utility.FromFileSystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class PersonDAOCollection implements IPersonDAO {

    private List<Person> personList;
    private static PersonDAOCollection instance;

    private PersonDAOCollection() throws IOException {
        this.personList = FromFileSystem.getInstance().parsePerson();

    }

    public static PersonDAOCollection getInstance() throws IOException {

        if (instance == null) instance = new PersonDAOCollection();
        return instance;

    }

    @Override
    public Person create(Person person) throws MyOwnRuntimeException {


        if (person == null) throw new IllegalArgumentException("Person is null");

        if (person.getCredentials() == null) throw new MyOwnRuntimeException("UserCredentials was null");

        Optional<Person> checkUsername = findByUsername(person.getCredentials().getUserName());
        if (checkUsername.isPresent()) throw new IllegalArgumentException("UserName already present!!");

        person.setId(PersonIdSequencer.nextId());
        personList.add(person);
        return person;

    }


    @Override
    public Person findById(Integer id) {


        Optional<Person> optional = personList.stream().filter(person ->
                person.getId().equals(id)).findFirst();
        return optional.orElse(null);

    }

    @Override
    public boolean deleteById(Integer id) {
        boolean remove = personList.removeIf(person -> person.getId() == id);

        return remove;
    }


    public Person update(String username, Person model) {
        if (model == null) throw new IllegalArgumentException("model to update is null");

        if (username == null) throw new IllegalArgumentException("username is null");

        Optional<Person> person1 = personList.stream().filter(person -> person.getCredentials().getUserName().
                equalsIgnoreCase(username)).findFirst();


        Person newPerson = new Person();

        if (person1.isPresent()) {

            newPerson = person1.get();

            newPerson = model;
        }

          /*  person1.get().setEmail(model.getEmail());
            person1.get().setFirstName(model.getFirstName());
            person1.get().setLastName(model.getLastName());
            person1.get().setCredentials(model.getCredentials());
        }*/

        return newPerson;
    }

    @Override
    public List<Person> findAll() {

        return new ArrayList<>(personList);
    }

    @Override
    public Optional<Person> findByUsername(String username) {


        Optional<Person> optional = personList.stream().filter(person ->
                        person.getCredentials().getUserName().equalsIgnoreCase(username)).
                findFirst();

        return optional;
    }


}
