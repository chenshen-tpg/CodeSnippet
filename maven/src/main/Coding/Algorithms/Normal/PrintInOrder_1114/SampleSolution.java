package main.Coding.Algorithms.Normal.PrintInOrder_1114;

import java.util.concurrent.atomic.AtomicInteger;

public class SampleSolution {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public static void main(String[] args) {

    }
    public SampleSolution() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {}
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {}
        printThird.run();
    }
}
