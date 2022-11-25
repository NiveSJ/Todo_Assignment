package se.lexicon;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class PersonTest {

    @Test
    public void persontest() {

        AppUser appUser1 = new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN);
        Person person = new Person( "Nivethitha", "Jayanth", "nive@gmail.com",appUser1);
       // person[1] = new Person(1001, " ", " ", " ");

        String firstName = person.getFirstName();
        assertEquals("Nivethitha", firstName);


        assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName(null); });


        //LastName getter
        String Lastname = person.getLastName();
        assertEquals("Jayanth", Lastname);

        //setLastName exception throw
        assertThrows(IllegalArgumentException.class, () -> {
            person.setLastName(null); });


        //email getter check
        String email = person.getEmail();
        assertEquals("nive@gmail.com", email);

        //email exception throw
        assertThrows(IllegalArgumentException.class, () -> {
            person.setEmail(null); });


    }
}
