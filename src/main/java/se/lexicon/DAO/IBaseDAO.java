package se.lexicon.DAO;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public interface IBaseDAO<T> {
    T create(T model);

    T findById(Integer id);

    boolean deleteById(Integer id);

    void update(String username, T model);

    List<T> findAll();


}
