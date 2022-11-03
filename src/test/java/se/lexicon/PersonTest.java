package se.lexicon;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import static junit.framework.TestCase.assertEquals;

public class PersonTest {

    @Test
    public void persontest() {
        Person person[] = new Person[2];
        person[0] = new Person(1001, "Nivethitha", "Jayanth", "nive@gmail.com");
        person[1] = new Person(1001, " ", " ", " ");

        String firstName = person[0].getFirstName();
        assertEquals("Nivethitha", firstName);


        assertThrows(IllegalArgumentException.class, () -> {
            person[1].setFirstName(null); });


        //LastName getter
        String Lastname = person[0].getLastName();
        assertEquals("Jayanth", Lastname);

        //
        assertThrows(IllegalArgumentException.class, () -> {
            person[1].setLastName(null); });


        //email getter check
        String email = person[0].getEmail();
        assertEquals("nive@gmail.com", email);
        assertThrows(IllegalArgumentException.class, () -> {
            person[1].setEmail(null); });


    }
}
