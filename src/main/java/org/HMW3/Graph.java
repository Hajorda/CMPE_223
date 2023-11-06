package org.HMW3;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adjList;

    public Graph(int v) {
        V = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void printAllEdges() {
        for (int i = 0; i < V; i++) {
            for (int j : adjList.get(i)) {
                if (i < j) {
                    System.out.println("Edge between vertex " + i + " and vertex " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.printAllEdges();
        // Code for finding all possible edges between vertices in a graph is taken from: https://www.techiedelight.com/find-possible-edges-graph-vertex/

    }
}
