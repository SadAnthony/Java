package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements3Impl implements ControlFlowStatements3 {
    @Override
    public double getFunctionValue(double x) {
        if (x <= 0) {
            return -x;
        } else if (x < 2) {
            return x*x;
        } else {
            return 4;
        }
    }

    @Override
    public String decodeSeason(int monthNumber) {
        String monthString;
        switch (monthNumber) {
            case 12: monthString = "Winter";
                break;
            case 1: monthString = "Winter";
                break;
            case 2: monthString = "Winter";
                break;
            case 3: monthString = "Spring";
                break;
            case 4: monthString = "Spring";
                break;
            case 5: monthString = "Spring";
                break;
            case 6: monthString = "Summer";
                break;
            case 7: monthString = "Summer";
                break;
            case 8: monthString = "Summer";
                break;
            case 9: monthString = "Autumn";
                break;
            case 10: monthString = "Autumn";
                break;
            case 11: monthString = "Autumn";
                break;
            default: monthString = "Error";
                break;
        }
        return monthString;
    }

    @Override
    public long[][] initArray() {
        long[][] ary = new long[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                ary[i][j] = (long) Math.pow(Math.abs(i - j), 5);
            }
        }
        return ary;
    }

    @Override
    public int getMaxProductIndex(long[][] array) {
        int num = 0;
        long multiplicationOfElements;
        long max = 0;
        for (int i = 0; i < array.length; i++) {
            multiplicationOfElements = 1;
            for (long anAnArray : array[i]) {
                multiplicationOfElements *= anAnArray;
            }
            if (max < multiplicationOfElements) {
                max = multiplicationOfElements;
                num = i;
            }
        }
        return num;
    }

    @Override
    public float calculateLineSegment(float A, float B) {
        while (A > 0) {
            A -= B;
        }
        return B + A;
    }
}
