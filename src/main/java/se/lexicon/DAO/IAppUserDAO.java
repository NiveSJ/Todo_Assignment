package se.lexicon.DAO;

import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

import java.util.List;

public interface IAppUserDAO extends IBaseDAO<AppUser> {

    AppUser findByUsername(String username);

    List<AppUser> findByRole(AppRole role);


}
