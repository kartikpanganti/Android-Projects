package com.example.myapplication;

import java.util.Stack;
public class InfixToPrefixConverter {

    // Function to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '–' || c == '×' || c == '÷';
    }

    // Function to get precedence of an operator
    private static int precedence(char op) {
        if (op == '+' || op == '–')
            return 1;
        else if (op == '×' || op == '÷')
            return 2;
        return 0;
    }

    // Function to convert infix expression to prefix expression
    public static String infixToPrefix(String infix) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Reverse the infix expression
        StringBuilder reversedInfix = new StringBuilder(infix).reverse();

        for (char c : reversedInfix.toString().toCharArray()) {
            if (Character.isLetterOrDigit(c))
                prefix.insert(0, c);
            else if (c == ')')
                stack.push(c);
            else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')')
                    prefix.insert(0, stack.pop());
                stack.pop();  // Pop the '('
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek()))
                    prefix.insert(0, stack.pop());
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            prefix.insert(0, stack.pop());

        return prefix.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c-d)";
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
    }
}
