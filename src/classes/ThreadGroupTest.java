package classes;

/**
 * Created by AlphaGo on 12/31/2017.
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        /**
         * each thread group,except system,must have a parent thread group,for Thread(String name),the parent is
         * the thread group of the thread calls ThreadGroup(String name).For example ,if the main thread calls
         * ThreadGroup(String name),the newly created thread group has the main thread's group as its parent.
         * For ThreadGroup(ThreadGroup parent,String name),the parent is the group that parent references.
         *
         *      ThreadGroup tg = new ThreadGroup("groupName");
         *      Thread t = new Thread(tg,"threadName");
         *
         * A thread group's maximum priority in the highest priority any of its threads can attain.
         * Any threads that you add to the group after setting the maximum priority cannot have a priority
         * that exceeds the maximum,Any thread with a higher priority automatically lowers when it joins the
         * thread group.,but if you use setMaxPriority(int priority) to lower a group's maximum priority,all threads
         * added to the group prior to that method will keep their original priorities.
         */

        ThreadGroup tg = new ThreadGroup("threadGroup1");
        Thread thread1 = new Thread(tg,"thread1");
        Thread thread2 = new Thread(tg,"thread2");
        Thread thread3 = new Thread(tg,"thread3");
        tg = new ThreadGroup("threadGroup2");
        Thread thread4 = new Thread(tg,"thread4");

        tg = Thread.currentThread().getThreadGroup();
        System.out.println("current group " + tg.getName() + " active threads count is " + tg.activeCount());
        System.out.println("active group count in the current group is " + tg.activeGroupCount());
        tg.list();

    }
}
