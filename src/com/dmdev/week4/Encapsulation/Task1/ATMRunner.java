package com.dmdev.week4.Encapsulation.Task1;

public class ATMRunner {

    public static void main(String[] args) throws IllegalAccessException {
        int[] denominations = {10, 20, 50};
        ATM atm = new ATM(denominations);
        int withdrawalAmount = 230;

        atm.add50(10);
        atm.add20(20);
        atm.add10(30);

        boolean success = atm.withdrawMoney(withdrawalAmount);
        if (success) {
            System.out.println("Withdrawal successful.");
            } else {
            System.out.println("Withdrawal failed.");
        }
    }
}
