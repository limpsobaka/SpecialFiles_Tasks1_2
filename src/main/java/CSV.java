import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSV {
  public static List<Employee> parseCSV(String[] columnMapping, String fileName) {
    List<Employee> list;
    try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
      ColumnPositionMappingStrategy<Employee> cpms = new ColumnPositionMappingStrategy<>();
      cpms.setType(Employee.class);
      cpms.setColumnMapping(columnMapping);
      CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
              .withMappingStrategy(cpms)
              .build();
      list = csv.parse();
      return list;
    } catch (IOException e) {
      System.out.println("При парсинге произошла ошибка: " + e.getMessage());
      return null;
    }
  }
}
