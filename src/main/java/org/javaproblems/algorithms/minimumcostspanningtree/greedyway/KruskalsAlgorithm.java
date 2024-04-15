package org.javaproblems.algorithms.minimumcostspanningtree.greedyway;

import java.util.*;

/**
 * We sort the edges in ascending order of their weights and initialize a priority queue (PriorityQueue<Edge>) with the sorted edges.
 * We also initialize a hashmap (parent) to store the parent vertices.
 * In the main loop, we repeatedly poll the minimum-weight edge from the priority queue and check if adding it to the MST would form a cycle.
 * We find the parent vertices of the source and destination vertices using the find method, which utilizes path compression.
 * If adding the edge doesn't form a cycle, we add it to the MST and update the parent vertex of the source vertex in the hashmap.
 * We repeat this process until we have V-1 edges in the MST, where V is the number of vertices in the graph.
 */
class Edge implements Comparable<Edge1> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge1 other) {
        return this.weight - other.weight;
    }
}

public class KruskalsAlgorithm {
    public static List<Edge1> kruskalMST(List<Edge1> edge1s, int V) {
        Collections.sort(edge1s);

        List<Edge1> mst = new ArrayList<>();
        PriorityQueue<Edge1> pq = new PriorityQueue<>(edge1s);
        Map<Integer, Integer> parent = new HashMap<>();

        for (int i = 0; i < V; i++) {
            parent.put(i, i);
        }

        while (!pq.isEmpty() && mst.size() < V - 1) {
            Edge1 edge1 = pq.poll();
            int srcParent = find(parent, edge1.src);
            int destParent = find(parent, edge1.dest);

            if (srcParent != destParent) {
                mst.add(edge1);
                parent.put(srcParent, destParent);
            }
        }

        return mst;
    }

    public static int find(Map<Integer, Integer> parent, int vertex) {
        if (parent.get(vertex) != vertex) {
            parent.put(vertex, find(parent, parent.get(vertex)));
        }
        return parent.get(vertex);
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge1> edge1s = new ArrayList<>();
        edge1s.add(new Edge1(0, 1, 10));
        edge1s.add(new Edge1(0, 2, 6));
        edge1s.add(new Edge1(0, 3, 5));
        edge1s.add(new Edge1(1, 3, 15));
        edge1s.add(new Edge1(2, 3, 4));

        List<Edge1> mst = kruskalMST(edge1s, V);

        System.out.println("Edges of Minimum Spanning Tree:");
        for (Edge1 edge1 : mst) {
            System.out.println(edge1.src + " - " + edge1.dest + ": " + edge1.weight);
        }
    }
}
