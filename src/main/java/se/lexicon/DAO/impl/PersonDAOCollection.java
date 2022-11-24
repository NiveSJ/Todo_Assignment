package se.lexicon.DAO.impl;


import se.lexicon.DAO.IPersonDAO;
import se.lexicon.Person;
import se.lexicon.sequencers.PersonIdSequencer;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PersonDAOCollection implements IPersonDAO {

    List<Person> personList ;

    public PersonDAOCollection(List<Person> personList) {
        this.personList = personList;

    }

    @Override
    public Person create(Person person) {


        if (person == null) throw new IllegalArgumentException("App user is  null");

        Person name = findById(person.getId());

        if (name != null) throw new IllegalArgumentException("Name already present!!");
        person.setId(PersonIdSequencer.nextId());
        personList.add(name);
        return person;

    }

    @Override
    public Person findById(Integer id) {

        if (id == null) throw new IllegalArgumentException("App user is  null");
        Optional<Person> optional = personList.stream().filter(person -> person.getId() == id).findFirst();
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
    public Consumer<Person> findAll() {

        Consumer<Person> finduser = (print) -> System.out.println(print);
        personList.forEach(finduser);
        return finduser;

    }

    @Override
    public List<Person> findByUsername(String username) {


        List<Person> filList = personList.stream().filter(person ->
                person.getCredentials().getUserName().equalsIgnoreCase(username)).
                collect(Collectors.toList());

        return filList;
    }


}
