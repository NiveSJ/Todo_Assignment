package se.lexicon.DAO;

import se.lexicon.exceptions.MyOwnRuntimeException;

import java.util.List;

public interface IBaseDAO<T> {
    T create(T model) throws MyOwnRuntimeException;

    T findById(Integer id);

    boolean deleteById(Integer id);

    List<T> findAll();


}
