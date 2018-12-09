package filesRead;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {

    public static void main(String[] args) throws IOException {

        //moje rozwiazanie (w pliku wynikowym zapisywane tylko pierwsze linie z plikow)

//        Znajdź wszystkie pliki w dowolnym katalogu na dysku (oraz jego
//        podkatalogach) z rozszerzeniem txt, następnie odczytaj pierwszą linię
//        każdego z nich i zapisz do nowego pliku txt w formacie:
//        NAZWA_PLIKU – PIERWSZA_LINIA_Z_PLIKU

        List<String> resultList = new ArrayList<>();

        Path path = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Pliki do zadań");
        Files.walk(path, 3).filter(p -> p.toString().endsWith(".txt")).forEach(p -> resultList.add(String.valueOf(p)));

        List<String> listOfFirstLines = resultList.stream().map(p -> {
            try {
                return Files.lines(Paths.get(p)).collect(Collectors.toList()).get(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }).collect(Collectors.toList());

        Path path1 = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Pliki do zadań\\result.txt");

        Files.write(path1, listOfFirstLines);

        //rozwiazanie z zajec (uzupelnic)



    }

}
