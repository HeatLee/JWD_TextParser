package by.markevich.textparser.util;

import java.util.Stack;

public class CalculateViaReversePolishNotation {
    private static final char ZERO = '0';
    private static final char NINE = '9';

    public int calculateByPolishNotation(String text) {
        text = changeShift(text);

        Stack<Character> operation = new Stack<>();
        Stack<Integer> result = new Stack<>();
        int i = 0;
        char symbol;
        while (i < text.length()) {
            symbol = text.charAt(i);
            if (isDigit(symbol)) {
                StringBuilder digit = new StringBuilder();
                while (i < text.length() && isDigit(symbol = text.charAt(i))) {
                    digit.append(symbol);
                    i++;
                }
                result.push(Integer.valueOf(digit.toString()));
            } else {
                if (operation.isEmpty() || getPriority(symbol) < getPriority(operation.peek())) {
                    operation.push(symbol);
                } else {
                    if (symbol != ArithmeticOperators.CLOSE_BRACKET) {
                        while (!operation.isEmpty() && operation.peek() != ArithmeticOperators.OPEN_BRACKET &&
                                getPriority(symbol) > getPriority(operation.peek())) {
                            calculate(operation.pop(), result);
                        }
                        operation.push(symbol);
                    } else {
                        while (operation.peek() != ArithmeticOperators.OPEN_BRACKET) {
                            calculate(operation.pop(), result);
                        }
                        operation.pop();
                    }
                }
                i++;
            }
        }
        while (!operation.isEmpty()) {
            calculate(operation.pop(), result);
        }

        return result.pop();
    }

    private void calculate(char operation, Stack<Integer> result) {
        int firstNumber;
        int secondNumber;
        switch (operation) {
            case ArithmeticOperators.REVERSE:
                firstNumber = result.pop();
                result.push(~firstNumber);
                return;
            case ArithmeticOperators.AND:
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(firstNumber & secondNumber);
                return;
            case ArithmeticOperators.OR:
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(firstNumber | secondNumber);
                return;
            case ArithmeticOperators.BIGGER:
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(secondNumber >> firstNumber);
                return;
            case ArithmeticOperators.SMALLER:
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(secondNumber << firstNumber);
                return;
            case ArithmeticOperators.XOR:
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(firstNumber ^ secondNumber);
        }
    }

    private int getPriority(char symbol) {
        switch (symbol) {
            case ArithmeticOperators.OPEN_BRACKET:
                return 0;
            case ArithmeticOperators.REVERSE:
                return 1;
            case ArithmeticOperators.BIGGER:
            case ArithmeticOperators.SMALLER:
                return 2;
            case ArithmeticOperators.AND:
                return 3;
            case ArithmeticOperators.XOR:
                return 4;
            case ArithmeticOperators.OR:
                return 5;
            default:
                return 100;
        }
    }

    private boolean isDigit(char symbol) {
        return symbol >= ZERO && symbol <= NINE;
    }

    private String changeShift(String text) {
        text = text.replace(ArithmeticOperators.BIT_SHIFT_RIGHT, String.valueOf(ArithmeticOperators.BIGGER));
        return text.replace(ArithmeticOperators.BIT_SHIFT_LEFT, String.valueOf(ArithmeticOperators.SMALLER));
    }
}
