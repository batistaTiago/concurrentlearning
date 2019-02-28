package com.company;


public class Main {

    public static void main(String[] args) {
        final int numberOfRuns = 5;
        for (int i = 0; i < numberOfRuns; i++) {
            DoubleComputingAgent doubleSorter = new DoubleComputingAgent();
            new Thread(doubleSorter).start();
            StringComputingAgent stringSorter = new StringComputingAgent();
            new Thread(stringSorter).start();
        }
    }
}
