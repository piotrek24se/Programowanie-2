package ex2Distance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //dokonczyc

        List<Point> listOfPoints = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean entry = true;
        double x;
        double y;

        while (entry == true) {
            System.out.println("Podaj wspolrzedna x");
            x = scanner.nextDouble();

            System.out.println("Podaj wspolrzedna y");
            y = scanner.nextDouble();

            listOfPoints.add(new Point(x, y));

            System.out.println("Czy chcesz dodac kolejna osobe?");
            String decision = scanner.nextLine();

            if (decision.equalsIgnoreCase("tak")) {
                entry = true;
            } else if (decision.equalsIgnoreCase("nie")) {
                entry = false;
            } else System.out.println("Wprowadz wartosc tak lub nie");

        }

    }

}
