package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;

/**
 * TransferQueue is a BlockingQueue,the main difference if that TransferQueue waits for consumer to consume the
 * element,TransferQueue is useful in scenario where message passing need to be guaranteed.
 */
public class TransferQueueTest {
    public static void main(String[] args) {
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<>();
        Runnable producer = () -> {
            for(int i=0; i<3;i++) {
                try {
                    System.out.println("producer is waiting to transfer...");
                    /**
                     * await receipt of elements by consumers invoking take() or timed poll()
                     * ,on the other side,put() will not wait for receipt.
                     *
                     * transfer the specified element immediately if there exists a consumer already waiting to
                     * receive it(take() or timed poll()),else inserts the specified element at the tail of this
                     * queue and waits until the element is received by a consumer.
                     */
                    linkedTransferQueue.transfer("A"+i);
                    System.out.println("current size is " + linkedTransferQueue.size());
                    System.out.println("producer transferred element A: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            for(int i=0; i<3; i++) {
                try {
                    System.out.println("consumer is waiting to take element...");
                    String take = linkedTransferQueue.take();
                    System.out.println("consumer received element: " + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.shutdown();

    }
}
