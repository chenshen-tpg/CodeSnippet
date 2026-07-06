package main.Coding.Algorithms.Normal.PrintInOrder_1114;

import java.util.Stack;

public class SampleSolution2 {
    Stack<Integer> st;
    public SampleSolution2() {
        st = new Stack<>();
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        st.push(1);
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(st.size() != 1){
            wait();
        }
        printSecond.run();
        st.push(2);
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(st.size() != 2){
            wait();
        }
        printThird.run();
    }
}
