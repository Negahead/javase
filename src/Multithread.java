/**
 * Created by AlphaGo on 12/30/2017.
 */
public class Multithread {
    public static void main(String[] args) throws InterruptedException {
        /**
         * A principal advantage of multithreading is that it enables you write vary efficient programs
         * because it lets you utilize the idle time that is present in most programs.A program will often
         * spend a majority of its execution time waiting to send or receive information to or from a device.
         * By using multithreading ,your program can execute another task during this idle time.
         *
         * each thread receiving a slice of CPU time, so in single-core system,two or more threads do not
         * actually run at the same time,but idle CPU time is utilized.However,in multiprocessor/multicore systems,
         * it is possible for two or more threads to actually execute simultaneously.
         *
         *
         * Daemon Thread:
         *      if JVM finds running daemon thread,it terminates the thread and after that shutdown itself,
         *      JVM does not care whether Daemon thread is running or not.
         *      A Daemon thread is a thread that dose not prevent the JVM from exiting when program finishes
         *      but the thread is still running.
         *      A Daemon thread's life depend on the mercy of user threads: when all the user threads dies,
         *      JVM terminates this automatically.
         *      Daemon thread is a low priority thread.
         *
         *
         *      Daemon thread in java can be useful to run some tasks in background,when we create a thread in java,
         *      by default it's user thread and if it is running JVM will not terminate the program,when a thread is
         *      marked as daemon thread,JVM doesn't wait to finish to terminate the program,as soon as all the user
         *      threads are finished,JVM terminates the program as well as the the associated daemon threads.
         *
         *      Daemon threads are low-priority threads whose only role is to provide services to user threads.
         *      so daemon threads are only needed while user threads are running,they won't prevent the JVM from exiting
         *      once all user threads have finished their execution.that is why infinite loops,which typically exist in
         *      daemon threads,will not cause problems,because any code ,including the finally blocks,won't be executed
         *      once all threads have finished their execution,for this reason,daemon threads are not recommended for
         *      I/O tasks,calling Thread.join() on a running daemon thread can block the shutdown of the application.
         *
         *
         * main() method and Main thread:
         *          when JVM starts,it creates a thread called "main",your program will run on this thread,unless you create
         *          your own thread.
         *          The first thing the "main" thread does is to look for your static void main(String[] args) method,
         *          and invoke it,That is the entry-point to your program.main method in java in run by main thread which
         *          is a non daemon thread and java program runs until main method finishes or any other user thread is running.
         *
         *      In java threads,there is no concept of parent child
         *
         *      main method is referred as entry point of Java application which is true in case of core java application
         *      but in case of container managed environment like Servlet,EJB this is not true as these Java programs
         *      have their own life-cycle methods like init(),service() or destroy()
         *
         *      when code running in some thread creates a new Thread object,the new thread has its priority initially set
         *      equal to the priority of the creating thread,and is a daemon thread if and only if the creating thread is a
         *      daemon.
         *
         *
         *      join(): let the current thread to wait for other threads to complete, like t1.join():
         *              meaning the current thread waits for the thread t1 to complete.join() is actually call the
         *              wait() method in it's implementation.
         *
         *
         *  A thread os allowed to access information about its own thread group, but not to access information about its
         *  thread group's parent thread group or any other thread groups.
         *
         *
         *  priority in more a hint than a contract to the JVM,threads are unpredictable in nature,thread priority
         *  isn't very meaning full when all threads are competing for CPU.A thread's priority determines,in part how much
         *  CPU time a thread receives relative to other active threads.in general,low-priority threads receive little,
         *  high priority receives a lot.
         *
         *  high-priority thread has greater potential access to the CPU.
         *
         *  Aside from a thread’s priority setting, the most important factor affecting thread execution
         *  is the way the operating system implements multitasking and scheduling
         *
         *
         *  Synchronization and Monitor:
         *      Key to synchronization in Java is the concept of the monitor,which controls access to an object,A monitor
         *      works by implementing the concept of lock.
         *
         *      All objects in Java have a monitor,This feature is built into the Java language.thus all objects can be
         *      synchronized.
         *
         *      In the Java virtual machine,every object and class is logically associated with an monitor,for objects,the
         *      associated monitor protects the object's instance variables,for classes,the monitor protects the class's
         *      class variable( also known as static member variables),if an object has no instance variable,or a class has no class variable,the associated monitor
         *      protects no data.
         *
         *      To implement the mutual exclusion capability of monitors,the Java virtual machine associates a lock(sometimes
         *      called a mutex) with each object and class,A lock is like a privilege that only one thread cn "own" ay any one
         *      time.Threads need not obtain a lock to access instance or class variables,however,if a thread does obtain a lock,
         *      no other thread can obtain a lock on the same data until the thread that owns the lock releases it.
         *
         *
         *      A single thread is allowed to lock the same object multiple times. For each object, the Java virtual machine maintains a count of the,
         *      number of times the object has been locked,An unlocked object has a count of zero,
         *      Each time the thread acquires a lock on the same object, the count is again incremented,
         *      Each time the thread releases the lock, the count is decremented. When the count reaches zero, the
         *      lock is released and made available to other threads.
         *
         *      A thread in the Java virtual machine request a lock when it arrives at the beginning of a monitor region,
         *      in Java,there are two kinds of monitor regions: synchronized statements and synchronized methods,each
         *      monitor regions obtain a lock on the referenced object.the thread is now allowed to execute the code
         *      until it obtains the lock.A monitor region is code that need to executed as one indivisible operation with respect
         *      to a particular monitor,in other words,one thread must be able to execute a monitor region from beginning to
         *      end without another thread concurrently execution a monitor region of the same monitor.
         *
         *      you never explicitly lock an object,As the Java virtual machine runs your program,
         *      it automatically locks an object or class every time it encounters a monitor region.
         *
         * Wait and notify monitor:
         *      in this kind of monitor,a thread that currently owns the monitor can suspend itself inside the monitor by executing
         *      a wait command,when a thread executes a wait,it release the monitor and enters a wait set,the thread will stay
         *      suspended in the wait set until some time after another threads executes a notify command INSIDE the monitor,
         *      when a threads executes a notify,it continues to own the monitor until it releases the monitor of its own accord.
         *      either by executing a wait or by completing the monitor region.after the notifying thread has released the monitor,
         *      the waiting thread will be resurrected and will reacquire the monitor.(after a thread does a notify
         *      ,it retains ownership of the monitor and continues executing the monitor region,At some later time, the
         *      notifying thread releases the monitor and a waiting thread is resurrected)
         *
         *      If the former owner did not execute a notify before it released the monitor,then only the threads in the entry set
         *      will compete to acquire the monitor,if the former thread did execute a notify,then the entry set threads
         *      will have to compete with one or more threads from the wait set. A thread can only execute a wait command if it currently owns the monitor
         *      and it can't leave the wait set without automatically becoming again the owner of the monitor.
         *
         *      The Java virtual machine offers two kinds of notify commands: "notify" and "notify all." A notify command selects one thread arbitrarily
         *      from the wait set and marks it for eventual resurrection. A notify all command marks all threads currently in the wait set for eventual
         *      resurrection.
         *
         *
         */


        Thread currentThread = Thread.currentThread();
        System.out.println("currentThread name is " + currentThread.getName());
        System.out.println("currentThread active count is" + Thread.activeCount());
        System.out.println("currentThread priority is " + currentThread.getPriority());
        System.out.println("main thread sleeping for 5 seconds");
        //Thread.sleep(5000);
        System.out.println("hello");


        Runnable r = () -> {
            System.out.println("user thread " + Thread.currentThread().getName() + " running");
            System.out.println("current thread priority is " + Thread.currentThread().getPriority());
            System.out.println("setting worker priority to 1");
            Thread.currentThread().setPriority(1);
            try {
                for (int count = 0; count < 10; count++) {
                    Thread.sleep(200);
                    System.out.println("in " + Thread.currentThread().getName() + " thread count is " + count);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }

            System.out.println("user thread " + Thread.currentThread().getName() + " terminating");
        };

        /**
         * the order in which you call your threads doesn't necessarily define their order of execution,Once you
         * call the start() method,the thread goes into Runnable state,the thread scheduler of your operating
         * system will have multiple threads in Runnable state.
         *
         * when you start a thread ,there's basically a race condition between the main thread and the newly created
         * thread,this means that nothing can be said about the relative order in which things happen between the
         * two threads,if you want to ensure specific ordering,use synchronization.
         */
        Thread myThread = new Thread(r);
        Thread mythread2 = new Thread(r);
        Thread myThread3 = new Thread(r);
        // after calling start(),execution returns to main()
        myThread.start();
        mythread2.start();
        myThread3.start();

        for (int i = 0; i < 10; i++) {
            myThread.join();
            System.out.println("in " + Thread.currentThread().getName() + " i is " + i);
        }

        System.out.println("main thread terminating");
    }
}