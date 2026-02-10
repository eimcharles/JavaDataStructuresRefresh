package concurrency.simpleThread;

public class IncrementCounter implements Runnable {

    private final Counter counter;

    public IncrementCounter(Counter counter) {
        this.counter = counter;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {

            /**
             *      Monitor lock for race condition
             *      for non-atomic operation
             * */

            synchronized (counter){
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " updated count to: " + counter.getCount());
            }

            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {

                System.out.println("Thread was interrupted!");

            }
        }
    }
}
