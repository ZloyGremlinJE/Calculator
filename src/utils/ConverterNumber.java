package utils;

import java.util.Arrays;


public class ConverterNumber {
     private static final String RomeZero = "nulla";

    public static int convertToArabian(String Number) {
        if (Number.matches(RegExp.ArabianNumbers_1_100)) {
            return Integer.parseInt(Number);
        }
        return (Number.replace("XC", "LXL")
                .replace("C", "LL")
                .replace("XL", "XXXX")
                .replace("L", "XXXXX")
                .replace("IX", "VIV")
                .replace("X", "VV")
                .replace("IV", "IIII")
                .replace("V", "IIIII")).length();
    }


    public static String convertToRome(int Number) {

        char[] chars = new char[Math.abs(Number)];
        Arrays.fill(chars, 'I');
        String stringOfOnes = new String(chars);

        if (Number == 0) {
            return RomeZero;
        }


        String RomeNumber = stringOfOnes.replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC");

        if (Number < 0) {
            RomeNumber = "-" + RomeNumber;
        }


        return RomeNumber;
    }

}
