import java.util.*;

/**
 *
 * The offer method inserts an element if possible, otherwise returning false. This differs from the
 * Collection.add method, which can fail to add an element only by throwing an unchecked exception.
 *
 * The remove() and poll() methods remove and return the head of the Queue
 * The remove() and poll() methods differ only in their behavior when the Queue is empty: the remove()
 * method throws an exception, while the poll() method returns null.
 *
 * The element() and peek() methods return, but do not remove, the head of the Queue.
 */
public class QueueTest {
    public static void main(String[] args) {
        /**
         * Resizable-array implementation of the Deque interface.
         * not thread safe,do not support concurrent access by multiple threads,null elements are prohibited
         */
        Deque<String> deque = new ArrayDeque<>();
        deque.add("dopa");
        deque.add("dopa1");

        deque.add("dopa2"); // dopa,dopa1,dopa2

//        deque.addFirst("faker");
//        deque.addLast("rookie");
        // faker,dopa,rookie
        deque.forEach(System.out::println);
        // rookie,peek*() will return null if the collection is empty,while get*() throws Exceptions
        System.out.println("peek last get " + deque.peekLast());
        // faker
        System.out.println("peek first get " + deque.peekFirst());

        String first = deque.pollFirst();
        System.out.println("Retrieves and removes the first element " + first);


        /**
         * permits null element,not thread-safe,doubly-linked list implementation of the list and deque interfaces.
         */
        LinkedList<String> linkedList = new LinkedList<>();
        /**
         * the elements of the priority queue are ordered according to their natural ordering,or by a Comparator provided
         * at queue construction time.does not permit null elements.A priority queue relying on a natural ordering also
         * does not permit insertion of non-comparable objects.NOT SYNCHRONIZED
         */
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("elements");
        priorityQueue.add("ordered");
        priorityQueue.add("natural");
        priorityQueue.add("comparable");
        // comparable,elements,natural,ordered
        priorityQueue.forEach(System.out::println);
        if("mongo".endsWith("ow")) {

        }

    }
}
