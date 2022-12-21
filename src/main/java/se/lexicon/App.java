package se.lexicon;

import se.lexicon.DBA.ITodoDBA;
import se.lexicon.DBA.Impl.TodoDBA;
import se.lexicon.DBA.Impl.peopleDBA;
import se.lexicon.DBA.IpeopleDBA;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Todo Assignment
 */
public class App {
    public static void main(String[] args) {

        IpeopleDBA peopleDBA = new peopleDBA();
        ITodoDBA todoDBA = new TodoDBA();
       /*   Person per = new Person("Nivethitha", "Jay");

        Person person = peopleDB.create(per);
        if (person == null)

            System.out.println("Person already exist cannot create");

        peopleDB.findByName("Test Test").forEach(System.out::println);
        peopleDBA.findAll().forEach(System.out::println);
        System.out.println("Find by name\n");
        peopleDBA.findByName("Test Test").forEach(System.out::println);
        System.out.println("Find by Id");
        System.out.println(peopleDBA.findById(3));

        System.out.println("Update Person table");
        System.out.println(peopleDBA.update(new Person(10,"Anika","Test1")));

        System.out.println("Delete from person table"); */
        System.out.println(peopleDBA.deleteById(14));
        peopleDBA.findAll().forEach(System.out::println);

        //todoDBA.create(new TodoItem("Meeting5", "Project setup", LocalDate.parse("2023-01-04"),
              //  false, new Person(1, "Test", "Test")));
        System.out.println("Find all");
        todoDBA.findAll().forEach(System.out::println);
        System.out.println("Find by assignee");
        todoDBA.findByAssignee(1).forEach(System.out::println);
        System.out.println("Find by Assignee with person object");
        todoDBA.findByAssignee(new Person(2, "Test", "Test")).forEach(System.out::println);
        System.out.println("Find todo by Unassigned");

        todoDBA.findByUnassignedTodoItem().forEach(System.out::println);

        todoDBA.deleteById(10);


    }
}
