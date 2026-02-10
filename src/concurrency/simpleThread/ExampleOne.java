package concurrency.simpleThread;

public class ExampleOne {

    public static void main(String[] args) {

        ///  Shared resource: stored on the heap
        Counter counter = new Counter();

        /// Creating two separate runnable tasks
        IncrementCounter counterTask = new IncrementCounter(counter);

        ///  Thread object that operate on runnable tasks via memory address
        Thread threadOne = new Thread(counterTask);
        Thread threadTwo = new Thread(counterTask);

        /**
         *
         *      Concurrency: thread one runs ALONG thread two
         *                   and the main thread (main method)
         *
         *      - Each thread gets its own stack for its execution
         *
         *      - Thread execution happens concurrently to other threads (does not wait)
         *
         * */

        threadOne.start();
        threadTwo.start();
    }
}
