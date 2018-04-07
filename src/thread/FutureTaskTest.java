package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * Because FutureTask implements Runnable, a FutureTask can be submitted to an Executor for execution.
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            System.out.println("hello world");
            return "future callable";
        };
        FutureTask<String> stringFutureTask = new FutureTask<>(callable);
        stringFutureTask.run();
        String s = stringFutureTask.get();
        System.out.println(s);
    }
}
