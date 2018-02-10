package algorithms;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Map<String,LinkedList<String>> graph = new HashMap<>();

        LinkedList<String> meLinkedList = new LinkedList<>();
        meLinkedList.offerLast("Bob");
        meLinkedList.offerLast("Claire");
        meLinkedList.offerLast("Alice");

        LinkedList<String> bobLinkedList = new LinkedList<>();
        bobLinkedList.offerLast("Peggy");
        bobLinkedList.offerLast("Anuj");

        LinkedList<String> claireLinkedList = new LinkedList<>();
        claireLinkedList.offerLast("Jonny");
        claireLinkedList.offerLast("Thom");

        LinkedList<String> aliceLinkedList = new LinkedList<>();
        aliceLinkedList.offerLast("Peggy");

        graph.put("me",meLinkedList);
        graph.put("Bob",bobLinkedList);
        graph.put("Claire",claireLinkedList);
        graph.put("Alice",aliceLinkedList);
        graph.put("Anuj",new LinkedList<>());
        graph.put("Peggy",new LinkedList<>());
        graph.put("Jonny",new LinkedList<>());
        graph.put("Thom",new LinkedList<>());

        dijkstra(graph);
    }

    private static boolean dijkstra(Map<String,LinkedList<String>> graph) {
        List<String> searched = new ArrayList<>();
        LinkedList<String> searchQueue = graph.get("me");
        while (searchQueue.size() > 0) {
            String person = searchQueue.pollFirst();
            if (searched.indexOf(person) == -1) {
                if(person.endsWith("m")) {
                    System.out.printf("person %s sells mongo\n",person);
                    return true;
                } else {
                    searched.add(person);
                    searchQueue.addAll(graph.get(person));
                }
            }

        }
        return false;
    }

    /**
     * there are four steps to Dijkstra's algorithm:
     *  1:  Find the cheapest node.This is the node you can get to in the least amount of time;
     *  2:  Update the costs of neighbors of this node;
     *  3:  Repeat until you've done this for every node in the graph;
     *  4:  calculate the final path.
     *
     *  One the stipulation to using the algorithm is that the graph needs to have a non-negative weight on every edge and should be a directed map.
     */
}
