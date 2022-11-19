package se.lexicon;

import se.lexicon.DAO.*;
import se.lexicon.utility.FromFileSystem;
import se.lexicon.utility.ToFileSystem;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Todo Assignment
 */
public class App {
    public static void main(String[] args) {


        List<AppUser> appUser = new ArrayList<>();
        List<Person> person = new ArrayList<>();
        List<TodoItem> task = new ArrayList<>();
        List<TodoItemTask> todoTask = new ArrayList<>();

        // Reading from file and Placing it in List

       /* FromFileSystem FS = new FromFileSystem();
        List<Type> user = FS.parsePerson();

        for (Type use : user) {

            System.out.println(use + "\n");
        }*/


        System.out.println("############################Opertions on AppUser########################################");

        IAppUserDAO appUserDAOCollection = new AppUserDAOCollection(appUser);
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


        System.out.println("\n############################Opertions on Person########################################");

        IPersonDAO personDAOCollection = new PersonDAOCollection(person);

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
        ITodoItemDAO todoItemDAOCollection = new TodoItemDAOCollection(task);


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
        System.out.println(todoItemDAOCollection.findByPersonId(createdperson1.getId()));
        System.out.println("-------------------------Find by Title------------------------------------------------------");

        System.out.println(todoItemDAOCollection.findByTitleContains("Scrum Meeting"));
        System.out.println("-------------------------Removed Todo Item 3 and checking whether it exist------------------------");
        todoItemDAOCollection.remove(todo3.getId());

        System.out.println(todoItemDAOCollection.findById(todo3.getId()));


        System.out.println("##################TodoItem task information ##################");


        ITodoItemTaskDAO todoItemTaskDAOCollection = new TodoItemTaskDAOCollection(todoTask);

        TodoItemTask todoItemTask = todoItemTaskDAOCollection.persist(new TodoItemTask(todo1, createdperson1));
        TodoItemTask todoItemTask1 = todoItemTaskDAOCollection.persist(new TodoItemTask(todo2, createdperson2));
        // TodoItemTask todoItemTask2 = todoItemTaskDAOCollection.persist(new TodoItemTask(todo3));
        System.out.println(todoItemTask1.getAssignee());

        System.out.println("-------------------------Todo Item Task find All() ------------------------");
        System.out.println(todoItemTaskDAOCollection.findAll());
        System.out.println("-------------------------Todo Item Task findById() ------------------------");
        System.out.println(todoItemTaskDAOCollection.findById(todoItemTask.getId()));
        System.out.println("-------------------------Todo Item Task findByPersonId() ------------------------");
        System.out.println(todoItemTaskDAOCollection.findByPersonId(todoItemTask.getAssignee().getId()));
        System.out.println("-------------------------Todo Item Task findByAssignedStatus() ------------------------");
        System.out.println(todoItemTaskDAOCollection.findByAssignedStatus(true));
        System.out.println("-------------------------Todo Item Task remove() ------------------------");
        todoItemTaskDAOCollection.remove(todoItemTask1.getId());

        System.out.println(todoItemTaskDAOCollection.findById(todoItemTask1.getId()));

        // Storing Array list to Json file


        ToFileSystem ListToJson = new ToFileSystem();

        ListToJson.AppUserListToJson(appUser);
        ListToJson.PersonListToJson(person);
        ListToJson.TodoItemListToJson(task);
        ListToJson.TodoItemTaskListToJson(todoTask);

        System.out.println("\n############## All Data written to corresponding Json  File ##############");


    }
}
