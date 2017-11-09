package com.netcracker.edu.java.tasks;

import java.util.Arrays;

/**
 * Created by dimon on 18.08.17.
 */
public class ComplexNumberImpl implements ComplexNumber {
    private double re;
    private double im;

    public ComplexNumberImpl() {
        this.re = 0.0;
        this.im = 0.0;
    }

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumberImpl(String value) {
        if (value.endsWith("i")) {
            int pos2 = value.length()-1;
            int pos1 = pos2 - 1;
            while (pos1 > 0 && value.charAt(pos1) != '+' && value.charAt(pos1) != '-')  --pos1;
            this.im = Double.parseDouble(value.substring(pos1, pos2));
            this.re = pos1 > 0 ? Double.parseDouble(value.substring(0, pos1)) : 0.0;
        } else {
            this.im = 0.0;
            this.re = Double.parseDouble(value);
        }
    }

    @Override
    public double getIm() {
        return this.im;
    }

    @Override
    public double getRe() {
        return this.re;
    }

    @Override
    public boolean isReal() {
        return this.im == 0.0;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        if (value.endsWith("i")) {
            int pos2 = value.length()-1;
            int pos1 = pos2 - 1;
            while (pos1 > 0 && value.charAt(pos1) != '+' && value.charAt(pos1) != '-')  --pos1;
            this.im = Double.parseDouble(value.substring(pos1, pos2));
            this.re = pos1 > 0 ? Double.parseDouble(value.substring(0, pos1)) : 0.0;
        } else {
            this.im = 0.0;
            this.re = Double.parseDouble(value);
        }
    }

    @Override
    public ComplexNumber copy() {
        return new ComplexNumberImpl(this.getRe(), this.getIm());
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return this.copy();
    }

    @Override
    public String toString() {
        if (this.getIm() == 0.0)    return Double.toString(this.getRe());
        else {
            StringBuilder sb = new StringBuilder();
            if (this.getRe() != 0.0) {
                sb.append(this.getRe());
                if (this.getIm() > 0.0) sb.append('+');
            }
            sb.append(this.getIm()).append('i');
            return sb.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  return true;

        if (o instanceof ComplexNumber) {
            ComplexNumber other = (ComplexNumber) o;
            if (other.getRe() == this.getRe() && other.getIm() == this.getIm()) return true;
        }
        return false;
    }

    @Override
    public int compareTo(ComplexNumber other) {
        double v1 = this.getRe()*this.getRe() + this.getIm()*this.getIm();
        double v2 = other.getRe()*other.getRe() + other.getIm()*other.getIm();
        if (v1 < v2)        return -1;
        else if (v1 > v2)   return +1;
        else                return 0;
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        this.re = -this.re;
        this.im = -this.im;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.re += arg2.getRe();
        this.im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        ComplexNumber arg1 = new ComplexNumberImpl(this.re, this.im);
        this.re = arg1.getRe()*arg2.getRe() - arg1.getIm()*arg2.getIm();
        this.im = arg1.getIm()*arg2.getRe() + arg1.getRe()*arg2.getIm();
        return this;
    }
}
