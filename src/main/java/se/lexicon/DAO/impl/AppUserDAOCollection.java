package se.lexicon.DAO.impl;

import se.lexicon.DAO.IAppUserDAO;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.sequencers.AppUserIdSequencer;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class AppUserDAOCollection implements IAppUserDAO {

    private List<AppUser> appUserList;
    private static AppUserDAOCollection instance;

    private AppUserDAOCollection() {

        this.appUserList = new ArrayList<>();
    }

    public static AppUserDAOCollection getInstance() {
        if (instance == null) instance = new AppUserDAOCollection();
        return instance;
    }

    @Override
    public AppUser findByUsername(String username) {
        if (username.equals(null)) throw new IllegalArgumentException("User name is null");

        Optional<AppUser> optional = appUserList.stream().
                filter(appUser -> appUser.getUserName().equalsIgnoreCase(username)).findFirst();

        return optional.orElse(null);

    }

    @Override
    public List<AppUser> findByRole(AppRole role) {

        if (role == null) throw new IllegalArgumentException("Approle is null");

        return appUserList.stream().
                filter(appUser -> appUser.getAppRole().equals(role)).collect(Collectors.toList());


    }


    @Override
    public AppUser create(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("App user is  null");

        AppUser name = findByUsername(appUser.getUserName());

        if (name != null) throw new IllegalArgumentException("Name already present!!");
        appUser.setId(AppUserIdSequencer.nextId());
        appUserList.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findById(Integer id) {

        if (id == null) throw new IllegalArgumentException("App user is  null");
        //Predicate <AppUser> appUserPredicate= (appUser -> appUser.getUserName() == userName );

        Optional<AppUser> optional = appUserList.stream().
                filter(appUser -> appUser.getId() == id)
                .findFirst();


      /* for (AppUser itr1 : appUserList)
            if (!(itr1.getId().equals(null)) && itr1.getId().equals(id)) return itr1;*/

        return optional.orElse(null);


    }

    @Override
    public boolean deleteById(Integer id) {
        boolean remove = appUserList.removeIf(appUser -> appUser.getId() == id);

        return remove;
    }

    @Override
    public void update(String username, AppUser model) {

    }

    @Override
    public List<AppUser> findAll() {


        return new ArrayList<>(appUserList);

    }
}

