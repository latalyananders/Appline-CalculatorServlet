package com.example.calculator.logic;

public class Request {
    private double a;
    private double b;
    private String math;

    public Request(double a, double b, String math) {
        this.a = a;
        this.b = b;
        this.math = math;
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }
}
