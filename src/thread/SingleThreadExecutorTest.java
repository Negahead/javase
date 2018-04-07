package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " say hello");
            System.out.println("===============================================");
        };
        /**
         * Tasks are guaranteed to execute sequentially,and no more than one task will be active at any given time.
         *
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        System.out.println("shuting down");
        executorService.shutdown();

    }
}
