package thread;


import java.util.concurrent.*;

/**
 *
 */
public class AboutLock {

    public static void main(String[] args) {
        scheduledExecutor();
    }

    static void threadPool() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10 ;i++) {
                    System.out.println(i);
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int j = 0 ; j < 10; j++) {
            executorService.execute(task);
            System.out.println("=======================");
        }
        executorService.shutdown();
    }

    static void scheduledExecutor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        ScheduledFuture<String> schedule = scheduledExecutorService.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello world";
            }
        }, 3, TimeUnit.SECONDS);

        try {
            System.out.println(schedule.get());
            scheduledExecutorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
