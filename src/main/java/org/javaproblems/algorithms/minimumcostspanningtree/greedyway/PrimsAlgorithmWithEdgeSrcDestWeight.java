package org.javaproblems.algorithms.minimumcostspanningtree.greedyway;

import java.util.*;

class Edge3 implements Comparable<Edge3> {
    int src;
    int dest;
    int weight;

    public Edge3(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge3 other) {
        return this.weight - other.weight;
    }
}

public class PrimsAlgorithmWithEdgeSrcDestWeight {
    public static List<Edge3> primMST(List<List<Edge3>> adjList, int V) {
        List<Edge3> mst = new ArrayList<>();
        PriorityQueue<Edge3> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        // Start from vertex 0
        visited.add(0);
        for (Edge3 edge3 : adjList.get(0)) {
            pq.offer(edge3);
        }

        while (!pq.isEmpty() && mst.size() < V - 1) {
            Edge3 minEdge3 = pq.poll();
            int dest = minEdge3.dest;

            if (!visited.contains(dest)) {
                mst.add(minEdge3);
                visited.add(dest);

                for (Edge3 edge3 : adjList.get(dest)) {
                    if (!visited.contains(edge3.dest)) {
                        pq.offer(edge3);
                    }
                }
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Edge3>> adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        addEdge(adjList, 0, 1, 10);
        addEdge(adjList, 0, 2, 6);
        addEdge(adjList, 0, 3, 5);
        addEdge(adjList, 1, 3, 15);
        addEdge(adjList, 2, 3, 4);

        List<Edge3> mst = primMST(adjList, V);

        System.out.println("Edges of Minimum Spanning Tree:");
        for (Edge3 edge3 : mst) {
            System.out.println(edge3.src + " - " + edge3.dest + ": " + edge3.weight);
        }
    }

    private static void addEdge(List<List<Edge3>> adjList, int src, int dest, int weight) {
        adjList.get(src).add(new Edge3(src, dest, weight));
        adjList.get(dest).add(new Edge3(dest, src, weight));
    }
}
