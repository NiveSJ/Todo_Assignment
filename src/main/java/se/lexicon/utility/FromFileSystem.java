package se.lexicon.utility;

import java.io.*;

import java.util.*;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;// in play 2.3

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.AppUser;
import se.lexicon.Person;
import se.lexicon.TodoItem;

public class FromFileSystem {
    public static void main(String[] args) throws IOException {

        List<AppUser> list = parseAppUser();
        System.out.println(list);

        List<Person> list1 = parsePerson();
        System.out.println(list1);

        List<TodoItem> list2 = parseTodoItem();
        System.out.println(list2);


    }

    public static List<AppUser> parseAppUser() throws IOException {

        String pathJSONFile = "src/main/java/se/lexicon/utility/AppUser.json";
        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File(pathJSONFile);
        List<AppUser> appuser = new ArrayList<>();

        appuser = mapper.readValue(jsonFile,
                mapper.getTypeFactory().constructCollectionType(List.class, AppUser.class));
       /* List<Person> person = objectMapper.readValue(
                new File(""),
                new TypeReference<List<Person>>() {
                }.getType());*/


        return appuser;
    }

    public static List<Person> parsePerson() throws IOException {

        String pathJSONFile = "src/main/java/se/lexicon/utility/Person.json";
        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File(pathJSONFile);
        List<Person> person1 = new ArrayList<>();

        person1 = mapper.readValue(jsonFile,
                mapper.getTypeFactory().constructCollectionType(List.class, Person.class));


        return person1;
    }

    public static List<TodoItem> parseTodoItem() throws IOException {

        String pathJSONFile = "src/main/java/se/lexicon/utility/TodoItem.json";
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        mapper.registerModule(new JavaTimeModule());
        File jsonFile = new File(pathJSONFile);
        List<TodoItem> todoitem = new ArrayList<>();

        todoitem = mapper.readValue(jsonFile,
                mapper.getTypeFactory().constructCollectionType(List.class, TodoItem.class));


        return todoitem;
    }


}