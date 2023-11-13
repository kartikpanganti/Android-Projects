package com.example.myapplication;

import java.util.Stack;


public class InfixToPostfix {
  String out,out2;
  public static int precedence(char operator) {
    if (operator == '+' || operator == '–') {
      return 1;
    } else if (operator == '×' || operator == '÷') {
      return 2;
    }
    return 0;
  }

  public static String infixToPostfix(String infix) {
    StringBuilder postfix = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (char c : infix.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        postfix.append(c);
      } else if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          postfix.append(stack.pop());
        }
        stack.pop(); // Pop the '('
      } else {
        while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
          postfix.append(stack.pop());
        }
        stack.push(c);
      }
    }

    while (!stack.isEmpty()) {
      postfix.append(stack.pop());
    }

    return postfix.toString();
  }



  public static int evaluatePostfix(String postfix) {
    Stack<Integer> stack = new Stack<>();

    for (char c : postfix.toCharArray()) {
      if (Character.isDigit(c)) {
        stack.push(c - '0');
      } else {
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        int result = 0;
        switch (c) {
          case '+':
            result = operand1 + operand2;
            break;
          case '–':
            result = operand1 - operand2;
            break;
          case '×':
            result = operand1 * operand2;
            break;
          case '÷':
            result = operand1 / operand2;
            break;
        }
        stack.push(result);
      }
    }

    return stack.pop();
  }

}
