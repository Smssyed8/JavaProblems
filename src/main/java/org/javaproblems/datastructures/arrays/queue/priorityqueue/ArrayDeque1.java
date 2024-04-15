package org.javaproblems.datastructures.arrays.queue.priorityqueue;

import java.util.ArrayDeque;

/**
 *ArrayDeque in Java is a resizable, array-based double-ended queue implementation.
 *  It provides more efficient operations compared to LinkedList for adding and
 *  removing elements from both ends of the deque.
 *  Here's a brief explanation along with some code:
 *
 *  In this code:
 *
 * We import ArrayDeque from the java.util package.
 * We create an ArrayDeque of integers (ArrayDeque<Integer>).
 * We add elements to both ends of the deque using addFirst() and addLast() methods.
 * We print the deque to observe the order of elements.
 * We remove elements from both ends of the deque using removeFirst() and removeLast() methods.
 * ArrayDeque can be represented diagrammatically as follows:
 *
 * css
 * Copy code
 * Front -> [3, 2, 1, 4, 5, 6] <- Rear
 * In this diagram:
 *
 * Elements are added to the front of the deque using addFirst() method.
 * Elements are added to the end of the deque using addLast() method.
 * Elements can be removed from both ends using removeFirst() and removeLast() methods.
 * The deque grows dynamically as needed to accommodate more elements.
 * ArrayDeque is more efficient compared to LinkedList for most operations,
 * especially when adding or removing elements from both ends of the deque.
 * However, it does not allow null elements.
 */

public class ArrayDeque1 {
    public static void main(String[] args) {
        // Creating an ArrayDeque
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // Adding elements to the front of the deque
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        // Adding elements to the end of the deque
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);

        // Printing the deque
        System.out.println("ArrayDeque: " + deque);

        // Removing elements from the front and end of the deque
        while (!deque.isEmpty()) {
            System.out.println("Removing first: " + deque.removeFirst());
            System.out.println("Removing last: " + deque.removeLast());
        }
    }
}
