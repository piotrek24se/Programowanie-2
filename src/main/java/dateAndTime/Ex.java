package dateAndTime;

import java.time.LocalDate;

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


    }

    //zadanie 1
    private static boolean isFriday13(LocalDate date) {
        return date.getDayOfWeek().getValue() == 5 && date.getDayOfMonth() == 13;
    }

    //zadanie2
    private static void listOfMonthsAndDays(int year) {
        for (int i = 1; i < 13; i++) {
            LocalDate date = LocalDate.of(year, i, 20);
            System.out.println("Month: " + i + " days: " + date.lengthOfMonth());
        }
    }

}
