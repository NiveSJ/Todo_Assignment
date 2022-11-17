package se.lexicon.DAO;

import se.lexicon.AppUser;

import java.util.Collection;

public interface IAppUserDAO {

    AppUser persist(AppUser appUser);

    AppUser findByUserName(String userName);

    Collection<AppUser> findAll();

    void remove(String userName);


}
