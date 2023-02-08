package com.st1.hw.hw4;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer
 * с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 * <p>
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */


public class Task3 {

    public static void main(String[] args) {
        int salary = 600;
        int currentCosts = 300;
        int quartIncrease = 400;
        int brockerInvestPercent = 20;
        int brockerProfitPercent = 2;
        int billingMonths = 38;

        finCalc(salary, currentCosts, brockerInvestPercent, brockerProfitPercent, quartIncrease, billingMonths);
    }

    private static void finCalc(int salary, int currentCosts, int brockerInvestPercent, int brockerProfitPercent,
                                int quartIncrease, int months) {
        int monthsCounter = 1;
        int personalAccount = 0;
        int brockerMonthAmount = 0;
        int brockerAccount = 0;

        for (int i = 1; i <= months; i++) {

            if (salary <= 0 || currentCosts < 0 || brockerInvestPercent < 0 || brockerProfitPercent < 0
                    || quartIncrease < 0 || months < 0) {
                break;
            }

            if (monthsCounter % 3 == 0) {
                salary = salary + quartIncrease;
            }
            monthsCounter++;

            brockerMonthAmount = (salary / 100 * brockerInvestPercent);
            brockerAccount += brockerMonthAmount + (brockerAccount / 100 * brockerProfitPercent);

            personalAccount += ((salary - currentCosts) - brockerMonthAmount);
        }
        if (personalAccount == 0 || brockerAccount == 0) {
            System.out.println("The entered data is incorrect");
        } else {
            System.out.println("During the calculation period, the user's personal account will grow by $" + personalAccount);
            System.out.println("The user's brokerage account will grow by $" + brockerAccount);
        }
    }
}