package com.example.calculator.logic;

import java.util.HashMap;

public class Model {

    private static final Model instance = new Model();

    public static Model getInstance(){
        return instance;
    }

    private Model(){

    }

    public double sum (double a, double b){
        return a + b;
    }

    public double sub (double a, double b){
        return a - b;
    }

    public double multiply (double a, double b){
        return a * b;
    }

    public double divide (double a, double b){
        return a / b;
    }

}
