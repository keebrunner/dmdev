package com.dmdev.week1;

/**
 * Задание 2
 * <p>
 * Даны 3 переменные:
 * <p>
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * <p>
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * <p>
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */

public class Task2 {

    public static void main(String[] args) {
        double operand1 = 24.4;
        double operand2 = 10.1;
        char operation = '%';
        doOperation(operand1, operand2, operation);
    }

    public static void doOperation(double value1, double value2, char operator) {
//   - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
        double result = 0;
        if (operator == '+') {
            result = value1 + value2;
        } else if (operator == '-') {
            result = value1 - value2;
        } else if (operator == '*') {
            result = value1 * value2;
        } else if (operator == '/') {
            result = value1 / value2;
        } else if (operator == '%') {
            result = value1 % value2;
        } else {
            System.out.println("Error: irrelevant value.");
        }
        System.out.println(result);
    }
}
