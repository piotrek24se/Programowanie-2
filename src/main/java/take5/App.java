package take5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileInputStream;
import java.io.IOException;

//dokonczyc
public class App {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new XmlMapper();

        Response response = objectMapper.readValue(new FileInputStream("take5.xml"), Response.class);

        System.out.println(response);

    }

}
