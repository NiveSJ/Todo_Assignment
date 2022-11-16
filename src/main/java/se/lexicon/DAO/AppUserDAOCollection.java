package se.lexicon.DAO;

import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppUserDAOCollection implements IAppUserDAO {

    private List<AppUser> appUsersObjList;


    public AppUserDAOCollection(List<AppUser> appUsers) {
        this.appUsersObjList = appUsers;

    }

    @Override
    public AppUser persist(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("App user is  null");

        AppUser name = findByUserName(appUser.getUserName());

        if (name != null) throw new IllegalArgumentException("Name already present!!");
        appUsersObjList.add(appUser);
        return appUser;


    }

    @Override
    public AppUser findByUserName(String userName) {
        if (userName.equals(null)) throw new IllegalArgumentException("User name is null");

        //Predicate <AppUser> appUserPredicate= (appUser -> appUser.getUserName() == userName );

      /*  Optional<AppUser> optional =appUsersObjList.stream().
                filter(appUser -> appUser.getUserName().equals(userName))
                .findFirst();*/

        for (AppUser itr1 : appUsersObjList) {
            if (!(itr1.getUserName().equals(null)) && itr1.getUserName().equalsIgnoreCase(userName)) return itr1;

        }
        return null;

        // return optional.orElse(null);
    }

    @Override
    public Collection<AppUser> findAll() {
        return new ArrayList<>(appUsersObjList);
    }

    @Override
    public void remove(String userName) {
        if (userName.equals(null)) throw new IllegalArgumentException("User name is null");

        AppUser name = findByUserName(userName);
        if (name == null) throw new IllegalArgumentException("User name not present to remove");
        appUsersObjList.remove(name);


    }
}
