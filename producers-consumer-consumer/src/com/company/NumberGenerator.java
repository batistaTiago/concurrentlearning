package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class NumberGenerator implements Runnable {

    Random generator;
    BlockingQueue<Integer> queue;

    public NumberGenerator(BlockingQueue<Integer> queue) {
        this.generator = new Random();
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            this.addToQueue(this.generateRandomInteger(30));
        }
    }

    private Integer generateRandomInteger(int bound) {
        int length = 16;
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Integer newEntry = this.generator.nextInt(bound);
            randomList.add(newEntry);
        }
        int index = this.generator.nextInt(length);
        return randomList.get(index);
    }

    private void addToQueue(Integer n) {
        try {
            this.queue.put(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
