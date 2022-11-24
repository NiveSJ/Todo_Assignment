package se.lexicon.DAO.impl;

import se.lexicon.DAO.IPersonDAO;
import se.lexicon.Person;

import java.util.*;
import java.util.function.Consumer;

public class PersonDAOCollection implements IPersonDAO {


    @Override
    public Person create(Person model) {
        return null;
    }

    @Override
    public Person findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public void update(Person model) {

    }

    @Override
    public Consumer<Person> findAll() {
        return null;
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        return Optional.empty();
    }
}

