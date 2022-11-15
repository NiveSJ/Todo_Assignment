package se.lexicon;

import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Moving data to arrayList
 * Reading from and writing List data to JSON file.
 */
public class App {
    public static void main(String[] args) {
        List<AppUser> appUser = new ArrayList<>();
        List<Person> person = new ArrayList<>();
        List<TodoItem> task = new ArrayList<>();
        List<TodoItemTask> Todotask = new ArrayList<>();

        appUser.add(new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN));
        appUser.add(new AppUser("Test1", "20wqfj", AppRole.ROLE_APP_USER));
        appUser.add(new AppUser("Test2", "20wqfj", AppRole.ROLE_APP_USER));


        person.add(new Person(1001, "Nivethitha", "Jayanth", "nive@gmail.com", appUser.get(0)));
        person.add(new Person(1002, "Jayanth", "Solai", "jay@gmail.com", appUser.get(1)));
        person.add(new Person(1003, "Jayanth", "Solai", "jay@gmail.com", appUser.get(2)));


        task.add(new TodoItem(2001, "Project Meeting", "Discuss about project setup",
                LocalDate.parse("2022-11-01"), person.get(0)));


        task.add(new TodoItem(2002, "Project Meeting1", "Discuss about project setup",
                LocalDate.parse("2022-11-10"), person.get(0)));


        System.out.println("############person Information####################");
        System.out.println(person.get(1));
        System.out.println(person.get(2));

        System.out.println("#################Todo Information#################");

        System.out.println(task.get(0));
        System.out.println(task.get(1));

        System.out.println("##################TodoItem task information Information##################");
        Todotask.add(new TodoItemTask(3001, task.get(0), person.get(1)));
        Todotask.add(new TodoItemTask(3001, task.get(1)));
        System.out.println(Todotask.get(0).toString());
        System.out.println(Todotask.get(1).toString());


    }
}
