package se.lexicon.utility;

import org.json.JSONArray;
import se.lexicon.model.AppUser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.awt.Event.ENTER;
import static java.awt.Event.TAB;

public class ToFileSystem {

    private static String AppUserJsonFilePath = "src/main/java/se/lexicon/utility/AppUser.json";

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


}
