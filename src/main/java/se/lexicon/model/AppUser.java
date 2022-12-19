package se.lexicon.model;

import java.util.Objects;

public class AppUser {

    private Integer id;
    private String userName;
    private String password;
    private AppRole appRole;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;
    
    public AppUser(String username, String password, AppRole appRole) {

        setUserName(username);
        setPassword(password);
        setAppRole(appRole);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null) throw new RuntimeException("id was null");
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        if (username == null) throw new IllegalArgumentException("username cannot be null");
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        if (password == null) throw new IllegalArgumentException("Password cannot be null");
        this.password = password;
    }

    public AppRole getAppRole() {

        return appRole;
    }

    public void setAppRole(AppRole appRole) {

        if (appRole == null) throw new IllegalArgumentException("appRole cannot be null");

        this.appRole = appRole;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "Id=" + id + '\'' +
                "userName='" + userName + '\'' +

                ", appRole=" + appRole +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return userName.equals(appUser.userName) && appRole == appUser.appRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, appRole);
    }
}