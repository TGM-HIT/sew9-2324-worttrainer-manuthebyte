import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Represents a persist method that uses JSON
 *
 * @author Manuel Glenk
 * @version 2023-09-20
 */
public class JsonPersistMethod implements PersistMethod {
    private String filename;

    public JsonPersistMethod(String filename) {
        this.filename = filename;
    }

    public void persist(TrainerStatistics stats) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("total", stats.getTotal());
        jsonObject.addProperty("correct", stats.getCorrect());
        jsonObject.addProperty("wrong", stats.getWrong());

        try {
            JsonWriter jsonWriter = new JsonWriter(new FileWriter(this.filename));
            jsonWriter.jsonValue(jsonObject.toString());
            jsonWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TrainerStatistics load() {
        if(!new File(this.filename).exists()) {
            return new TrainerStatistics();
        }

        try {
            JsonReader jsonReader = new JsonReader(new FileReader(this.filename));
            JsonObject jsonObject = new JsonParser().parse(jsonReader).getAsJsonObject();

            TrainerStatistics stats = new TrainerStatistics();
            stats.setTotal(jsonObject.get("total").getAsInt());
            stats.setCorrect(jsonObject.get("correct").getAsInt());
            stats.setWrong(jsonObject.get("wrong").getAsInt());

            return stats;
        } catch (Exception e) {
            e.printStackTrace();
            return new TrainerStatistics();
        }
    }
}
