package dateAndTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Ex {

//    1. Napisz metodę, która dla podanej daty sprawdzi czy jest to piątek
//    trzynastego.
//    2. Napisz metodę, która dla podanego roku wyświetli listę miesięcy
//    wraz z ich długością (ilością dni).
//    3. Napisz metodę, która dla zadanego miesiąca z bieżącego roku
//    wyświetli wszystkie poniedziałki. (dokonczyc)

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2018, 4, 13);

        //zadanie1
        System.out.println(isFriday13(date));
        System.out.println("--------------------------");

        //zadanie2
        listOfMonthsAndDays(2018);

        //zadanie 3
        listOfMondaysInMonth(12, 2018);


    }

    //zadanie 1
    private static boolean isFriday13(LocalDate date) {
        return date.getDayOfWeek().getValue() == 5 && date.getDayOfMonth() == 13;
    }

    //zadanie 2
    private static void listOfMonthsAndDays(int year) {
        for (int i = 1; i < 13; i++) {
            LocalDate date = LocalDate.of(year, i, 20);
            System.out.println("Month: " + i + " days: " + date.lengthOfMonth());
        }
    }

    //zadanie 3

    private static void listOfMondaysInMonth(int monthNumber, int year) {

        LocalDate localDate = LocalDate.of(year, monthNumber, 1);
        int lengthOfMonth = localDate.lengthOfMonth();

        for (int i = 1; i < lengthOfMonth + 1; i++) {

            LocalDate localDate2 = LocalDate.of(year, monthNumber, i);
            if (localDate2.getDayOfWeek().getValue() == 1) {
                System.out.println("Monday: " + localDate2.getDayOfMonth() + " " + localDate2.getMonth() + " " + localDate2.getYear());
            }
        }
    }

    // rozwiazania z zajec

    //Write an example that, for a given year, reports the length of each month within that year.
    private static void exercise1() {
        int year = 2018;

        for (int month = 1; month <= 12; month++) {
            int lengthOfMonth = LocalDate.of(year, month, 1).lengthOfMonth();

            System.out.printf("Month: %s; Length of month: %s\n", month, lengthOfMonth);
        }
    }

    //Write an example that, for a given month of the current year, lists all of the Mondays in that month.
    private static void exercise2() {
        int month = 12;
        LocalDate date = LocalDate.now().withMonth(month).
                with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        int currentMonth = month;
        while (currentMonth == month) {
            System.out.printf("%s%n", date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            currentMonth = date.getMonthValue();
        }
    }

    //Write an example that tests whether a given date occurs on Friday the 13th.
    private static void exercise3() {
        int year = 2018;
        int month = 3;
        int day = 13;

        System.out.println(LocalDate.of(year, month, day).getDayOfWeek() == DayOfWeek.FRIDAY && day == 13);
    }
}
