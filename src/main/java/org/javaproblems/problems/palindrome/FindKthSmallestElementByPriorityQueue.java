package org.javaproblems.problems.palindrome;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthSmallestElementByPriorityQueue {



    static int k = 3;


    public static void main(String [] args){
        int[] arr = {1, 2, 3, 4, 8, 7, 9};
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k ; i++){
            pq.add(arr[i]);
        }
        //System.out.println(pq.peek());
        for(int i = k; i < arr.length; i++){
            System.out.println(pq.peek() +"-"+arr[i]);
            if(arr[i] < pq.peek() ){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        System.out.println(pq.peek());
    }

}
