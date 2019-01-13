package weather;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherMain {

    public static void main(String[] args) throws IOException, URISyntaxException {

        URI uri = new URI("http://traffic.erzeszow.pl/scripts/weather.php");
        String response = IOUtils.toString(uri, StandardCharsets.UTF_8.name()).substring(1);

        System.out.println(response);

        WeatherStation[] weatherStations = readJsonToObject(response);

        // obliczanie srednich wartosci

        int avgTemp20cm;
        int avgTemp2m;
        int avgTemp0m;
        int avgTemp5cm;
        int avgWind_Dir;
        int avgWindSpeed;
        int avgPrecipitation;
        int counterOfEntriesIntoLoop = 0;

        // deklarowaie tablic z wartosciami poszczegolnych pol klasy WeatherStation

        int[] avgTemp20cmArray = new int[weatherStations.length];
        int[] avgTemp2mArray = new int[weatherStations.length];
        int[] avgTemp0mArray = new int[weatherStations.length];
        int[] avgTemp5cmArray = new int[weatherStations.length];
        int[] avgWind_DirArray = new int[weatherStations.length];
        int[] avgWindSpeedArray = new int[weatherStations.length];
        int[] avgPrecipitationArray = new int[weatherStations.length];

        // inicjalizowanie tablic z wartosciami poszczegolnych pol klasy WeatherStation

        for (int i = 0; i < weatherStations.length; i++) {

            // uwzglednianie tylko wynikow niestarszych niz 10 min

            LocalDateTime actualDateAndTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateAndTimeFromWebsite = LocalDateTime.parse(weatherStations[i].getMeasure_time(), formatter).minusHours(1);


            if (dateAndTimeFromWebsite.isAfter(actualDateAndTime.minusMinutes(10))) {
                counterOfEntriesIntoLoop++;
                avgTemp20cmArray[i] = Integer.valueOf(weatherStations[i].getTemp20cm());
                avgTemp2mArray[i] = Integer.valueOf(weatherStations[i].getTemp2m());
                avgTemp0mArray[i] = Integer.valueOf(weatherStations[i].getTemp0m());
                avgTemp5cmArray[i] = Integer.valueOf(weatherStations[i].getTemp5cm());
                avgWind_DirArray[i] = Integer.valueOf(weatherStations[i].getWind_dir());
                avgWindSpeedArray[i] = Integer.valueOf(weatherStations[i].getWind_speed());
                avgPrecipitationArray[i] = Integer.valueOf(weatherStations[i].getPrecipitation());
            }
        }

        if (counterOfEntriesIntoLoop == 0) {
            System.out.println("Dane starsze niz 10 min. Poczekaj na aktualizacje danych w bazie.");
            System.exit(0);
        }

        // obliczanie srednich wartosci parametrow

        System.out.println("Srednia wartosc temperatury na wysokosci 20 cm powyzej gruntu wynosi: " + avgValue(avgTemp20cmArray));
        System.out.println("Srednia wartosc temperatury na wysokosci 2 m powyzej gruntu wynosi: " + avgValue(avgTemp2mArray));
        System.out.println("Srednia wartosc temperatury na wysokosci gruntu wynosi: " + avgValue(avgTemp0mArray));
        System.out.println("Srednia wartosc temperatury na wysokosci 5 cm powyzej gruntu wynosi: " + avgValue(avgTemp5cmArray));
        System.out.println("Srednia wartosc kierunku wiatru wynosi: " + avgValue(avgWind_DirArray));
        System.out.println("Srednia wartosc predkosci wiatru wynosi: " + avgValue(avgWindSpeedArray));
        System.out.println("Srednia wartosc opadu wynosi: " + avgValue(avgPrecipitationArray));


    }


    private static WeatherStation[] readJsonToObject(String response) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        // mozna uzyc zamiast adnotacji @JsonIgnoreProperties(ignoreUnknown = true) w WeatherStation
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        WeatherStation[] weatherStations = objectMapper.readValue(response, WeatherStation[].class);

        return weatherStations;

    }

    public static int avgValue(int[] strings) {
        int sum = 0;
        int avgValue;
        for (int s : strings) {
            sum += s;
        }

        avgValue = sum / strings.length;

        return avgValue;
    }

}
