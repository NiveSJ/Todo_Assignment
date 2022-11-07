package se.lexicon.model;

public class AppUser extends Person {

    private String userName;
    private String password;

    private AppRole appRole;

// Can i get password and app role from user (Or App role has to be set by logic)
    public AppUser(int id, String firstName, String LastName, String email, String password, AppRole appRole) {
        super(id, firstName, LastName, email);
        setUserName();
        setPassword(password);
        setAppRole(appRole);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName() {
        this.userName = getFirstName() + " " + getLastName();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppRole getAppRole() {

        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }


    @Override  // Ask whether to display app role
    public String toString() {
        return super.toString() + '\'' + ", AppRole='" + appRole + '\'';

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
