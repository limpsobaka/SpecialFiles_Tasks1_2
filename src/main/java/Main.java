import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
    //CSV-JSON
    String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
    String fileName = "data.csv";
    List<Employee> list = CSV.parseCSV(columnMapping, fileName);
    String json = JSON.listToJson(list);
    WriteToFile.writeString(json, "data.json");

    //XML-JSON
    String fileNameXML = "data.xml";
    List<Employee> list2 = XML.parseXML(fileNameXML);
    String json2 = JSON.listToJson(list2);
    WriteToFile.writeString(json2, "data2.json");
  }
}
