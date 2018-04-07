package thread;

import java.util.concurrent.*;

public class ExecutorCompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<String> c = () -> {
            return Thread.currentThread().getName() + " returning";
        };

        ExecutorCompletionService<String> stringExecutorCompletionService = new ExecutorCompletionService<>(executorService);
        stringExecutorCompletionService.submit(c);
        stringExecutorCompletionService.submit(c);
        stringExecutorCompletionService.submit(c);
        stringExecutorCompletionService.submit(c);
        stringExecutorCompletionService.submit(c);
        for(int i=0; i<5; i++) {
            Future<String> take = stringExecutorCompletionService.take();
            String s = take.get();
            System.out.println(s);
        }
        executorService.shutdown();

    }
}
