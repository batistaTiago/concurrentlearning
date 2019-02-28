package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class StringComputingAgent implements Runnable {

    public StringComputingAgent() {
    }

    @Override
    public void run() {
        final long startTime = System.currentTimeMillis();

        int threadId = (int) Thread.currentThread().getId();

        System.out.println("Thread: " + threadId + ": Generating list of strings...");

        ArrayList<String> firstList = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            firstList.add("oi");
            firstList.add("como");
            firstList.add("vai");
            firstList.add("voce");
        }

        System.out.println("Thread: " + threadId + ": Sorting the list of strings...");

        Collections.sort(firstList);
        final long stopTime = System.currentTimeMillis();
        final long latency = stopTime - startTime;

        System.out.println("Thread: " + threadId + ": String computing has finished in: " + latency + "ms");
    }
}
