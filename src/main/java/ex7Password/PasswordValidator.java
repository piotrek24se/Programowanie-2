package ex7Password;

public class PasswordValidator {

    //metoda spinajaca ponizsze metody

    public boolean isPasswordValid (String password) {
        return hasPassword8Signs(password)
            && consistOnlyOfLettersDigitsAndSpecialSigns(password)
            && containsAtLeast2Digits(password)
            && containsAtLeast1CapitalLetter(password)
            && containsAtLeast1SpecialSign(password);
    }

    //metody czastkowe

    private boolean hasPassword8Signs(String password) {
        return password.length() == 8;
    }

    private boolean consistOnlyOfLettersDigitsAndSpecialSigns(String password) {
        char[] chars = password.toCharArray();
        boolean temp = true;

        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] <= 57 && chars[i] >= 48)
                    || (chars[i] <= 90 && chars[i] >= 65)
                    || (chars[i] <= 122 && chars[i] >= 97)
                    || chars[i] == 33
                    || chars[i] == 64
                    || (chars[i] <= 37 && chars[i] >= 35)) {
                temp = true;
            } else {
                temp = false;
            }
        }
        return temp;
    }

    private boolean containsAtLeast2Digits(String password) {
        int counter = 0;

        char[] chars = password.toCharArray();
        boolean temp = true;

        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] <= 57 && chars[i] >= 48)) {
                counter++;
            }

            if (counter >= 2) {
                temp = true;
            } else {
                temp = false;
            }
        }
        return temp;
    }

    private boolean containsAtLeast1CapitalLetter(String password) {
        int counter = 0;

        char[] chars = password.toCharArray();
        boolean temp = true;

        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] <= 90 && chars[i] >= 65)) {
                counter++;
            }

            if (counter >= 1) {
                temp = true;
            } else {
                temp = false;
            }
        }
        return temp;
    }

    private boolean containsAtLeast1SpecialSign(String password) {
        int counter = 0;

        char[] chars = password.toCharArray();
        boolean temp = true;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 33 || chars[i] == 64 || (chars[i] <= 37 && chars[i] >= 35)) {
                counter++;
            }

            if (counter >= 1) {
                temp = true;
            } else {
                temp = false;
            }
        }
        return temp;
    }


}
