package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DoubleComputingAgent implements Runnable {

    public DoubleComputingAgent() {
    }

    @Override
    public void run() {
        int threadId = (int) Thread.currentThread().getId();

        final long startTime = System.currentTimeMillis();
        System.out.println("Thread: " + threadId + ": Generating list of doubles...");

        Random generator = new Random(0);

        ArrayList<Double> someBigList = new ArrayList<Double>();
        int listLength = 4000000;

        for (int i = 0; i < listLength; i++) {
            double nextNumber = generator.nextDouble();
            someBigList.add(nextNumber);
        }

        System.out.println("Thread: " + threadId + ": Sorting the list of doubles...");
        Collections.sort(someBigList);
        final long stopTime = System.currentTimeMillis();
        final long latency = stopTime - startTime;

        System.out.println("Thread: " + threadId + ": Double computing has finished in: " + latency + "ms");
    }
}