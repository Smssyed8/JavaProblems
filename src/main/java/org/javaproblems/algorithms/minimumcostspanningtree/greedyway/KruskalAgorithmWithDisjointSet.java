package org.javaproblems.algorithms.minimumcostspanningtree.greedyway;
/**
 * Kruskal's algorithm is a greedy algorithm used to find the minimum spanning tree (MST) of a connected, undirected graph. The idea is to add edges to the MST in ascending order of their weights, while ensuring that no cycles are formed. Kruskal's algorithm is efficient and has a time complexity of O(E log V), where E is the number of edges and V is the number of vertices in the graph.
 *
 * Here's a step-by-step explanation of Kruskal's algorithm:
 *
 * Sort Edges: Sort all the edges of the graph in non-decreasing order of their weights.
 * Initialize MST: Create an empty graph to store the MST.
 * Iterate Through Edges: Iterate through the sorted edges. For each edge:
 * If including the edge in the MST does not form a cycle, add it to the MST.
 * A cycle can be detected using a data structure like Union-Find (Disjoint Set).
 * Stop: Repeat the process until all vertices are included in the MST, or until the MST has V-1 edges (where V is the number of vertices in the graph).
 * Now, let's provide a pseudocode for Kruskal's algorithm:
 *
 * sql
 * Copy code
 * KruskalMST(Graph G):
 *     1. Sort all the edges of G in non-decreasing order of their weights.
 *     2. Create an empty graph MST to store the minimum spanning tree.
 *     3. Initialize a Union-Find data structure.
 *     4. For each edge (u, v) in the sorted list of edges:
 *         a. If adding the edge (u, v) to MST does not form a cycle:
 *             i. Add the edge (u, v) to MST.
 *             ii. Union the sets containing u and v in the Union-Find data structure.
 *         b. If MST contains V-1 edges (where V is the number of vertices), stop.
 *     5. Return MST.
 */

import java.util.*;

class Edge2 implements Comparable<Edge2> {
    int src, dest, weight;

    public Edge2(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge2 other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    int[] parent;

    public DisjointSet(int size) {
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

public class KruskalAgorithmWithDisjointSet {
    public static List<Edge2> kruskalMST(List<Edge2> edge2s, int V) {
        Collections.sort(edge2s);

        List<Edge2> mst = new ArrayList<>();
        DisjointSet ds = new DisjointSet(V);

        int edgeCount = 0;
        for (Edge2 edge2 : edge2s) {
            if (edgeCount == V - 1) {
                break;
            }

            int srcParent = ds.find(edge2.src);
            int destParent = ds.find(edge2.dest);

            if (srcParent != destParent) {
                mst.add(edge2);
                ds.union(srcParent, destParent);
                edgeCount++;
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge2> edge2s = new ArrayList<>();
        edge2s.add(new Edge2(0, 1, 10));
        edge2s.add(new Edge2(0, 2, 6));
        edge2s.add(new Edge2(0, 3, 5));
        edge2s.add(new Edge2(1, 3, 15));
        edge2s.add(new Edge2(2, 3, 4));

        List<Edge2> mst = kruskalMST(edge2s, V);

        System.out.println("Edges of Minimum Spanning Tree:");
        for (Edge2 edge2 : mst) {
            System.out.println(edge2.src + " - " + edge2.dest + ": " + edge2.weight);
        }
    }
}
