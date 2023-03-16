package com.dmdev.week3.Strings;

/**
 * Задание 1
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 *
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

public class Task1 {

    public static void main(String[] args) {
        String input = "abc Cpddd Dio OsfWw";
        String result = removeRepeatedAndSpace(input);
        System.out.println(result);
    }

    public static String removeRepeatedAndSpace(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        char previousChar = Character.MIN_VALUE; // initialize previousChar to lowest possible value ('\u0000')

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (Character.toUpperCase(c) != Character.toUpperCase(previousChar)) {
                stringBuilder.append(Character.toUpperCase(c));
            }
            previousChar = c;
        }

        return stringBuilder.toString();
    }
}