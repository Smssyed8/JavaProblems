package org.javaproblems.algorithms.minimumcostspanningtree.greedyway;
/**
 * We use a priority queue (PriorityQueue<Edge>)
 * to store the edges sorted by their weights.
 * We iterate through the edges in the priority queue,
 * selecting the minimum-weight edge at each step.
 * We check if adding the current edge to the MST would create a cycle using
 * a Union-Find data structure (UnionFind class).
 * If adding the edge doesn't create a cycle,
 * we add it to the MST and merge the sets of the source and
 * destination vertices using Union-Find.
 * We repeat this process until we have V-1 edges in the MST,
 * where V is the number of vertices in the graph.
 */

import java.util.*;

class Edge1 implements Comparable<Edge1> {
    int src, dest, weight;

    public Edge1(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge1 other) {
        return this.weight - other.weight;
    }
}

public class KruskalsAlgorithmWithUnionFind {
    public static List<Edge1> kruskalMST(List<Edge1> edge1s, int V) {
        Collections.sort(edge1s);

        List<Edge1> mst = new ArrayList<>();
        PriorityQueue<Edge1> pq = new PriorityQueue<>(edge1s);

        UnionFind uf = new UnionFind(V);

        while (!pq.isEmpty() && mst.size() < V - 1) {
            Edge1 edge1 = pq.poll();
            int srcParent = uf.find(edge1.src);
            int destParent = uf.find(edge1.dest);

            if (srcParent != destParent) {
                mst.add(edge1);
                uf.union(srcParent, destParent);
            }
        }

        return mst;
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

class UnionFind {
    int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }
}
