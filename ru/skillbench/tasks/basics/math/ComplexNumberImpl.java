package ru.skillbench.tasks.basics.math;

import ru.skillbench.tasks.basics.math.ComplexNumber;

import java.util.Arrays;
import java.util.Objects;

public class ComplexNumberImpl implements ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumberImpl() {
        this.real = this.imaginary = 0;
    }

    public ComplexNumberImpl(double re) {
        this.real = re;
        this.imaginary = 0;
    }

    public ComplexNumberImpl(double re, double im) {
        this.real = re;
        this.imaginary = im;
    }

    @Override
    public double getRe() {
        return this.real;
    }

    @Override
    public double getIm() {
        return this.imaginary;
    }

    @Override
    public boolean isReal() {
        return this.imaginary == 0.0;
    }

    @Override
    public void set(double re, double im) {
        this.real = re;
        this.imaginary = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        boolean minusReal = false;
        boolean minusImaginary = false;
        boolean point = false;
        char ch;
        double number = 0;
        int j = 0;
        this.imaginary = this.real = 0;
        for (int i = 0; i < value.length(); i++) {
            ch = value.charAt(i);
            if (!Character.isDigit(ch) && ch != 'i' && ch != '+' && ch != '-' && ch != '.') {
                throw new NumberFormatException();
            }
            if ((ch == '-' || ch == '+') && i == 0) {
                minusReal = (ch == '-');
            } else if (ch == '-' || ch == '+') {
                if (minusReal) {
                    this.real = -number;
                } else {
                    this.real = number;
                }
                point = false;
                number = 0;
                minusImaginary = (ch == '-');
            } else if (ch == 'i' && i == value.length() - 1) {
                if (this.real == 0) {
                    minusImaginary = minusReal;
                }
                if (minusImaginary) {
                    this.imaginary = -number;
                } else {
                    this.imaginary = number;
                }
                return;
            } else if (ch == 'i' &&  i != value.length() - 1) {
                throw new NumberFormatException();
            } else if (ch == '.') {
                point = true;
                j = 1;
            } else if (Character.isDigit(ch) && !point) {
                number = number * 10 + (ch - '0');
            } else if (Character.isDigit(ch)) {
                number = number + (ch - '0') * 1.0 / Math.pow(10, j);
                j++;
            } else {
                throw new NumberFormatException();
            }
        }
        if (this.real == 0 && number != 0){
            if (minusReal) {
                this.real = -number;
            } else {
                this.real = number;
            }
        }
    }

    @Override
    public ComplexNumber copy() {
        return new ComplexNumberImpl(this.real, this.imaginary);
    }

    @Override
    public ComplexNumber clone() {
        return new ComplexNumberImpl(this.real, this.imaginary);
    }

    @Override
    public String toString() {
        if (this.imaginary == 0) {
            return String.valueOf(this.real);
        } else if (this.real == 0) {
            return String.valueOf(this.imaginary) + "i";
        } else if (this.imaginary < 0) {
            return String.valueOf(this.real) + String.valueOf(this.imaginary) + "i";
        } else {
            return String.valueOf(this.real) + "+" +
                    String.valueOf(this.imaginary) + "i";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        ComplexNumberImpl that = (ComplexNumberImpl) o;
        final ComplexNumberImpl other = (ComplexNumberImpl) o;
        return Objects.equals(this.real, other.real) &&
                Objects.equals(this.imaginary, other.imaginary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }

    @Override
    public int compareTo(ComplexNumber other) {
        return Double.compare(real * real + imaginary * imaginary,
                other.getRe() * other.getRe() + other.getIm() * other.getIm());
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array, ComplexNumber::compareTo);
    }

    @Override
    public ComplexNumber negate() {
        this.real = -this.real;
        this.imaginary = -this.imaginary;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.real += arg2.getRe();
        this.imaginary += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double re = real * arg2.getRe() - imaginary * arg2.getIm();
        double im = imaginary * arg2.getRe() + real * arg2.getIm();
        this.real = re;
        this.imaginary = im;
        return this;
    }
}
