package training;

public class Ex6 {

    public static void main(String[] args) {

        String number = "627";

        int counter = 0;
        int sum;

        while (!isPalindrom(number)) {
            counter++;
            sum = Integer.valueOf(number) + Integer.valueOf(new StringBuilder(number).reverse().toString());
            number = String.valueOf(sum);
        }

        System.out.println("Obliczona liczba " + number + " jest palindromem. Liczba wykonanych dodawan: " + counter);


    }

    public static boolean isPalindrom(String input) {

        String reverse = new StringBuilder(input).reverse().toString();

        return input.equals(reverse);

    }

}
