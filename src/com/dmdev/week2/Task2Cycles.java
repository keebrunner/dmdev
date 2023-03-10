package com.dmdev.week2;

/**
 * Задание 2
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * <p>
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2Cycles {

    public static void main(String[] args) {
        int number = -987654321;

        reverse(number);
    }

    public static void reverse(int value) {
        int currentReverceNumber = 0;
        int result = 0;
        for (int i = 0; i < (value > 0 ? value : value * -1); value /= 10) {
            currentReverceNumber = (result * 10) + (value % 10);
            result = currentReverceNumber;
        }
        System.out.println(result);
    }
}



