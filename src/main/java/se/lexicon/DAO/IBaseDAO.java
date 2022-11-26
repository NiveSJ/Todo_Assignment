package se.lexicon.DAO;

import se.lexicon.MyOwnRuntimeException;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public interface IBaseDAO<T> {
    T create(T model) throws MyOwnRuntimeException;

    T findById(Integer id);

    boolean deleteById(Integer id);

    List<T> findAll();


}
