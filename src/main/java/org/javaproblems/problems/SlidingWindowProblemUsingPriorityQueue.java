package org.javaproblems.problems;

import java.util.*;

/**
 * this takes O(N*K)
 * sliding window problem is, print largest element in current sliding window,
 * keep sliding thill end
 */
public class SlidingWindowProblemUsingPriorityQueue {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,3,42,23,7,8}; // find the larget element in kt
        //3,4,5,6,6,42,42,42,23
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        int[] resArr = new int[n - k + 1];

        for(; i < k; i++){
            pq.offer(arr[i]);
        }
        int v = pq.isEmpty() ? 0: pq.peek();
        resArr[0] = v;
        res.add(v);

        for(int j = k; j < n; j++){
            pq.remove(arr[j - k]);
            pq.offer(arr[j]);
            res.add(pq.peek());
            resArr[j - k + 1] = pq.peek();
        }

        res.forEach(System.out::println);
        Arrays.stream(resArr).forEach(System.out::println);




    }
}
