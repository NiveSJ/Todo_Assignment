package se.lexicon;

import se.lexicon.DBA.Impl.peopleDBA;
import se.lexicon.model.Person;

import java.util.Collection;

/**
 * Todo Assignment
 */
public class App {
    public static void main(String[] args) {

           peopleDBA peopleDBA= new peopleDBA();
       /*   Person per = new Person("Nivethitha", "Jay");

        Person person = peopleDB.create(per);
        if (person == null)

            System.out.println("Person already exist cannot create");

        peopleDB.findByName("Test Test").forEach(System.out::println);*/
        peopleDBA.findAll().forEach(System.out::println);
        System.out.println("Find by name\n");
        peopleDBA.findByName("Test Test").forEach(System.out::println);



    }
}
