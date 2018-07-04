package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements2Impl implements ControlFlowStatements2{
    @Override
    public int getFunctionValue(int x) {
        if (x > 2 || x < -2) {
            return 2 * x;
        } else {
            return -3 * x;
        }
    }

    @Override
    public String decodeMark(int mark) {
        String markString;
        switch (mark) {
            case 1: markString = "Fail";
                break;
            case 2: markString = "Poor";
                break;
            case 3: markString = "Satisfactory";
                break;
            case 4: markString = "Good";
                break;
            case 5: markString = "Excellent";
                break;
            default: markString = "Error";
                break;
        }
        return markString;
    }

    @Override
    public double[][] initArray() {
        double[][] ary = new double[5][8];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                ary[i][j] = Math.pow(i, 4) - Math.sqrt(j);
            }
        }
        return ary;
    }

    @Override
    public double getMaxValue(double[][] array) {
        double max = array[0][0];
        for (double[] anArray : array) {
            for (double anAnArray : anArray) {
                if (max < anAnArray) {
                    max = anAnArray;
                }
            }
        }
        return max;
    }

    @Override
    public Sportsman calculateSportsman(float P) {
        Sportsman dude = new Sportsman();
        float distancePerDay = 10;
        dude.addDay(distancePerDay);
        while (dude.getTotalDistance() < 200) {
            distancePerDay *= 1 + P/100.0;
            dude.addDay(distancePerDay);
        }
        return dude;
    }
}
