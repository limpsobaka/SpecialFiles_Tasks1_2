import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class XML {
  public static List<Employee> parseXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new File(fileName));

    Node root = doc.getDocumentElement();
    List<Employee> list = new LinkedList<>();
    readNode(root, list);
    return list;
  }

  private static List<Employee> readNode(Node node, List<Employee> list) {
    NodeList nodeList = node.getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node_ = nodeList.item(i);
      if (Node.ELEMENT_NODE == node_.getNodeType() && node_.getChildNodes().getLength() > 1) {
        Element element = (Element) node_;
        Employee empl = new Employee(Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent()),
                element.getElementsByTagName("firstName").item(0).getTextContent(),
                element.getElementsByTagName("lastName").item(0).getTextContent(),
                element.getElementsByTagName("country").item(0).getTextContent(),
                Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()));
        list.add(empl);
        readNode(node_, list);
      }
    }
    return list;
  }
}

