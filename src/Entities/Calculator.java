package Entities;

import Exceptions.IllegalMathematicOperationException;

public  class Calculator {
    private final int firstNumber;
    private final int secondNumber;
    private final String operation;

    public Calculator(int firstNumber, int secondNumber, String operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    public int getResultOfOperation() throws IllegalMathematicOperationException {

        switch (operation) {
            case "+":
                return firstNumber + secondNumber;

            case "-":
                return firstNumber - secondNumber;

            case "*":
                return firstNumber * secondNumber;

            case "/":
                return firstNumber / secondNumber;

            default:
                throw new IllegalMathematicOperationException("Недопустимая математическая операция!");
        }
    }
}
