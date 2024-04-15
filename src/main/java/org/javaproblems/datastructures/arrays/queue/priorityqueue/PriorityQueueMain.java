package org.javaproblems.datastructures.arrays.queue.priorityqueue;
import java.util.PriorityQueue;
/**
 * A PriorityQueue in Java is a special type of queue where elements are stored based on
 * their natural ordering or by a Comparator provided at queue construction time.
 * The key characteristic of a PriorityQueue is that the elements are ordered based on their priority,
 * and the element with the highest priority is always at the front of the queue.
 *
 * In the above code:
 *
 * We create a PriorityQueue of integers (PriorityQueue<Integer>).
 * Elements are added to the PriorityQueue using the offer() method.
 * We print the PriorityQueue to observe the order of elements.
 * Elements are removed from the PriorityQueue using the poll() method. Since this is a
 * PriorityQueue, elements are removed in ascending order of priority.
 * Diagrammatically, a PriorityQueue can be represented as follows:
 *
 * makefile
 * Copy code
 * PriorityQueue:
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * In this diagram, the root (top) element is the smallest, which represents the highest priority.
 *
 * For a detailed explanation and visual representation of PriorityQueue in Java, you can refer
 * to the following YouTube video:
 *
 * PriorityQueue in Java with Example | PriorityQueue Class in Java | Java Collections Framework
 *
 * 0---------------------------
 * A PriorityQueue is typically implemented as a binary heap, where elements are arranged
 * in a binary tree structure. The elements are ordered based on their priority, with the
 * highest priority element (lowest value in the case of min-heap) at the root of the tree.
 * Here's a diagrammatic representation of a PriorityQueue (min-heap):
 *
 * ```
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    5   4 8   6
 * ```
 *
 * In this diagram:
 * - The root element (1) has the highest priority (lowest value).
 * - Each parent node has a priority less than or equal to its children (min-heap property).
 * - The structure is a binary tree, and each node (except possibly the last row) has two children.
 * - The elements are arranged such that for any given node, its left child has a lower value
 * (higher priority) than itself, and its right child has a higher value (lower priority) than itself.
 *
 * This diagram represents a small portion of the entire PriorityQueue. In reality,
 * a PriorityQueue can hold many more elements, and the binary tree structure extends further.
 *
 * When elements are removed from the PriorityQueue (typically using the `poll()`
 * method), the PriorityQueue reorganizes itself to maintain the heap property.
 * This involves moving elements
 * up or down the tree to ensure that the element with the highest priority remains at the root.
 */
public class PriorityQueueMain {
    public static void main(String[] args) {
        // Creating a PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements to the PriorityQueue
        pq.offer(3);
        pq.offer(1);
        pq.offer(5);
        pq.offer(2);
        pq.offer(4);

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        // Printing the PriorityQueue
        System.out.println("PriorityQueue: " + pq);

        // Removing elements from the PriorityQueue
        while (!pq.isEmpty()) {
            System.out.println("Removing element: " + pq.poll());
        }
    }
}