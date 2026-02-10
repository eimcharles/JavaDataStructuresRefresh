package concurrency.simpleThread;

public class Counter {

    private int count = 0;

    public void increment() {
        count = count + 5;
    }

    public int getCount() {
        return count;
    }
}
