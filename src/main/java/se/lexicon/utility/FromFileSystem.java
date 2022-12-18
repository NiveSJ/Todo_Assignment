package se.lexicon.utility;

import java.io.*;

import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.DAO.impl.PersonDAOCollection;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

public class FromFileSystem {

    private static FromFileSystem instance;

    private FromFileSystem() {

    }

    public static FromFileSystem getInstance() {

        if (instance == null) instance = new FromFileSystem();
        return instance;

    }

    public List<AppUser> parseAppUser() throws IOException {

        String pathJSONFile = "src/main/java/se/lexicon/utility/AppUser.json";
        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File(pathJSONFile);
        List<AppUser> appuser = new ArrayList<>();

        appuser = mapper.readValue(jsonFile,
                mapper.getTypeFactory().constructCollectionType(List.class, AppUser.class));


        return appuser;
    }

    public List<Person> parsePerson() throws IOException {

        String pathJSONFile = "src/main/java/se/lexicon/utility/Person.json";
        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File(pathJSONFile);
        List<Person> person1 = new ArrayList<>();

        person1 = mapper.readValue(jsonFile,
                mapper.getTypeFactory().constructCollectionType(List.class, Person.class));


        return person1;
    }

    public List<TodoItem> parseTodoItem() throws IOException {

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

    public List<Person> read() {
        List<Person> people = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper(); // Json Object mapper
        objectMapper.registerModule(new JavaTimeModule());
        File file = new File("resources/Ipeople.json");
        try {
            people = objectMapper.readValue(file, new TypeReference<List<Person>>() {
            });
        } catch (IOException ex) {
            System.out.println(ex + " " + ex.getMessage());
        }
        return people;
    }


}