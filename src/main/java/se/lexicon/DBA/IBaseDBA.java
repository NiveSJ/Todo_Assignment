package se.lexicon.DBA;

import se.lexicon.exception.DBConnectionException;

import java.util.Collection;

public interface IBaseDBA<T> {

    T create(T t) ;

    Collection<T> findAll();

    T findById(int id);

    T update(T t);

    boolean deleteById(int id);
}
