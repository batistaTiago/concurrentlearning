package com.company;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class EvenChecker implements Runnable {

    private BlockingQueue<Integer> queue;

    public EvenChecker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(new Random().nextInt(5000));
                try {
                    Integer element = this.queue.take();
                    if ((element % 2) == 0) {
                        System.out.println("Even: " + element);
                    } else if (PrimeChecker.isPrime(element)) {
                        System.out.println("Prime: " + element);
                    } else {
                        System.out.println("No particular property detected: " + element);
                    }
                } catch (Exception e) {
                    System.out.println("erro no take da queue");
                }
            } catch (Exception e) {
                System.out.println("Erro no sleep.");
            }
        }
    }
}
