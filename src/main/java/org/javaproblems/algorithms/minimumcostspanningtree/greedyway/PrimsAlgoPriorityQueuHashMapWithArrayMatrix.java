package org.javaproblems.algorithms.minimumcostspanningtree.greedyway;

import java.util.*;

public class PrimsAlgoPriorityQueuHashMapWithArrayMatrix {
    public static void primMST(int[][] graph) {
        int V = graph.length;
        int[] key = new int[V];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> key[v]));
        Map<Integer, Integer> parent = new HashMap<>();
        boolean[] visited = new boolean[V];

        // Initialize key values of all vertices to INFINITY
        Arrays.fill(key, Integer.MAX_VALUE);

        // Start from vertex 0
        int src = 0;
        pq.add(src);
        key[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll();
            visited[u] = true;

            // Update key value and parent index of adjacent vertices of u
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && graph[u][v] < key[v]) {
                    parent.put(v, u);
                    key[v] = graph[u][v];
                    pq.add(v); // Corrected: Add the vertex index v
                }
            }
        }

        // Print the edges of MST
        System.out.println("Edges of Minimum Spanning Tree:");
        for (int v = 1; v < V; v++) {
            System.out.println(parent.get(v) + " - " + v);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};
        primMST(graph);
    }
}
