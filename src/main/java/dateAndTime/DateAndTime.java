package dateAndTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
                = LocalDateTime.of(2017, 2, 3, 6,0);

        LocalDateTime anotherDateTime2 = LocalDateTime.parse("2015-02-20T06:30:00");

        nowDateTime.plus(1,ChronoUnit.DAYS);
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











    }

}
