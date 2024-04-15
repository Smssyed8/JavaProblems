package org.javaproblems.algorithms.minimumcostspanningtree.greedyway;
/**
 * In this code:
 *
 * Graph represents the graph structure using an adjacency list.
 * Vertex represents each vertex with its associated key value.
 * primMST function implements Prim's algorithm using a
 * PriorityQueue to store vertices based on their keys, and HashMaps
 * to store parent vertices and key values.
 * The algorithm iterates over adjacent edges of the current vertex and
 * updates the key values and parent vertices if a shorter path is found.
 * Finally, it prints the edges of the Minimum Spanning Tree.
 */

import java.util.*;

public class PrimsAlgorithmUsingPriorityQueueAndHashMapWithGraphAndEdge {
    static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;
        List<List<Edge>> adjList;

        public Graph(int V) {
            this.V = V;
            adjList = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dest, int weight) {
            adjList.get(src).add(new Edge(dest, weight));
            adjList.get(dest).add(new Edge(src, weight));
        }

        public List<Edge> getAdjEdges(int src) {
            return adjList.get(src);
        }
    }

    static class Vertex {
        int vertex;
        int key;

        public Vertex(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    public static void primMST(Graph graph) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.key));
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> key = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize key values of all vertices to INFINITY
        for (int i = 0; i < graph.V; i++) {
            key.put(i, Integer.MAX_VALUE);
        }

        // Start from vertex 0
        int src = 0;
        pq.add(new Vertex(src, 0));
        key.put(src, 0);

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            visited.add(u);

            // Update key value and parent index of adjacent vertices of u
            for (Edge e : graph.getAdjEdges(u)) {
                int v = e.dest;
                int weight = e.weight;

                if (!visited.contains(v) && weight < key.get(v)) {
                    parent.put(v, u);
                    key.put(v, weight);
                    pq.add(new Vertex(v, weight));
                }
            }
        }

        // Print the edges of MST
        System.out.println("Edges of Minimum Spanning Tree:");
        for (int v = 1; v < graph.V; v++) {
            System.out.println(parent.get(v) + " - " + v);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        primMST(graph);
    }
}
