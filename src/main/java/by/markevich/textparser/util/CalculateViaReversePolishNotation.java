package by.markevich.textparser.util;

import java.util.Stack;

public class CalculateViaReversePolishNotation {
    public int calculateByPolishNotation(String text) {
        text = changeShift(text);

        Stack<Character> operation = new Stack<Character>();
        Stack<Integer> result = new Stack<Integer>();
        int i = 0;
        char symbol;
        while (i < text.length()) {
            symbol = text.charAt(i);
            if (isDigit(symbol)) {
                StringBuilder digit = new StringBuilder("");
                while (i < text.length() && isDigit(symbol = text.charAt(i))) {
                    digit.append(symbol);
                    i++;
                }
                result.push(Integer.valueOf(digit.toString()));
            } else {
                if (operation.isEmpty() || getPriority(symbol) < getPriority(operation.peek())) {
                    operation.push(symbol);
                } else {
                    if (symbol != ')') {
                        while (!operation.isEmpty() && operation.peek() != '(' &&
                                getPriority(symbol) > getPriority(operation.peek())) {
                            calculate(operation.pop(), result);
                        }
                        operation.push(symbol);
                    } else {
                        while (operation.peek() != '(') {
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
            case '~':
                firstNumber = result.pop();
                result.push(~firstNumber);
                return;
            case '&':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(firstNumber & secondNumber);
                return;
            case '|':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(firstNumber | secondNumber);
                return;
            case '>':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(secondNumber >> firstNumber);
                return;
            case '<':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(secondNumber << firstNumber);
                return;
            case '^':
                firstNumber = result.pop();
                secondNumber = result.pop();
                result.push(firstNumber ^ secondNumber);
                return;
        }
    }

    private int getPriority(char symbol) {
        switch (symbol) {
            case '(':
                return 0;
            case '~':
                return 1;
            case '>':
            case '<':
                return 2;
            case '&':
                return 3;
            case '^':
                return 4;
            case '|':
                return 5;
            default:
                return 100;
        }
    }

    private boolean isDigit(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }

    private String changeShift(String text) {
        text = text.replace(">>", ">");
        return text.replace("<<", "<");
    }
}
