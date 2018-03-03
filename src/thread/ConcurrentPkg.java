package thread;

/**
 *  Java concurrent memory model.
 *
 *  Synchronization isn't just about mutual exclusive and blocking,it also regulates when other threads must
 *  see writes by other threads when writes become visible,without synchronization,compiler and processor
 *  are allowed to reorder memory access in ways that may surprise you and break your code.
 *
 *
 *  x=y=0
 *
 *  in thread 1:
 *      x = 1; j = y;
 *  in thread 2:
 *      y = 1; i = x;
 *  can i=0 and j=0? the answer is Yes! the compiler or the processors or both can actually switch the order
 *  of independent accesses in your program.the compiler can look at thread 2 and decide that those two actions
 *  would be more efficient if they perform the action in the opposite order,so it can just switch the order around.
 *
 *
 *  when are actions visible to other Threads?
 *      thread 1        thread 2
 *    ref1.x = 1
 *    lock M       --->  lock M
 *    glo = ref1   |     ref2 = glo
 *    unlock M ----|     unlock M
 *                       j = ref2.x
 *
 *    Everything before an unlock(release) which is ordered,is visible to everything after a later lock(acquire) on the same object
 *    A release and a matching later acquire establish a happens-before ordering.execution order within a thread
 *    also establish a happens-before order,happens-before order is transitive.take the example above,what it means
 *    it that the first instruction in thread 1 happens before the second instruction in thread 1 happens before the
 *    third instruction in thread 1 etc,which happens before the subsequent lock on the same monitor which happens
 *    before all those instructions in thread 2,because it is transitive ,so you can say the first instruction in
 *    thread 1 happens before the last instruction in thread 2.instruction actually means what happens in the VM.
 *
 *  Date race
 *      there are two accesses to a memory location,at least one of those accesses is a write and the memory location
 *      isn't volatile,then the access must be ordered by happens-before,violate this,and it is ridiculously hard
 *      to figure out what your program can do
 *
 *  Volatile fields:
 *      If a field could be simultaneously accessed by multiple threads,and at least one of those accesses is a write
 *      two choices:
 *          use locking to prevent simultaneous access
 *          make the field volatile(a non-blocking synchronization in Java)
 *       volatile fields reads and writes go directly to memory(not cached in registers)
 *       volatile long and double are atomic(not true for non-volatile longs and doubles)
 *       volatile reads/writes cannot be reordered
 *       reads/writes become acquire/release pairs.A volatile write is similar to unlock or monitor exit,
 *       a volatile read is similar to a lock or monitor enter.
 *
 *       one of the properties of the regular long and double values is that java virtual machine are allowed to
 *       write 32 bits at a time,
 */

/**
 *  Java heap and stack
 *
 *  0GB                                          2GB                                               4GB
 *  ---------------------+------------------------+--------------------------+----------------------+
 *  | OS and C-Runtime   |  JVM   Native| Heap                    |         Java Heap(s)            |
 *  |--------------------|------------------------+--------------------------+----------------------+
 *  0x0                                                                                        0xFFFFFFFF
 *  the native heap is use by JVM to do stuff on behalf of java code.Java Stack is on the native heap.
 *  For example,you created a new thread use new Thread(),JVM will allocate Thread object on the Java heap
 *  on the native heap,we actually have to create OS-level thread,and that OS-level thread is gonna have
 *  stack,which is use for running methods and functions.every thread has its own stack
 *
 *  Integer i = new Integer(10); 10 is a 32 bits long integer
 *  the autoboxed object of primitive integer of value 10 is 4 times bigger of the integer size(32 bit process)
 *          class pointer : pointer to class information  32 bits
 *          Flags : shape,hash code etc.                  32 bits
 *          Lock : for synchronization,                   32 bits
 *          value: 10 ,                                   32 bits
 *
 *          64 bit process
 *          class pointer : pointer to class information  64 bits
 *          Flags : shape,hash code etc.                  64 bits
 *          Lock : for synchronization,                   64 bits
 *          value: 10 ,                                   32 bits
 *
 *   String s = new String("MyString")
 *          class pointer + Flags + Locks + hash + count + offset + value(a pointer to another object which is a character array)
 *                                                                    |
 *          -----------------------------------------------------------
 *          |
 *          class pointer + Flags + Locks + Size + M + y + S + t + r + i + n + g
 *
 *
 *
 *    The idea of async IO is that you begin the I/O and return to do other stuff,then when the I/O is finished,you are notified
 *    and can do more I/O,in other words,you are not waiting around for it to finish.
 */
public class ConcurrentPkg {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");
        MyThread t = new MyThread("child #1");
        Thread newThread = new Thread(t);
        newThread.start();
        try {
            newThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0 ; i < 50; i++) {
            System.out.println(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Main thread terminating");
    }
}

class MyThread implements Runnable {
    String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + " starting.");
        try {
            for(int i = 0; i < 10; i++) {
                /**
                 * Thread sleep doesn't lose any monitor of locks the current thread has acquired.
                 * you can interrupt the sleeping thread by call the interrupt() method.
                 */
                Thread.sleep(400); // pause the execution of current thread for specific time.
                System.out.println("In " + threadName + ", count is " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        }
        System.out.println(threadName + " terminating.");
    }
}

class Widget {
    public synchronized void doSomething() {

    }
}

class LoggingWidget extends Widget {
    @Override
    public void doSomething() {

    }
}
