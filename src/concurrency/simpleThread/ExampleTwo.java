package concurrency.simpleThread;

public class ExampleTwo {

    public static void main(String[] args) {

        ///  Shared resource: stored on the heap
        Counter counter = new Counter();

        /// Creating two separate runnable tasks
        IncrementCounter counterTask = new IncrementCounter(counter);

        ///  Thread object that operate on runnable tasks via memory address
        Thread threadOne = new Thread(counterTask);
        Thread threadTwo = new Thread(counterTask);

        /**
         *      Sequential execution: thread one is executed first
         *                            by the main thread and thread two
         *                            is QUEUED.
         *
         *      - No new stack is created, uses main methods call stack
         *
         *      run() blocks the calling thread (main method)
         *
         * */

        System.out.println("Starting thread one ");
        threadOne.run();

        System.out.println("Starting thread two");
        threadTwo.run();

        System.out.println("Main thread is finally finish");
    }

}
