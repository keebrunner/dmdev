package com.week2;

/*Задание 3
        Дан одномерный массив целых чисел.


        Если для какого-то из массивов Написать функцию, которая принимает этот массив и разбивает на 3 других:
        с только отрицательными числами, только положительными и только нули. не будет значений,
        то должен быть создан пустой массив.
        Возвращает функция эти три массива в виде одного двумерного.

        Пример:

        [-4, -18]

        [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]

        [1, 9, 3]*/

public class Task3Arrays {

    public static void main(String[] args) {
        int[] array = {-32, -24, -16, -8, 0, 8, 16, 24, 32};
        return2dimArray(array);
    }

    public static int[][] return2dimArray(int[] array) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count0++;
            } else if (array[i] == 0) {
                count1++;
            } else {
                count2++;
            }
        }

        int[] array0 = new int[count0];
        int[] array1 = new int[count1];
        int[] array2 = new int[count2];
        count0 = 0;
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                array0[count0] = array[i];
                count0++;
            } else if (array[i] == 0) {
                array1[count1] = array[i];
                count1++;
            } else {
                array2[count2] = array[i];
                count2++;
            }
        }

        int[][] result = {array0, array1, array2};

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        return result;
    }
}

