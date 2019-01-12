package ex7Password;

public class Main {

    public static void main(String[] args) {

        PasswordValidator passwordValidator = new PasswordValidator();

        String password = "d229fwA!";

        System.out.println(passwordValidator.isPasswordValid(password));

    }

}
