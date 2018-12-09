package filesRead;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pracownik {

    private String imie;
    private String nazwisko;
    private Long id;
    private char plec;
    private BigDecimal pensja;

    public Pracownik(String imie, String nazwisko, Long id, char plec, BigDecimal pensja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
        this.plec = plec;
        this.pensja = pensja;
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Pliki do zadań\\Obiekty pracownik.txt");
        String string = path.toString();

        List<Pracownik> listOfObjects = new ArrayList<>();

        List<String> listWithData = new ArrayList<>();

        Files.lines(path).forEach(p -> listWithData.add(p));

        //validator (dokonczyc i poprawic - podkresla na czerwono wyrazenie w lambdzie)

//        listWithData = validateAndFilter(listWithData);


        List<String[]> listOfArrays = listWithData.stream().map(
                p -> p.split(" ")).collect(Collectors.toList());

        listOfArrays.stream()
                .forEach(p -> listOfObjects.add(new Pracownik(
                        p[0],
                        p[1],
                        Long.valueOf(p[2]),
                        p[3].charAt(0),
                        new BigDecimal(p[4]))));


    }

    private static List<String> validateAndFilter(List<String> listWithData) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < listWithData.size(); i++) {
            String[] columns = listWithData.get(i).split(" ");

            if(columns.length != 5) {
                System.out.println("Niepoprawana ilosc kolumn w linii: " + i + 1);
                continue;
            }
            result.add(listWithData.get(i));

        }
        return result;
    }

}
