package encryption;

import org.apache.commons.lang3.StringUtils;

public class CezarMain {

    public static void main(String[] args) {

        CezarEncryptionDecryption cezarEncryptionDecryption = new CezarEncryptionDecryption();

        String string = "Alamakota";

        System.out.println(cezarEncryptionDecryption.encrypt(string));

    }

}
