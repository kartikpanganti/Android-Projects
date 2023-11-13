package com.example.myapplication;
import java.util.Stack;

public class InfixToPrefix {

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static String infixToPrefix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        for (int i = infix.length() - 1; i >= 0; i--) {
            char currentChar = infix.charAt(i);

            if (Character.isDigit(currentChar) || Character.isLetter(currentChar)) {
                result.append(currentChar);
            } else if (currentChar == ')') {
                operators.push(currentChar);
            } else if (currentChar == '(') {
                while (!operators.isEmpty() && operators.peek() != ')') {
                    result.append(operators.pop());
                }
                if (!operators.isEmpty() && operators.peek() == ')') {
                    operators.pop();
                }
            } else if (isOperator(currentChar)) {
                while (!operators.isEmpty() && precedence(operators.peek()) > precedence(currentChar)) {
                    result.append(operators.pop());
                }
                operators.push(currentChar);
            }
        }

        while (!operators.isEmpty()) {
            result.append(operators.pop());
        }

        return result.reverse().toString();
    }

    public static float evaluatePrefix(String prefix) {
        Stack<Float> operands = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char currentChar = prefix.charAt(i);

            if (Character.isDigit(currentChar)) {
                operands.push((float) Character.getNumericValue(currentChar));
            } else if (isOperator(currentChar)) {
                float operand1 = operands.pop();
                float operand2 = operands.pop();

                switch (currentChar) {
                    case '+':
                        operands.push(operand1 + operand2);
                        break;
                    case '-':
                        operands.push(operand1 - operand2);
                        break;
                    case '*':
                        operands.push(operand1 * operand2);
                        break;
                    case '/':
                        operands.push(operand1 / operand2);
                        break;
                }
            }
        }

        return operands.pop();
    }



    public static void main(String[] args) {
        String infixExpression = "12+45*12.6";
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Infix expression: " + infixExpression);
        System.out.println("Prefix expression: " + prefixExpression);

        float result = evaluatePrefix(prefixExpression);
        System.out.println("Result of evaluation: " + result);
    }
}
