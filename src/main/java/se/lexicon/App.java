package se.lexicon;

import se.lexicon.DBA.Impl.peopleDBA;
import se.lexicon.model.Person;

import java.sql.Connection;
import java.util.List;

/**
 * Todo Assignment
 */
public class App {
    public static void main(String[] args) {

        Person per = new Person("Nivethitha", "Jay");

       Person person =peopleDBA.getInstance().create(per);
        if (person== null)

        System.out.println("Person already exist cannot create");

        peopleDBA.getInstance().findByName("Test Test").forEach(System.out::println);


    }
}
