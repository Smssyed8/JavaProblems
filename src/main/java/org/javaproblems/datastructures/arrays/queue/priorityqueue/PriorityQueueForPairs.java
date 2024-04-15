package org.javaproblems.datastructures.arrays.queue.priorityqueue;

/**
 * To store pairs of vertices with weights in a PriorityQueue in
 * Java where the lowest weight has the highest priority,
 * you can create a custom class to represent the pairs and implement the
 * Comparable interface to define the ordering based on the weights. Here's how you can do it:
 */
import java.util.*;

// Custom class to represent pairs of vertices and weights
class Pair implements Comparable<Pair> {
    int vertex;
    int weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    // Implement compareTo method to define ordering based on weight
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class PriorityQueueForPairs {
    public static void main(String[] args) {
        // Creating a PriorityQueue of pairs
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Adding pairs to the PriorityQueue
        pq.offer(new Pair(1, 10));
        pq.offer(new Pair(2, 5));
        pq.offer(new Pair(3, 8));
        pq.offer(new Pair(4, 3));
        pq.offer(new Pair(5, 7));

        // Printing the PriorityQueue
        System.out.println("PriorityQueue:");
        for (Pair pair : pq) {
            // below is not printing in right priority order, it give 10 before 7, so use poll
            //System.out.println("Vertex: " + pair.vertex + ", Weight: " + pair.weight);

        }
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            System.out.println("Vertex: " + pair.vertex + ", Weight: " + pair.weight);
        }
    }
}
/**
 * We create a custom class Pair to represent the vertex-weight pairs. This class implements the Comparable interface so that pairs can be compared based on their weights.
 * We override the compareTo() method to compare pairs based on their weights.
 * We create a PriorityQueue of Pair objects where the ordering is defined by the weights. Since we've implemented Comparable, the pairs with lower weights will have higher priority.
 * We add pairs to the PriorityQueue using the offer() method.
 * Finally, we print the PriorityQueue to observe the pairs in order of their weights.
 */
