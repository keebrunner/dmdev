package com.hw.hw3;

/**
 * Задание 3
 * <p>
 * Даны два прямоугольных треугольника.
 * * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 * <p>
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */

public class Task3 {

    public static void main(String[] args) {
//      first triangle:
        int a = 10;
        int b = 20;
//      second triangle:
        int c = 30;
        int d = 5;

        compareSquares(a, b, c, d);
    }

    public static double calculateSquare(int a, int b) {
        double s = 0.5 * a * b;
        return s;
    }

    public static void compareSquares(int a, int b, int c, int d) {
        double square1 = calculateSquare(a, b);
        double square2 = calculateSquare(c, d);
        if (square1 > square2) {
            System.out.println("The square of the first triangle is larger than the square of the second triangle.");
        } else if (square1 < square2) {
            System.out.println("The square of the first triangle is smaller than the square of the second triangle.");
        } else {
            System.out.println("The squares of these triangles are equal.");
        }
    }
}

