package com.company;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue queue = new SynchronousQueue();
        NumberGenerator numberGenerator = new NumberGenerator(queue);

        int consumerThreadsCount = 10;
        for (int i = 0; i < consumerThreadsCount; i++) {
            EvenChecker evenChecker = new EvenChecker(queue);
            new Thread(evenChecker).start();
        }

        new Thread(numberGenerator).start();
    }
}
