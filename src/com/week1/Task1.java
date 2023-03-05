package com.week1;

/**
 * Задание 1
 * <p>
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * <p>
 * Протестировать функцию в main.
 */

public class Task1 {

    public static void main(String[] args) {
        int minutes = 10;
        printQuarter(minutes);

        int[] values = {2, 4, 6, 8};

        for (int value : values) {
            value *= 2;
            System.out.print(value + " ");
        }
    }

    public static void printQuarter(int value) {

        if (value < 0 || value > 59) {
            System.out.println("Error: irrelevant value.");
        } else if (0 >= value || value <= 14) {
            System.out.println(value + " minutes is the first quarter.");
        } else if (15 >= value || value <= 29) {
            System.out.println(value + " minutes is the second quarter.");
        } else if (30 >= value || value <= 44) {
            System.out.println(value + " minutes is the third quarter.");
        } else {
            System.out.println(value + " minutes is the fourth quarter.");
        }
    }

}
