package filesRead;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex1 {

    public static void main(String[] args) throws IOException {

        //moje rozwiazanie (w pliku wynikowym zapisywane tylko pierwsze linie z plikow)

//        Znajdź wszystkie pliki w dowolnym katalogu na dysku (oraz jego
//        podkatalogach) z rozszerzeniem .txt, następnie odczytaj pierwszą linię
//        każdego z nich i zapisz do nowego pliku .txt w formacie:
//        NAZWA_PLIKU – PIERWSZA_LINIA_Z_PLIKU

        List<String> resultList = new ArrayList<>();

        Path path = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Pliki do zadań");
        Files.walk(path, 3).filter(p -> p.toString().endsWith(".txt")).forEach(p -> resultList.add(String.valueOf(p)));

        List<String> listOfFirstLines = resultList.stream().map(p -> {
            try {
                return Files.lines(Paths.get(p)).collect(Collectors.toList()).get(0);
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }).collect(Collectors.toList());

        Path path1 = Paths.get("C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Pliki do zadań\\result.txt");

        Files.write(path1, listOfFirstLines);

        //rozwiazanie z zajec

        String startDir = "C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Pliki do zadań"; //Katalog z plikami do przeszukania
        Path dirPath = Paths.get(startDir);
        int maxDepth = 50; //Maksymalna głębokość przeszukiwania katalogów

        String resultFileName = "C:\\Users\\Piotr\\Desktop\\JAVA\\Java SDA\\Pliki do zadań\\resultx.txt"; //Plik do zapisu 'pierwszych linii'
        Path resultFilePath = Paths.get(resultFileName);

        Map<String, String> lines = new HashMap<>(); //Mapa z nazwą pliku i jej pierwszą linią
        List<String> linesToWrite = new ArrayList<>();

        Files.walk(dirPath, maxDepth) //Pobierz wszystkie katalogi i pliki
                .filter(Files::isRegularFile) //Przefiltruj tylko te, które są plikami, a nie np. katalogami
                .filter(f -> f.toString().endsWith(".txt")) //Przefiltruj tylko te pliki, które się konczą na '.txt'
                .forEach(f -> { //Dla każdego znalezionego pliku tekstowego
                    try {
                        String fileName = f.toString(); //Pobierz nazwę pliku
                        String firstLine = Files.lines(f).findFirst().orElse(""); //Odczytaj pierwszą linię

                        lines.put(fileName, firstLine); //Dodaj do mapy nazwa pliku -> pierwsza linia
                    } catch (IOException e) { //Gdyby wyskoczył wyjątek...
                        e.printStackTrace();
                    }
                });

        //Dla każdej pary nazwa pliku -> pierwsza linia przekonwertuj ją do stringa 'nazwaPliku - pierwszaLinia' i dodaj do listy
        lines.forEach((fileName, firstLine) -> linesToWrite.add(String.format("%s - %s", fileName, firstLine)));

        //Zapisz wynikową listę do pliku
        Files.write(resultFilePath, linesToWrite);
    }


}
