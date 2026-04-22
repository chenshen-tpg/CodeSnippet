package main.SomeParticalExamples;

import java.util.concurrent.locks.ReentrantLock;


public class ThreadPining {
    /***
     Senior devs must know that ReentrantLock allows the Virtual Thread to yield its carrier thread during I/O,
     while synchronized (currently) does not.
     */
    private final ReentrantLock reLock = new ReentrantLock();
    public class externalApi {
        public String call() {
            return "mocked data";
        }
    }
    // BAD: Pinning the carrier thread
    public class Implementation {
        private final Object lock = new Object();

        public void fetchDataLegacy() {
            synchronized(lock) {
                String data = new externalApi().call();
                process(data);
            }
        }

        // GOOD: Replacing synchronized with ReentrantLock
        public void fetchData() {
            reLock.lock();
            try {

                String data = new externalApi().call(); // VT will "unmount" safely here
                process(data);
            } finally {
                reLock.unlock();
            }
        }
        private void process(String data) {
            // process the data
        }
    }
}
