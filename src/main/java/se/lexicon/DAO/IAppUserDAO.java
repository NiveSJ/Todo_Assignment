package se.lexicon.DAO;

import se.lexicon.AppRole;
import se.lexicon.AppUser;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IAppUserDAO extends IBaseDAO<AppUser> {

    AppUser findByUsername(String username);

    List<AppUser> findByRole(AppRole role);


}
