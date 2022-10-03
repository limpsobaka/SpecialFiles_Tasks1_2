import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class JSON {
  public static String listToJson(List<Employee> list) {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    Type listType = new TypeToken<List<Employee>>() {
    }.getType();
    return gson.toJson(list, listType);
  }

  public static List<Employee> parseJSON(String fileName) {
    List<Employee> list = new LinkedList<>();
    JSONParser parser = new JSONParser();
    JSONArray jsonArray = null;

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
      jsonArray = (JSONArray) parser.parse(bufferedReader);
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }

    if (jsonArray != null) {
      for (Object o : jsonArray) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JSONObject jsonObject = (JSONObject) o;
        Employee employee = gson.fromJson(String.valueOf(jsonObject), Employee.class);
        list.add(employee);
      }
    }
    return list;
  }
}
