package ru.skillbench.tasks.basics.math;

import ru.skillbench.tasks.basics.math.ComplexNumber;

import java.util.Arrays;

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
        if (value.equals("")) {
            throw new NumberFormatException();
        }
        this.real = this.imaginary = 0;
        //the method works good with real numbers
        if (value.charAt(value.length() - 1) != 'i') {  //if the last character isn't "i"
            imaginary = 0.0;
            if (value.charAt(0) == '-') {
                real = -Integer.valueOf(value.substring(1, value.length() - 2));
            } else if (value.charAt(0) == '+') {
                real = Integer.valueOf(value.substring(1, value.length() - 2));
            } else {
                real = Integer.valueOf(value.substring(0, value.length() - 2));
            }
            return;
        }
        boolean minusFlag = false;  //flag for minus in real part
        boolean pointFlag = false;  //flag for point in real part
        double number = 0;          //real or imaginary part
        int i = 0;                  //counter
        int j = 0;          //the power of 10
        char ch;             //for value.charAt(i)
        while (i < value.length()) {     //through whole string
            ch = value.charAt(i);
            if (Character.isDigit(ch) && !pointFlag) { //if we found a digit in the int part of number
                number = number * 10 + (ch - '0');
                //number += Math.pow(10, j) * (int) ch;
            } else if (Character.isDigit(ch) && pointFlag) { //if we found a digit in the fractional part
                number = number + (ch - '0') * 1.0 / Math.pow(10, j);
                //number += Math.pow(-10, j) * (int) ch;
                j++;
            } else if (ch == '.') {    //if we found a point
                pointFlag = true;
                j = 1;
            } else if (ch == 'i') {     //if we found a "i" character
                if (minusFlag) {
                    imaginary = -number;     //imaginary part is completed
                    return;                 //job is done
                } else {
                    imaginary = number;
                    return;
                }
            } else if (ch == '+') {     //if we found second sign
                if (minusFlag) {        //check is the number less or greater than 0
                    real = -number;
                } else {
                    real = number;
                }
                number = 0;
                minusFlag = false;
                pointFlag = false;
            } else if (ch == '-') {
                if (minusFlag) {        //same
                    real = -number;
                } else {
                    real = number;
                }
                number = 0;
                minusFlag = true;
                pointFlag = false;
            } else {
                throw new NumberFormatException();
            }
            i++;
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
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        ComplexNumberImpl that = (ComplexNumberImpl) obj;
        return (this.real == that.real) && (this.imaginary == that.imaginary);
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
