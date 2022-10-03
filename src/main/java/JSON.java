import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JSON {
  public static String listToJson(List<Employee> list) {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    Type listType = new TypeToken<List<Employee>>() {
    }.getType();
    String json = gson.toJson(list, listType);
    return json;
  }
}
