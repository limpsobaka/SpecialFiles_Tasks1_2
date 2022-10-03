import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
  public static void writeString(String text, String fileName) {
    try (FileWriter writer = new FileWriter(fileName, false)) {
      writer.write(text);
    } catch (IOException e) {
      System.out.println("При записи файла произошла ошибка " + e.getMessage());
    }
  }
}
