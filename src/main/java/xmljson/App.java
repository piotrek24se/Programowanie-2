package xmljson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws IOException {

//        saveObjectToXml();

//        readXmlToObject();

//        saveObjectToJson();

//        readJsonToObject();


    }

    private static void readJsonToObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        People people = objectMapper.readValue(new FileInputStream("output.json"), People.class);

        System.out.println(people);
    }

    private static void saveObjectToJson() throws IOException {
        Person firstPerson = new Person("Ania", 28);
        Person secondPerson = new Person("Bartek", 29);

        People people = new People(Arrays.asList(firstPerson, secondPerson));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new FileOutputStream("output.json"), people);
    }

    private static void readXmlToObject() throws IOException {
        ObjectMapper objectMapper = new XmlMapper();

        People people = objectMapper.readValue(new FileInputStream("output.xml"), People.class);

        System.out.println(people);
    }

    private static void saveObjectToXml() throws IOException {
        Person firstPerson = new Person("Ania", 28);
        Person secondPerson = new Person("Bartek", 29);

        People people = new People(Arrays.asList(firstPerson, secondPerson));

        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(new FileOutputStream("output.xml"), people);
    }

}
