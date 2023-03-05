package com.dmdev.week2;

/*Задание 2
Дан одномерный массив символов.
Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]

Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы,
        которые больше этого среднего арифметического.*/

public class Task2Arrays {

    public static void main(String[] args) {
        char[] charArray = {'e', 'x', 'w', 'm', '+', 'g', 'u', 'i', 'x'};
        int[] numArray = convertArray(charArray);
        int average = calculateAverage(convertArray(charArray));
        printArray(numArray, average);

    }

    public static void printArray(int array[], int average) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > average) {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static int calculateAverage(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        int average = sum / array.length;
        /*System.out.println(average);*/
        return average;
    }

    public static int[] convertArray(char[] charArray) {
        int[] numArray = new int[charArray.length];
        for (char c = 0; c < charArray.length; c++) {
            numArray[c] = charArray[c];
            /*System.out.print(numArray[c] + " ");*/
        }
        return numArray;
    }
}
