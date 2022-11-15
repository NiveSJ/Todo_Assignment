package se.lexicon.DAO;

import se.lexicon.model.AppUser;

import java.util.Collection;
import java.util.List;

public interface IAppUserDAO {

    AppUser persist(AppUser appUser);

    AppUser findByUserName(String userName);

    Collection<AppUser> findAll();

    void remove(String userName);


}
