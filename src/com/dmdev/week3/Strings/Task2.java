package com.dmdev.week3.Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Задание 2
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * <p>
 * Написать 2 метода:
 * <p>
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * <p>
 * Посчитать сумму всех чисел из строки
 * <p>
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2 {

    public static void main(String[] args) {
        String input = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";

        int[] numbers = convertLettersToNumbers(input);
        System.out.println("Array of numbers: " + Arrays.toString(numbers));

        int sum = sumNumbers(numbers);
        System.out.println("Sum of numbers: " + sum);
    }

    public static int[] convertLettersToNumbers(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isDigit(c)) {
                numbers.add(Character.getNumericValue(c));
            }
        }

        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    public static int sumNumbers(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

}
