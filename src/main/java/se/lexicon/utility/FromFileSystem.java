package se.lexicon.utility;

import java.io.*;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;// in play 2.3

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;
import se.lexicon.AppUser;
import se.lexicon.Person;
import se.lexicon.TodoItem;
import se.lexicon.TodoItemTask;

public class FromFileSystem {
    public static void main(String[] args) throws IOException {

        List<AppUser> list = parseAppUser();
        System.out.println(list);

        List<Person> list1 = parsePerson();
        System.out.println(list1);

        // List<TodoItem> list2 = parseTodoItem();
        //  System.out.println(list2);
    }

    public static List<AppUser> parseAppUser() throws IOException {

        String pathJSONFile = "src/main/java/se/lexicon/utility/AppUser.json";
        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File(pathJSONFile);
        List<AppUser> person1 = new ArrayList<>();

        person1 = mapper.readValue(jsonFile,
                mapper.getTypeFactory().constructCollectionType(List.class, AppUser.class));
       /* List<Person> person = objectMapper.readValue(
                new File(""),
                new TypeReference<List<Person>>() {
                }.getType());*/


        return person1;
    }

    public static List<Person> parsePerson() throws IOException {

        String pathJSONFile = "src/main/java/se/lexicon/utility/Person.json";
        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File(pathJSONFile);
        List<Person> person1 = new ArrayList<>();

        person1 = mapper.readValue(jsonFile,
                mapper.getTypeFactory().constructCollectionType(List.class, Person.class));
       /* List<Person> person = objectMapper.readValue(
                new File(""),
                new TypeReference<List<Person>>() {
                }.getType());*/


        return person1;
    }

    public static List<TodoItem> parseTodoItem() throws IOException {

        String pathJSONFile = "src/main/java/se/lexicon/utility/TodoItem.json";
        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File(pathJSONFile);
        List<TodoItem> person1 = new ArrayList<>();

        person1 = mapper.readValue(jsonFile,
                mapper.getTypeFactory().constructCollectionType(List.class, TodoItem.class));
       /* List<Person> person = objectMapper.readValue(
                new File(""),
                new TypeReference<List<Person>>() {
                }.getType());*/


        return person1;
    }


}