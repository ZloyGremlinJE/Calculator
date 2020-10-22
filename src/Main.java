import Entities.Calculator;
import Exceptions.IllegalDataInputException;
import Exceptions.IllegalMathematicOperationException;
import utils.ConverterNumber;
import utils.RegExp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) throws IllegalDataInputException {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите математическое выражение: ");
        String str = in.nextLine();
        in.close();

        str =  str.trim();

        // Проверяем на арабские/римские цифры из диапазона и символы мат.операциЙ
        boolean matchesArabianNumbers = checkInput(RegExp.Operations_ArabianNumbers, str);
        boolean matchesRomeNumbers = checkInput(RegExp.Operations_RomeNumbers, str);

        if (!matchesArabianNumbers && !matchesRomeNumbers) {
            //Ввведенная строка не соотвествует допустимым шаблонам.
            throw new IllegalDataInputException("Введенное выражение не соответствуют допустимому шаблону!");
        }

        str = str.replaceAll("\\s*", "");
        String[] split = str.split(RegExp.Operations);

        int firstNumber = ConverterNumber.convertToArabian(split[0]);
        int secondNumber = ConverterNumber.convertToArabian(split[1]);
        String operation = getOperation(str);

        Calculator calc = new Calculator(firstNumber,secondNumber,operation);
        int res = 0;
        try {
            res = calc.getResultOfOperation();
        } catch (IllegalMathematicOperationException e) {
            e.printStackTrace();
        }

        String result = String.valueOf(res);

        if (matchesRomeNumbers) {
            result = ConverterNumber.convertToRome(res);
        }

        System.out.println(result);


    }

    private static String getOperation(String str) {
        return str.replaceAll(RegExp.AllExceptOperations, "");
    }

    private static  boolean checkInput(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}


