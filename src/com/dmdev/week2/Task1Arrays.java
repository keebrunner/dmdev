package com.dmdev.week2;

/**
 * Задание 1
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только
 * положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * <p>
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции. main - только для
 * тестирования написанного функционала.
 */

public class Task1Arrays {

    public static void main(String[] args) {
        int[] array = {-32, -24, -16, -8, 0, 8, 16, 24, 32};
        int lenght = calculatePositiveArrayLength(array);
        int[] positiveArray = filterPositiveValues(array, lenght);
        multiplyArray(positiveArray);

    }

    public static int calculatePositiveArrayLength(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i > 0) {
                count++;
            }
        }
        return count;
            }

    public static int[] filterPositiveValues(int[] array, int lenght) {

        int[] positiveArray = new int[lenght];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                positiveArray[index] = array[i];
                index++;
            }
        }
        return positiveArray;
    }

    public static int[] multiplyArray(int[] positiveArray) {
        int[] multiplyArray = new int[positiveArray.length];
        for (int i = 0; i < positiveArray.length; i++) {
            positiveArray[i] *= positiveArray.length;
            System.out.print(positiveArray[i] + " ");
        }
        return multiplyArray;
    }
}
