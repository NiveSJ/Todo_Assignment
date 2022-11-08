package se.lexicon;

import se.lexicon.model.*;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AppUser appUser1 = new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("Test1", "20wqfj", AppRole.ROLE_APP_USER);
        AppUser appUser3 = new AppUser("Test2", "20wqfj", AppRole.ROLE_APP_USER);


        Person teamLeader = new Person(1001, "Nivethitha", "Jayanth", "nive@gmail.com",appUser1);
        Person dev1 = new Person(1002, "Jayanth", "Solai", "jay@gmail.com",appUser2);
        Person dev2 = new Person(1003, "Jayanth", "Solai", "jay@gmail.com",appUser3);


        TodoItem task1 = new TodoItem(2001, "Project Meeting", "Discuss about project setup",
                LocalDate.parse("2022-11-01"), teamLeader);


        TodoItem task2 = new TodoItem(2002, "Project Meeting1", "Discuss about project setup",
                LocalDate.parse("2022-11-10"), teamLeader);


        System.out.println("############person Information####################");
        System.out.println(dev1);
        System.out.println(dev2);

        System.out.println("#################Todo Information#################");

        System.out.println(task1);
        System.out.println(task2);

        System.out.println("##################TodoItem task information Information##################");
        TodoItemTask todoItemTask1 =  new TodoItemTask(3001, task1, dev1);
        TodoItemTask todoItemTask2 =  new TodoItemTask(3001, task2);
        System.out.println(todoItemTask1.toString());
        System.out.println(todoItemTask2.toString());


    }
}
