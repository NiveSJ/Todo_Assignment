package se.lexicon.DAO.impl;

import se.lexicon.AppRole;
import se.lexicon.AppUser;
import se.lexicon.DAO.IAppUserDAO;
import se.lexicon.sequencers.PersonIdSequencer;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class AppUserDAOCollection implements IAppUserDAO {

    List<AppUser> appUserList = new ArrayList<>();

    public AppUserDAOCollection(List<AppUser> appUser) {
        this.appUserList = appUser;


    }

    @Override
    public AppUser findByUsername(String username) {
        if (username.equals(null)) throw new IllegalArgumentException("User name is null");

        Optional<AppUser> optional = appUserList.stream().filter(appUser -> true && appUser.getUserName().
                equalsIgnoreCase(username)).findFirst();

        return optional.orElse(null);

       /* for (AppUser itr1 : appUserList) {
            if (!(itr1.getUserName().equals(null)) && itr1.getUserName().
                    equalsIgnoreCase(username)) return itr1;

        }*/


    }

    @Override
    public List<AppUser> findByRole(AppRole role) {

        if (role == null) throw new IllegalArgumentException("Approle is null");

        List<AppUser> filteredlist = appUserList.stream().
                filter(appUser -> appUser.getAppRole().equals(role)).collect(Collectors.toList());
        return filteredlist;


    }

    @Override
    public AppUser create(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("App user is  null");

        AppUser name = findByUsername(appUser.getUserName());

        if (name != null) throw new IllegalArgumentException("Name already present!!");
        appUser.setId(PersonIdSequencer.nextId());
        appUserList.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findById(Integer id) {

        if (id == null) throw new IllegalArgumentException("App user is  null");
        //Predicate <AppUser> appUserPredicate= (appUser -> appUser.getUserName() == userName );

        Optional<AppUser> optional = appUserList.stream().
                filter(appUser -> appUser.getId().equals(id))
                .findFirst();


      /* for (AppUser itr1 : appUserList)
            if (!(itr1.getId().equals(null)) && itr1.getId().equals(id)) return itr1;*/

        return optional.orElse(null);


    }

    @Override
    public boolean deleteById(Integer id) {
       boolean remove = appUserList.removeIf(appUser -> appUser.getId()== id);

        return remove;
    }

    @Override
    public void update(AppUser model) {

    }

    @Override
    public Consumer<AppUser> findAll() {


        Consumer<AppUser> finduser = (print) -> System.out.println(print);
        appUserList.forEach(finduser);
        return finduser;


    }
}

