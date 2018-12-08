package easter;

import java.util.Scanner;

public class EasterMain {

    public static void main(String[] args) {

        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        int k;
        int l;
        int m;
        int p;
        int givenYear;
        int calculatedDay;
        int calculatedMonth;

        Scanner scanner = new Scanner(System.in);
        givenYear = scanner.nextInt();

        a = givenYear % 19;
        b = givenYear / 100;
        c = givenYear % 100;
        d = b / 4;
        e = b % 4;
        f = (b + 8) / 25;
        g = (b - f + 1) / 3;
        h = (19 * a + b - d - g + 15) % 30;
        i = c / 4;
        k = c % 4;
        l = (32 + 2 * e + 2 * i - h - k) % 7;
        m = (a + 11 * h + 22 * l) / 451;
        p = (h + l - 7 * m + 114) % 31;

        calculatedDay = p + 1;
        calculatedMonth = (h + l - 7 * m + 114) / 31;

        if (calculatedMonth == 4) {
            if (calculatedDay < 10) {
                System.out.println("0" + calculatedDay + " kwiecien " + givenYear);
            } else {
                System.out.println(calculatedDay + " kwiecien " + givenYear);
            }

        }
        if (calculatedMonth != 4) {
            if (calculatedDay < 10) {
                System.out.println("0" + calculatedDay + " marzec " + givenYear);
            } else {
                System.out.println(calculatedDay + " marzec " + givenYear);
            }

        }
    }
}
