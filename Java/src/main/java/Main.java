import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    private static JsonParser parser = new JsonParser();
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Anwendung startet");
        String path = "src/main/java/example.json";
        readJson(path);
        System.out.println(getNameFromJson("{\"name\": \"Ines\"}"));
    }

    public static String getNameFromJson(String json){
        if(json == null){
            throw new NullPointerException("input must not be null");
        }
            JsonElement element = parser.parse(json);
            logger.info("JSON erfolgreich geparst");
            JsonObject object = element.getAsJsonObject();
            if(!object.has("name")){
                throw new IllegalArgumentException("JSON does not contain name");
            }
            String name = object.get("name").getAsString();
            logger.info("Name: {}", name);
            return name;
    }

    public static void readJson(String path){
        Gson gson = new Gson();
        try {
            Person person = gson.fromJson(new FileReader(path), Person.class);
            System.out.println(person.toString());
        } catch (FileNotFoundException e) {
            logger.error("File could not be found.");
        }
    }
}
