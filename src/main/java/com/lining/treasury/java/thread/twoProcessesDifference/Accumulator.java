package com.lining.treasury.java.thread.twoProcessesDifference;

public class Accumulator {
    private double result = 0.0D;
    public void addAll(double[] values){
        for (double value : values) {
            result += value;
        }
    }
}
