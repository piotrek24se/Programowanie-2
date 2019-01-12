package stringUtils;

import org.apache.commons.lang3.StringUtils;

public class strUtils {

    public static void main(String[] args) {

        //metoda isBlank i isEmpty (roznia sie w jednym przypadku)

        System.out.println(StringUtils.isBlank(" ")); //return true -->
        StringUtils.isBlank(""); //return true
        StringUtils.isBlank(null); //return true
        StringUtils.isBlank("al"); //return false

        System.out.println(StringUtils.isEmpty(" ")); //return false -->
        StringUtils.isEmpty(""); //return true
        StringUtils.isEmpty(null); //return true
        StringUtils.isEmpty("al"); //return false

        //zliczanie zmakow

        System.out.println(StringUtils.countMatches("fdfsfsfs", "f"));

        //uzupelnianie stringa z prawej lub lewej wartosci do okreslonej dlugosci okreslonymi znakami

        System.out.println(StringUtils.rightPad("zzz", 8, 'x'));


    }


}
