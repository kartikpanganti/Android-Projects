package com.example.myapplication;
import java.util.Stack;

import java.util.Stack;

public class PrefixEvaluator {

    // Function to check if a character is an operand
    private static boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    // Function to evaluate a prefix expression
    public static int evaluatePrefix(String prefix) {
        Stack<Integer> stack = new Stack<>();

        // Reverse the prefix expression and process from right to left
        String reversedPrefix = new StringBuilder(prefix).reverse().toString();

        for (char c : reversedPrefix.toCharArray()) {
            if (isOperand(c))
                stack.push(Character.getNumericValue(c));
            else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '–':
                        stack.push(operand1 - operand2);
                        break;
                    case '×':
                        stack.push(operand1 * operand2);
                        break;
                    case '÷':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String prefixExpression = "+12 12";
        int result = evaluatePrefix(prefixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
        System.out.println("Result: " + result);
    }
}

