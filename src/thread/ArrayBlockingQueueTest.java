package thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;


/**
 * ArrayBlockingQueue and LinkedBlockingQueue doesn't allow null elements
 *
 * ArrayBlockingQueue is backed by an array that size will never change after creation,i.e.,always bounded
 * LinkedBlockingQueue is built on top of linked nodes ,creates nodes dynamically until the capacity is reached,optionally bounded
 *
 * Common methods of BlockingQueue are put() and take(),put() will block if BlockingQueue is full,take() will
 * block if BlockingQueue is empty().
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> maps = new ArrayBlockingQueue<>(6);
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        ExecutorCompletionService<String> stringExecutorCompletionService = new ExecutorCompletionService<>(executorService);
        maps.put("dopa");
        maps.put("faker");
        maps.put("rookie");
        maps.put("The shy");
        maps.put("Insec");
        maps.put("piglet");
        Iterator<String> iterator = maps.iterator();
        while (maps.size() > 0) {
//            System.out.println(maps.take()); // FIFO order
            System.out.println("size is " + maps.size());
            String take = maps.take();
            stringExecutorCompletionService.submit(() -> {
                    return take+"---------"+Thread.currentThread().getName();
            });
        }

        System.out.println("=================");

        for(int i=0; i<6;i ++) {
            Future<String> take = stringExecutorCompletionService.take();
            try {
                System.out.println(take.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();


    }
}
