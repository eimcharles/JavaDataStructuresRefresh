package concurrency.simpleThread;

public class Counter {

    /**
     *        The 'volatile' keyword ensures "Visibility" across threads.
     *
     *          Without it, Thread A might update 'count' in its local CPU cache
     *          while Thread B is still looking at an old value in RAM (the Visibility Problem).
     *
     *          Volatile forces every read/write to happen directly in Main Memory,
     *          ensuring all threads see the most up-to-date state of the count
     *          variable instantly.*
     */

    private volatile int count = 0;

    public synchronized void increment() {
        count = count + 5;
    }

    public synchronized int getCount() {
        return count;
    }
}
