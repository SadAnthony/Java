package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector{
    private double [] coordinates;

    @Override
    public void set(double... elements) {
        coordinates = new double[elements.length];
        System.arraycopy(elements, 0, coordinates, 0, elements.length);
    }

    @Override
    public double[] get() {
        return coordinates;
    }

    @Override
    public ArrayVector clone() {
        ArrayVectorImpl arr = new ArrayVectorImpl();
        arr.set(Arrays.copyOf(this.coordinates, this.getSize()));
        return arr;
    }

    @Override
    public int getSize() {
        return this.coordinates.length;
    }

    @Override
    public void set(int index, double value) {
        if (index < 0) {
            return;
        } else if (index < this.getSize()) {
            this.coordinates[index] = value;
        } else {
            double[] arr;
            arr = Arrays.copyOf(this.coordinates, index + 1);
            this.coordinates = arr;
            coordinates[index] = value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return this.coordinates[index];
    }

    @Override
    public double getMax() {
        double max = this.coordinates[0];
        for (double element : coordinates) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = this.coordinates[0];
        for (double element : coordinates) {
            if (min > element) {
                min = element;
            }
        }
        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(this.coordinates);
    }

    @Override
    public void mult(double factor) {
        for (int i = 1; i < this.getSize(); i++) {
            this.coordinates[i] *= factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        for (int i = 0; i < anotherVector.getSize() && i < this.getSize(); i++) {
            this.coordinates[i] += anotherVector.get(i);
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double scalar = 0;
        for (int i = 0; i < anotherVector.getSize() && i < this.getSize(); i++) {
            scalar += this.coordinates[i] * anotherVector.get(i);
        }
        return scalar;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(this.scalarMult(this));
    }

    public void inString() {
        for (double element : this.coordinates) {
            System.out.println(element);
        }
    }
}
