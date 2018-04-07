package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * when a new task is submitted ,and fewer than corePoolSize threads are running,a new thread is created
         * to handle the request,even if other worker threads are idle.By setting corePoolSize and maximumPoolSize
         * the same,you create a fixed-size thread pool.
         *
         * If the pool currently has more than corePoolSize threads,excess threads will be terminated if they have
         * been idle for more than the keepAliveTime.
         */

        ExecutorService executorService = Executors.newFixedThreadPool(9);
        Runnable task = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " says hello");
            System.out.println("===============================================");
        };

        List<Callable<String>> callables = new ArrayList<>();
        for(int i = 0 ; i < 10; i++) {
            Callable<String> callable = () -> {
                String result = Thread.currentThread().getName() + " result";
                return result;
            };
            callables.add(callable);
        }

        List<Future<String>> futures = new ArrayList<>();

        try {
            futures = executorService.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Future<String> f : futures) {
            System.out.println(f.get());
        }

        executorService.shutdown();

    }
}
