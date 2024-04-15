package org.javaproblems.algorithms.SchedulingAlgorithms.greedyway;

import java.util.*;

/**
 * Scheduling algorithms deal with efficiently allocating resources
 * to tasks or jobs over time. An example is the "Earliest Deadline First" (EDF)
 * scheduling algorithm.
 *
 * Example: Earliest Deadline First (EDF) Scheduling Algorithm
 * In EDF scheduling, the Greedy aspect lies in selecting
 * the job with the earliest deadline and highest profit at each step.
 */
class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class EDF {
    static void printSchedule(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        boolean[] slot = new boolean[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, arr[i].deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = i;
                    slot[j] = true;
                    break;
                }
            }
        }

        System.out.println("Job Schedule:");
        for (int i = 0; i < n; i++) {
            if (slot[i])
                System.out.println("Job " + arr[result[i]].id + " with profit " + arr[result[i]].profit);
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40),
                new Job(4, 1, 30)};
        int n = jobs.length;

        System.out.println("Maximum profit sequence of jobs:");
        printSchedule(jobs, n);
    }
}
