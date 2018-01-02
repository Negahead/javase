package thread;

import java.util.Date;

/**
 * Created by AlphaGo on 12/31/2017.
 */
public class ThreadTest1 {
    public static void main(String[] args) throws InterruptedException {
        Calculator calculator = new Calculator(10);
        /**
         * all the threads share the same attributes,this means that if you change an attribute in
         * a thread,all the threads will be affected by this change.
         * The java Concurrency API provides a clean mechanism called thread-local variables with
         * a very good performance:
         *      ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();
         *      the data will be accessible only by a specific thread.
         *
         * Writing correct concurrent programs is primarily about managing access to shared,mutable state.
         *
         *
         * Race condition:
         *      A race condition occurs when two or more threads can access shared data and they try to change
         *      it at the same time,the correctness of a computation depends on the relative time or interleaving
         *      of multiple threads by the run time.
         *      Because the thread scheduling algorithm can swap between threads at any
         *      time.you do not know the order in which the threads will attempt to access the shared data.
         *      Therefore the result of the change in data is dependent on the thread scheduling algorithm.
         *      For a multithreaded program's behavior to be predictable,access the shared variable must be properly
         *      coordinated so that the threads do not interfere with one another.
         *
         * Thread programming place a significant design and implementation burden on developers,since developing thread-sage
         * classes require more care and analysis than developing non-thread-safe classes.
         *
         * synchronized keyword,which provides exclusive locking,but the term "synchronization" also includes the use of
         * volatile variable,explicit locks, and atomic variables.
         *
         * Use synchronization whenever ACCESSING the state variable.
         *
         * Stateless Objects:
         *      it has no fields and reference no fields from other classes,they are always thread-safe.
         *
         * Using atomic references,we cannot update both atomic references simultaneously,even though each call is atomic.
         * you use synchronized block:
         *      A synchronized block has two parts:a reference to an object that will serve as the lock and a block of code to
         *      be guarded by that lock,A synchronized method is a shorthand for a synchronized block that spans an entire
         *      method body,and whose lock is the object on which the method is being invoked,static synchronized methods
         *      use the Class object for the lock.
         *          synchronized(lock) {
         *              Access or modify shared state guarded by lock.
         *          }
         *      every Java object can implicitly act as a lock for the purpose of synchronization:these built-in locks are
         *      called intrinsic locks or monitor locks,the lock automatically acquired by the executing thread before entering
         *      a synchronized block and automatically released when control exists the synchronized block.
         *
         *
         * Every shared,mutable variable should be guarded by exactly one lock.
         * For every invariant that involves more than one variable,all the variable involved in tht invariant must be
         * guarded by the same lock.
         *
         *
         * In the absence of synchronization,the compiler ,processor,and runtime can do some downright weired things to the
         * order in which operations appear to execute.Attempts to reason about the order in which memory actions "must"
         * happen in insufficiently synchronized multithreaded program will almost certainly be incorrect.
         *
         * Volatile Variables:
         *      when a field in declared volatile,the compiler and runtime are put on notice that this variable
         *      is shared and that operations on it should not be reordered with other memory operation.Volatile variables
         *      are not cached in registers or in caches where they are hidden from other processors.so a read of
         *      a volatile variable always return the most recent write by any thread.
         */
        for(int i = 0 ; i < 3 ; i++) {
            Thread thread = new Thread(calculator);
            thread.start();
            Thread.sleep(3000);
        }
        System.out.println("main thread terminating");
    }
}

class Calculator implements Runnable {
    private ThreadLocal<Date> threadLocal = ThreadLocal.withInitial(Date::new);
    private int number;
    int threadVariable = 100;
    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        threadVariable++;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s,thread variable is now: %s,and number is %d\n", Thread.currentThread().getName(),threadLocal.get(),threadVariable);
    }
}
