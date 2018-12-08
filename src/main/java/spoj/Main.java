package spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // zakomentowane na czas testów w IJ przed wklejeniem do spoj (wklejamy do spoj z zakomentowana trescia)

//        List<String> inputLines = new ArrayList();
//
//        while (scanner.hasNextLine()) {
//            inputLines.add(scanner.nextLine());
//        }

        // lista dodana na czas testow w IJ (nie wklejamy jej do spoj)

        List<String> inputLines = Arrays.asList("3", "3");

        String result = executeTask(inputLines);

        System.out.println(result.intern());

    }

    private static String executeTask(List<String> inputLines) {
        int number1 = Integer.valueOf(inputLines.get(0));
        int number2 = Integer.valueOf(inputLines.get(1));
        int sum = number1 + number2;
        return String.valueOf(sum);
    }
}


