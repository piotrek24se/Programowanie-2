package filesRead;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

//        listaPlikow();
//        informacjeOPliku();
//        odczytPliku();
//        zapisDoPliku();
//        filtrowanie();


    }

    private static void filtrowanie() throws IOException {
        //metadane - dane opisujace dane (atrybuty)
        Path path = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA");
        Files.walk(path, 3).filter(p->p.toString().endsWith(".txt")).forEach(System.out::println); // jezeli maxDepth = 0 to jest to to samo co metoda list
    }

    private static void zapisDoPliku() throws IOException {
        List<String> content = Arrays.asList("Linia 1", "Linia 2", "Ostatnia linia");
        Path path = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Pliki do zadań\\Plik tekstowy2.txt");
        // APPEND - dopisanie, bez APPEND - nadpisanie
        Files.write(path, content, StandardOpenOption.APPEND);
    }

    private static void odczytPliku() throws IOException {
        // plik tekstowy w formacie UTF-8
        Path path = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Pliki do zadań\\Plik tekstowy.txt");
        Files.lines(path).forEach(System.out::println);
    }

    private static void informacjeOPliku() throws IOException {
        Path path = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Materiały\\Zajecia 21 (Darek Zbyrad)\\Zadanie 1.pdf");
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println("creation time: " + attr.creationTime());
        System.out.println("last access time: " + attr.lastAccessTime());
        System.out.println("last modified time: " + attr.lastModifiedTime());
        System.out.println("size: " + attr.size());
    }

    private static void listaPlikow() throws IOException {
        Path path = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Materiały");

        //list zwraca streama
        Files.list(path).forEach(System.out::println);
    }

}
