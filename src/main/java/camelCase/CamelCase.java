package camelCase;

public class CamelCase {

    public static void main(String[] args) {

        String string = "daSAdsasSFGdS1";

        char[] chars = string.toCharArray();

        for (int i = 0; i < string.length(); i++) {
            if (i % 2 == 0) {
                System.out.print(String.valueOf(chars[i]).toUpperCase());
            } else {
                System.out.print(String.valueOf(chars[i]).toLowerCase());
            }
        }

    }

}
