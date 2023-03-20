package com.dmdev.week4.Encapsulation.Task1;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 1
 * Создать класс, описывающий банкомат.
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 10, 20 и 50.
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 * <p>
 * Сделать методы для добавления денег в банкомат.
 * <p>
 * Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение -
 * успешность выполнения операции.
 * <p>
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * Сначала банкомат будет пытаться рассчитаться 50, далее добавит недостающие 20,
 * и только затем 10 (не нужно рассматривать более сложные варианты выдачи наличных, чтобы не усложнять алгоритм).
 */

public class ATM {
    private int[] denominations;

    public ATM(int[] denominations) {
        this.denominations = denominations;
    }

    public void add50(int count) {
        denominations[0] += count;
    }

    public void add20(int count) {
        denominations[1] += count;
    }

    public void add10(int count) {
        denominations[2] += count;
    }

    private int getDenomination(int index) throws IllegalAccessException {
        switch (index) {
            case 0:
                return 50;
            case 1:
                return 20;
            case 2:
                return 10;
            default:
                throw new IllegalAccessException("Invalid index: " + index);
        }
    }

    public boolean withdrawMoney(int withdrawalAmount) throws IllegalAccessException {
        if (withdrawalAmount % 10 != 0) {
            System.out.println("Invalid amount. Amount must be a multiple of 10");
            return false;
        }

        List<Integer> withdrawnDenominations = new ArrayList<>();

        for (int i = 0; i < denominations.length; i++) {
            int denomination = getDenomination(i);
            int count = withdrawalAmount / denomination;
            withdrawnDenominations.add(count);
            withdrawalAmount -= count * denomination;
        }

        System.out.print("Withdrawal: ");
        for (int i = 0; i < withdrawnDenominations.size(); i++) {
            int denomination = getDenomination(i);
            int count = withdrawnDenominations.get(i);
            System.out.print(count + "x " + denomination + " banknotes");
            if ((i < withdrawnDenominations.size() - 1)) {
                System.out.print(" ");
            }
        }
        System.out.println(".");

        return true;
    }
}
