package org.javaproblems.algorithms.minimumcostspanningtree.greedyway;

import java.util.*;

/**
 * Pair class represents a vertex-weight pair.
 * PairComparator class implements a comparator to
 * compare Pair objects based on their weights.
 * primMST function implements Prim's algorithm using a PriorityQueue of Pair objects.
 * The priority queue orders the pairs based on their weights.
 * The algorithm proceeds similarly to the previous implementations,
 * updating the key values and parent indices as it explores the graph.
 */
public class PrimsAlgorithmUsingPriorityQueueAndHashMapWithArrayListArrayListPair {
    static class Pair {
        int vertex;
        int weight;

        public Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p1.weight, p2.weight);
        }
    }

    public static void primMST(ArrayList<ArrayList<Pair>> graph) {
        int V = graph.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        Map<Integer, Integer> parent = new HashMap<>();
        int[] key = new int[V];
        boolean[] visited = new boolean[V];

        // Initialize key values of all vertices to INFINITY
        Arrays.fill(key, Integer.MAX_VALUE);

        // Start from vertex 0
        int src = 0;
        pq.add(new Pair(src, 0));
        key[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            visited[u] = true;

            // Update key value and parent index of adjacent vertices of u
            for (Pair edge : graph.get(u)) {
                int v = edge.vertex;
                int weight = edge.weight;

                if (!visited[v] && weight < key[v]) {
                    parent.put(v, u);
                    key[v] = weight;
                    pq.add(new Pair(v, weight));
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
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(new Pair(1, 2),
                new Pair(3, 6))));
        graph.add(new ArrayList<>(Arrays.asList(new Pair(0, 2),
                new Pair(2, 3),
                new Pair(3, 8),
                new Pair(4, 5))));
        graph.add(new ArrayList<>(Arrays.asList(new Pair(1, 3),
                new Pair(4, 7))));
        graph.add(new ArrayList<>(Arrays.asList(new Pair(0, 6),
                new Pair(1, 8))));
        graph.add(new ArrayList<>(Arrays.asList(new Pair(1, 5),
                new Pair(2, 7),
                new Pair(3, 9))));
        primMST(graph);
    }
}
