package se.lexicon;

import se.lexicon.DAO.AppUserDAOCollection;
import se.lexicon.DAO.PersonDAOCollection;
import se.lexicon.DAO.TodoItemDAOCollection;
import se.lexicon.DAO.TodoItemTaskDAOCollection;
import se.lexicon.model.*;
import se.lexicon.sequencers.PersonIdSequencer;
import se.lexicon.sequencers.TodoItemIdSequencer;
import se.lexicon.sequencers.TodoItemTaskIdSequencer;
import se.lexicon.utility.ToFileSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Moving data to arrayList
 */
public class App {
    public static void main(String[] args) {

        System.out.println(PersonIdSequencer.nextId()); // 101
        System.out.println(PersonIdSequencer.getCurrentId()); // 101
        System.out.println(PersonIdSequencer.nextId()); // 102
        System.out.println(PersonIdSequencer.getCurrentId()); // 102

        System.out.println("--------------------------");


        List<AppUser> appUser = new ArrayList<>();
        List<Person> person = new ArrayList<>();
        List<TodoItem> task = new ArrayList<>();
        List<TodoItemTask> Todotask = new ArrayList<>();


        System.out.println("############################Opertions on AppUser########################################");

        AppUserDAOCollection appUserDAOCollection = new AppUserDAOCollection(appUser);
        // Creation Using Persist
        AppUser createdAppUser = appUserDAOCollection.persist(new AppUser("Test", "20wqfj", AppRole.ROLE_APP_ADMIN));
        AppUser createdAppUser1 = appUserDAOCollection.persist(new AppUser("Test1", "20wqfj", AppRole.ROLE_APP_USER));
        AppUser createdAppUser2 = appUserDAOCollection.persist(new AppUser("Test2", "20wqfj", AppRole.ROLE_APP_USER));
        AppUser createdAppUser3 = appUserDAOCollection.persist(new AppUser("Test3", "20wqfj", AppRole.ROLE_APP_USER));
        System.out.println("------FindALL()--------");
        System.out.println(appUserDAOCollection.findAll());


        System.out.println("------FindBYUSERNAME(\"Test2\")--------");
        System.out.println(appUserDAOCollection.findByUserName("Test2"));


        System.out.println("-----------------Remove(\"Test3\")-----------");
        appUserDAOCollection.remove("Test3");


        System.out.println("--------------checking removed APPUSER----------------");
        System.out.println(appUserDAOCollection.findByUserName("Test3"));

        ToFileSystem AppusertoJson = new ToFileSystem();
        AppusertoJson.AppUserListToJson(appUser);


        System.out.println("\n############################Opertions on Person########################################");

        PersonDAOCollection personDAOCollection = new PersonDAOCollection(person);

        Person createdperson1 = personDAOCollection.persist(new Person("Nivethitha", "Jayanth", "nive@gmail.com", createdAppUser));
        Person createdperson2 = personDAOCollection.persist(new Person("Jayanth", "Solai", "jay@gmail.com", createdAppUser1));
        Person createdperson3 = personDAOCollection.persist(new Person("Test", "Test", "Test@gmail.com", createdAppUser2));
        Person createdperson4 = personDAOCollection.persist(new Person("Test", "Test", "Test@gmail.com", createdAppUser3));

        System.out.println("---Created Person by find all()---");
        System.out.println(personDAOCollection.findAll());
        System.out.println("---------------------");
        System.out.println("---Created Person by find by id()---");
        System.out.println(personDAOCollection.findById(createdperson3.getId()));


        System.out.println("---Created Person by find by email---");
        System.out.println(personDAOCollection.findByEmail("jay@gmail.com"));
        System.out.println("---Created Person remove(createdperson4)---");
        personDAOCollection.remove(createdperson4.getId());
        System.out.println("--- removed(createdperson4) and not found---");
        System.out.println(personDAOCollection.findById(createdperson4.getId()));


        System.out.println("##################### Operations on Created Task ###################################");

        //System.out.println(TodoItemIdSequencer.nextId());
        //System.out.println(TodoItemIdSequencer.getCurrentId());
        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection(task);


        TodoItem todo1 = todoItemDAOCollection.persist(new TodoItem("Project Meeting", "Discuss about project setup",
                LocalDate.parse("2022-11-01"), createdperson1));

        TodoItem todo2 = todoItemDAOCollection.persist(new TodoItem("Project Meeting1", "Discuss about project setup",
                LocalDate.parse("2022-11-10"), createdperson1));
        TodoItem todo3 = todoItemDAOCollection.persist(new TodoItem("Scrum Meeting", "Daily's Meeting",
                LocalDate.parse("2022-11-20"), createdperson1));


        System.out.println("-----------------Created Todo Information by find all()---------------------------");
        System.out.println(todoItemDAOCollection.findAll());

        System.out.println("-----------------Created Todo Information by find byid(todo1.getId())---------------------------");
        System.out.println(todoItemDAOCollection.findById(todo1.getId()));

        System.out.println("---------------------Find by done status true --------------------------------------------------");
        System.out.println(todoItemDAOCollection.findAllByDoneStatus(true));
        System.out.println("-------------------------Deadline after current date----------------------------------------------");
        System.out.println(todoItemDAOCollection.findByDeadlineAfter(LocalDate.now()));
        System.out.println("-------------------------Deadline Before current date---------------------------------------------");
        System.out.println(todoItemDAOCollection.findByDeadlineBefore(LocalDate.now()));
        System.out.println("-------------------------Find by Person id()------------------------------------------------------");
        System.out.println(todoItemDAOCollection.findByPersonId(createdperson3));

        System.out.println(todoItemDAOCollection.findByTitleContains("Scrum Meeting"));
        System.out.println("-------------------------Removed Todo Item 3 and checking whether it exist------------------------");
        todoItemDAOCollection.remove(todo3.getId());

        System.out.println(todoItemDAOCollection.findById(todo3.getId()));


        System.out.println("##################TodoItem task information ##################");

        System.out.println(TodoItemTaskIdSequencer.nextId());
        System.out.println(TodoItemIdSequencer.getCurrentId());
        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection(Todotask);

        TodoItemTask todoItemTask = todoItemTaskDAOCollection.persist(new TodoItemTask(todo1, createdperson1));
        TodoItemTask todoItemTask1 = todoItemTaskDAOCollection.persist(new TodoItemTask(todo2, createdperson2));
        TodoItemTask todoItemTask2 = todoItemTaskDAOCollection.persist(new TodoItemTask(todo3));

        System.out.println("-------------------------Todo Item Task find All() ------------------------");
        Collection<TodoItemTask> ItemTask = todoItemTaskDAOCollection.findAll();
        System.out.println("-------------------------Todo Item Task findById() ------------------------");
        System.out.println(todoItemTaskDAOCollection.findById(todoItemTask.getId()));
        System.out.println("-------------------------Todo Item Task findByPersonId() ------------------------");
        System.out.println(todoItemTaskDAOCollection.findByPersonId(todoItemTask1.getAssignee()));
        System.out.println("-------------------------Todo Item Task findByAssignedStatus() ------------------------");
        System.out.println(todoItemTaskDAOCollection.findByAssignedStatus(true));
        System.out.println("-------------------------Todo Item Task remove() ------------------------");
        todoItemTaskDAOCollection.remove(todoItemTask2.getId());


    }
}
