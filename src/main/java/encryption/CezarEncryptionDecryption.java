package encryption;

public class CezarEncryptionDecryption {

    public String encrypt(String string) {

        String alphabet = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ";
        String key =      "CĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻAĄB";

        String[] keyArray = key.split("");

        String[] stringArray = string.toUpperCase().split("");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stringArray.length; i++) {
            sb.append(keyArray[alphabet.indexOf(stringArray[i])]) ;
        }

        String encryptedString = sb.toString();

        return encryptedString;

    }

}
