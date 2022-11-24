package se.lexicon.utility;

import org.json.JSONArray;
import se.lexicon.AppUser;
import se.lexicon.Person;
import se.lexicon.TodoItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.awt.Event.TAB;

public class ToFileSystem {

    private static String AppUserJsonFilePath = "src/main/java/se/lexicon/utility/AppUser.json";
    private static String PersonJsonFilePath = "src/main/java/se/lexicon/utility/Person.json";
    private static String TodoItemJsonFilePath = "src/main/java/se/lexicon/utility/TodoItem.json";


    public void AppUserListToJson(List<AppUser> appUser) {

        JSONArray AppUserListToJsonArray = new JSONArray(appUser.toArray());
        try {
            FileWriter writer = new FileWriter(new File(AppUserJsonFilePath));

            writer.write(AppUserListToJsonArray.toString(TAB));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void PersonListToJson(List<Person> person) {

        JSONArray AppUserListToJsonArray = new JSONArray(person.toArray());
        try {
            FileWriter writer = new FileWriter(new File(PersonJsonFilePath));

            writer.write(AppUserListToJsonArray.toString(TAB));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void TodoItemListToJson(List<TodoItem> todoItem) {

        JSONArray AppUserListToJsonArray = new JSONArray(todoItem.toArray());
        try {
            FileWriter writer = new FileWriter(new File(TodoItemJsonFilePath));

            writer.write(AppUserListToJsonArray.toString(TAB));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
