package org.example;

import java.util.Stack;

public class Main {

    // Operatörlerin öncelik sırasını belirleyen fonksiyon
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '^') {
            return 3;
        }
        return -1;
    }

    // Karakterin operatör olup olmadığını kontrol eden fonksiyon
    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
    }

    // Infix ifadeyi prefix ifadeye çeviren fonksiyon
    static String infixToPrefix(String infix) {
        // Stack'ler
        Stack<Character> operators = new Stack<>();
        Stack<String> operands = new Stack<>();

        // İfadenin tersini alıyoruz
        StringBuilder expression = new StringBuilder(infix);
        expression.reverse();

        // Parantezlerin yönünü değiştiriyoruz
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                expression.setCharAt(i, ')');
            } else if (expression.charAt(i) == ')') {
                expression.setCharAt(i, '(');
            }
        }

        // Ters çevrilmiş ifadeyi işliyoruz
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (Character.isLetterOrDigit(current)) {
                operands.push(String.valueOf(current));
            } else if (current == '(') {
                operators.push(current);
            } else if (current == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    char operator = operators.pop();
                    String operand2 = operands.pop();
                    String operand1 = operands.pop();
                    operands.push(operator + operand1 + operand2);
                }
                operators.pop();
            } else if (isOperator(current)) {
                while (!operators.isEmpty() && precedence(current) <= precedence(operators.peek())) {
                    char operator = operators.pop();
                    String operand2 = operands.pop();
                    String operand1 = operands.pop();
                    operands.push(operator + operand1 + operand2);
                }
                operators.push(current);
            }
        }

        // Tüm kalan operatörleri işlemeyi tamamlıyoruz
        while (!operators.isEmpty()) {
            char operator = operators.pop();
            String operand2 = operands.pop();
            String operand1 = operands.pop();
            operands.push(operator + operand1 + operand2);
        }

        return operands.peek();
    }

    public static void main(String[] args) {
        String infix = "(A-B/C)*(A/K-L)";
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + infixToPrefix(infix));
    }
}