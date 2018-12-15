package dateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

import static javafx.scene.input.KeyCode.V;

public class DateAndTime {

    public static void main(String[] args) {

        /*
        obsluga samej daty
         */

        //tworzy date na podstawie liczb (rok, miesiac, dzien)
        LocalDate now = LocalDate.now(); //pobierze biezaca date
        System.out.println(now);

        LocalDate anotherDate = LocalDate.of(2015, 2, 1);

        //tworzy date na podstawie stringa YYYY-MM-DD
        LocalDate anotherDate2 = LocalDate.parse("2015-02-20"); //format musi byc scisle okreslony

        //dodaje jeden dzien do biezacej daty
        LocalDate tomorrow = now.plus(1L, ChronoUnit.DAYS);

        //zapis analogiczny do powyzszego
//        LocalDate tomorrow = now.plusDays(1);

        //odejmuje jeden dzien od biezacej daty
        LocalDate yesterday = now.minusDays(1);

        //pobiera dzien tygodnia dla biezacej daty
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int dayOfWeekAsNumber = dayOfWeek.getValue();

        //sprawdzanie, czy rok jest przestepny
        boolean isLeapYear = now.isLeapYear();

        //sprawdzanie, czy dana data jest po innej dacie
        boolean isTomorrowAfterNow = tomorrow.isAfter(now);

        /*
        obsluga samego czasu
         */

        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);

        LocalTime anotherTime = LocalTime.of(15, 20);
        LocalTime anotherTime2 = LocalTime.parse("15:20");

        LocalTime oneHourLater = timeNow.plus(1, ChronoUnit.HOURS);
//        LocalTime oneHourLater = timeNow.plusHours(1);

        int hour = timeNow.getHour();

        //pobieramy max godzine tj. 23:59:59.999
        LocalTime maxTime = LocalTime.MAX;

        /*
        obsluga pelnego czasu (data i czas)
         */

        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);

        LocalDateTime anotherDateTime
                = LocalDateTime.of(2017, 2, 3, 6, 0);

        LocalDateTime anotherDateTime2 = LocalDateTime.parse("2015-02-20T06:30:00");

        nowDateTime.plus(1, ChronoUnit.DAYS);
//        nowDateTime.plusDays(1);

        /*
        tworzenie czasu ze Stringa
         */

        String str = "12-03-1991 06:07";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        System.out.println(dateTime);

        /*
        tworzenie stringa z czasu
         */

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy MM dd HH:mm");

        String nowDateAndTimeAsString = nowDateTime.format(dtf);
        System.out.println(nowDateAndTimeAsString);

        //timestamp

        long myTimestamp = 1544862471L;
        LocalDateTime myLocalDateTime =
                LocalDateTime.ofInstant(Instant.ofEpochSecond(myTimestamp), TimeZone.getDefault().toZoneId());

        System.out.println(myLocalDateTime);

        //time zones

        TimeZone myTimeZone = TimeZone.getDefault();
        //wyswietlanie identyfikatora strefy
        System.out.println(myTimeZone.toZoneId());
        //przesuniecie w ms w stosunku do Greenwich
        System.out.println(myTimeZone.getRawOffset());

        ZoneId zoneId = ZoneId.of("Europe/Warsaw");
        System.out.println(zoneId.getRules().getOffset(Instant.EPOCH));

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(allZoneIds.size());

        //wyswietlanie listy stref czasowych z przesunieciami

        for (String id : allZoneIds) {
            System.out.println("Id: " + id + " Offset: " + ZoneId.of(id).getRules().getOffset(Instant.EPOCH));
        }

        //wyswietlanie listy stref czasowych z przesunieciami z sortowaniem po przesunięciu

        Map<String, ZoneOffset> zones = new TreeMap<>();

        for (String id : allZoneIds) {
            zones.put(id, ZoneId.of(id).getRules().getOffset(Instant.EPOCH));
        }

        //metoda ze streamem

        Stream<Entry<String, ZoneOffset>> sorted =
                zones.entrySet()
                        .stream()
                        .sorted(Entry.comparingByValue());

        sorted.forEach(System.out::println);

    }

    //druga metoda - niedokonczona

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

}
