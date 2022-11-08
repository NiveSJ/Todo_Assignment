package se.lexicon;

import se.lexicon.model.*;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Person person[] = new Person[5];

        person[0] = new Person(1001, "Nivethitha", "Jayanth", "nive@gmail.com");
        person[1] = new Person(1002, "Jayanth", "Solai", "jay@gmail.com");


        TodoItem todoItem[] = new TodoItem[5];
        todoItem[0] = new TodoItem(2001, "Project Meeting", "Discuss about project setup",
                LocalDate.parse("2022-11-01"), person[0]);


        System.out.println("############person Information####################");
        System.out.println(person[0]);
        System.out.println("\n");

        System.out.println("#################Todo Information#################");

        System.out.println(todoItem[0]);
        System.out.println("\n");

        System.out.println("##################TodoItem task information Information##################");
        TodoItemTask todoItemTask[] = new TodoItemTask[2];
        todoItemTask[0] = new TodoItemTask(3001, todoItem[0], person[0]);
        System.out.println(todoItemTask[0]);




        System.out.println("##################AppUser##################");

        AppUser appUser = new AppUser(20, "Erik", "Johnsson", "erik@gmail.com",
                "20wqfj", AppRole.ROLE_APP_USER);
        System.out.println(appUser.toString());


    }
}
