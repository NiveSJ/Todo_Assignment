package se.lexicon.utility;

import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;
import se.lexicon.AppUser;
import se.lexicon.Person;
import se.lexicon.TodoItem;
import se.lexicon.TodoItemTask;

public class FromFileSystem {
    public static void main(String[] args) {
    }


    public List<Person> parsePerson() {
        JSONParser parser = new JSONParser();
        ArrayList<Person> listdata = null;
        try {
            listdata = new ArrayList<Person>();
            Object obj = parser.parse(new FileReader("src/main/java/se/lexicon/utility/Person.json"));
            JSONArray Fromfile = (JSONArray) obj;
            if (Fromfile != null) {

                //Iterating JSON array
                for (int i = 0; i < Fromfile.size(); i++) {

                    //Adding each element of JSON array into ArrayList
                    listdata.add((Person) Fromfile.get(i));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdata;
    }

    public List<AppUser> parseAppUser() {
        JSONParser parser = new JSONParser();
        ArrayList<AppUser> listdata = null;
        try {
            listdata = new ArrayList<AppUser>();
            Object obj = parser.parse(new FileReader("src/main/java/se/lexicon/utility/AppUser.json"));
            JSONArray Fromfile = (JSONArray) obj;
            if (Fromfile != null) {

                //Iterating JSON array
                for (int i = 0; i < Fromfile.size(); i++) {

                    //Adding each element of JSON array into ArrayList
                    listdata.add((AppUser) Fromfile.get(i));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdata;
    }

    public List<TodoItem> parseTodoItem() {
        JSONParser parser = new JSONParser();
        ArrayList<TodoItem> listdata = null;
        try {
            listdata = new ArrayList<TodoItem>();
            Object obj = parser.parse(new FileReader("src/main/java/se/lexicon/utility/TodoItem.json"));
            JSONArray Fromfile = (JSONArray) obj;
            if (Fromfile != null) {

                //Iterating JSON array
                for (int i = 0; i < Fromfile.size(); i++) {

                    //Adding each element of JSON array into ArrayList
                    listdata.add((TodoItem) Fromfile.get(i));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdata;
    }

    public List<TodoItemTask> parseTodoItemTask() {
        JSONParser parser = new JSONParser();
        ArrayList<TodoItemTask> listdata = null;
        try {
            listdata = new ArrayList<TodoItemTask>();
            Object obj = parser.parse(new FileReader("src/main/java/se/lexicon/utility/TodoItemTask.json"));
            JSONArray Fromfile = (JSONArray) obj;
            if (Fromfile != null) {

                //Iterating JSON array
                for (int i = 0; i < Fromfile.size(); i++) {

                    //Adding each element of JSON array into ArrayList
                    listdata.add((TodoItemTask) Fromfile.get(i));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdata;
    }

}