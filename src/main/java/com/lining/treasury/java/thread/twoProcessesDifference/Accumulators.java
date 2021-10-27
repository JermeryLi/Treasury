package com.lining.treasury.java.thread.twoProcessesDifference;

public class Accumulators {
    private double result = 0.0D;
    public void addAll(double[] values){
        double sum = 0.0D;
        for (double value : values) {
            sum += value;
        }
        result += sum;
    }
}
