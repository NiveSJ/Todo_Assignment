package se.lexicon;

public class Person {

    private int id;
    private String firstName;
    private String LastName;
    private String email;

    public Person(int id, String firstName, String LastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.LastName = LastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("First name cannot be null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        if (LastName==null) throw new IllegalArgumentException("Last name cannot be null");
        this.LastName = LastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email== null) throw new IllegalArgumentException("Email cannot be null");

        this.email = email;
    }

    public String getSummary() {

        return "Person Id:" + this.id +"\t"+ "Name:" + firstName +" "+ LastName +"\t" +"email:" + this.email;
    }


}
