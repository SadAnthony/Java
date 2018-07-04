package ru.skillbench.tasks.basics.control;
import java.lang.Math;

public class ControlFlowStatements1Impl implements ControlFlowStatements1 {
    @Override
    public float getFunctionValue(float x) {
        if (x > 0) {
            return (float) (2.0 * Math.sin(x));
        } else {
            return (float) (6.0 - x);
        }
    }

    @Override
    public String decodeWeekday(int weekday) {
        String dayOfTheDead;
        switch (weekday) {
            case 1: dayOfTheDead = "Monday";
                break;
            case 2: dayOfTheDead = "Tuesday";
                break;
            case 3: dayOfTheDead = "Wednesday";
                break;
            case 4: dayOfTheDead = "Thursday";
                break;
            case 5: dayOfTheDead = "Friday";
                break;
            case 6: dayOfTheDead = "Saturday";
                break;
            default: dayOfTheDead = "Sunday";
                break;
        }
        return dayOfTheDead;
    }

    @Override
    public int[][] initArray() {
        int[][] ary = new int[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                ary[i][j] = i*j;
            }
        }
        return ary;
    }

    @Override
    public int getMinValue(int[][] array) {
        int min = array[0][0];
        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                if (min > anAnArray) {
                    min = anAnArray;
                }
            }
        }
        return min;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        BankDeposit contribution = new BankDeposit();
        contribution.amount = 1000;
        while (contribution.amount < 5000) {
            contribution.amount *= 1.0 + P/100.0;
            contribution.years++;
        }
        return contribution;
    }
}
