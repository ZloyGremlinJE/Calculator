package utils;

public class RegExp {
    public static final String ArabianNumbers_1_100 = "[1-9][0-9]?|100|0";
    public static final String Operations_ArabianNumbers = "^([1-9]|10)\\s*[+-/*]\\s*([1-9]|10)$";
    public static final String Operations_RomeNumbers = "^(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s*[+-/*]\\s*(I|II|III|IV|V|VI|VII|VIII|IX|X)$";
    public static final String Operations = "[+-/*]";
    public static final String AllExceptOperations = "[^+-/*]";
}
