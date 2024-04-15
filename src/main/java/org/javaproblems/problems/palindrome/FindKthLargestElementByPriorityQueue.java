package org.javaproblems.problems.palindrome;

import java.util.PriorityQueue;

public class FindKthLargestElementByPriorityQueue {



    static int k = 3;


    public static void main(String [] args){
        int[] arr = {1, 2, 3, 4, 8, 7, 9};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= k ; i++){
            pq.add(i);
        }

        for(int i = k; i < arr.length; i++){
            if(pq.peek() < arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        System.out.println(pq.peek());
    }

}
