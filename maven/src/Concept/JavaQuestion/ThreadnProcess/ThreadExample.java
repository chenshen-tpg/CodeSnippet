package PlatformQA.ThreadnProcess;

public class ThreadExample {

    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Thread: " + Thread.currentThread().getName());
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        // Both threads run in the same process, sharing memory.
    }

}
