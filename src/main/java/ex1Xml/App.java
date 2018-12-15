package ex1Xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        List<Person> listOfPerson = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean addNewPerson = true;

        while (addNewPerson != false) {

            //dokonczyc podpunkty z gwiazdkami
            String name;
            String surname;
            String pesel;

            System.out.println("Podaj imie");
            name = scanner.nextLine();

            System.out.println("Podaj nazwisko");
            surname = scanner.nextLine();

            System.out.println("Podaj nr PESEL");
            pesel = scanner.nextLine();

            while (!isPeselValid(pesel)) {
                pesel = scanner.nextLine();
            }

            listOfPerson.add(new Person(name, surname, pesel));

            System.out.println("Czy chcesz dodac kolejna osobe?");
            String decision = scanner.nextLine();

            People people = new People(listOfPerson);

            ObjectMapper objectMapper = new XmlMapper();
            objectMapper.writeValue(new FileOutputStream("output3.xml"), people);

            if (decision.equalsIgnoreCase("tak")) {
                addNewPerson = true;
            } else if (decision.equalsIgnoreCase("nie")) {
                addNewPerson = false;
            } else System.out.println("Wprowadz wartosc tak lub nie");


        }

    }

    private static boolean isPeselValid(String pesel) {

        if (pesel.length() == 11) {
            String[] str = pesel.split("");
            int[] ints = new int[pesel.length()];

            for (int i = 0; i < ints.length; i++) {
                ints[i] = Integer.valueOf(str[i]);
            }

            int sum = 9 * ints[0] + 7 * ints[1] + 3 * ints[2] + 1 * ints[3] + 9 * ints[4] + 7 * ints[5] + 3 * ints[6] + 1 * ints[7] + 9 * ints[8] + 7 * ints[9];

            int mod = sum % 10;

            if (ints[ints.length - 1] == mod) {
                return true;
            } else {
                System.out.println("Nr PESEL nieprawidlowy");
            }
        } else {
            System.out.println("Nieprawidlowa liczba znakow. Wprowadz nr PESEL o dlugosci 11 znakow");
        }
        return false;
    }

}
