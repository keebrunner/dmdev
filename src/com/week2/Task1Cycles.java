package com.week2;

/**
 * Задание 1
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр
 * (вторая функция - нечетных).
 * <p>
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */

public class Task1Cycles {

    public static void main(String[] args) {
        int value = 1111;
        countEven(value);
        countOdd(value);
        System.out.println("The value contains " + countEven(value) + " even and " + countOdd(value) + " odd numbers.");
    }

    public static int countEven(int value) {
        boolean checker = false;
        int counter = 0;
        for (int i = 0; i < (value > 0 ? value : value * -1); value /= 10) {
            checker = (value % 10) % 2 == 0;
            if (checker) {
                counter++;
            }
        }
        return counter;
    }

    public static int countOdd(int value) {
        boolean checker = false;
        int counter = 0;
        for (int i = 0; i < (value > 0 ? value : value * -1); value /= 10) {
            checker = (value % 10) % 2 == 0;
            if (checker == false) {
                counter++;
            }
        }
        return counter;
    }

}
