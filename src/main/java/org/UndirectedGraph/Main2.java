package org.UndirectedGraph;

import java.util.Scanner;

// Main class for question 2
public class Main2 {

    static int minCost = Integer.MAX_VALUE;
    static int[] minPath;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        m = sc.nextInt(); // Number of museums
        n = sc.nextInt(); // Number of roads between museums
        int[][] cost = new int[m][m];
        Graph graph = new Graph(m);

        for (int i = 0; i < n; i++) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            graph.addEdge(a - 1, b - 1);
            System.out.println((a-1) + " " + (b-1)  + " " + c);
            cost[a - 1][b - 1] = cost[b - 1][a - 1] = c;
        }
        System.out.println("Loop bitti");

        boolean[] visited = new boolean[m];
        int[] path = new int[m];
        minPath = new int[m];

        // Start the TSP from museum 0
        path[0] = 0;
        visited[0] = true;
        tsp(graph, cost, visited, path, 1, 0, m);

        if (minCost == Integer.MAX_VALUE) {
            System.out.println("-1"); // No way to visit all museums
        } else {
            System.out.println("Minimum Cost: " + minCost); // Print the minimum cost

            System.out.print("Minimum Cost Path: ");
            for (int i = 0; i < m; i++) {
                System.out.print(minPath[i] + " ");
            }
            System.out.println(minPath[0]); // Print the path
        }
    }

    // Recursive function to find the minimum cost Hamiltonian Cycle
    static void tsp(Graph graph, int[][] cost, boolean[] visited, int[] path, int pos, int costSoFar, int m) {
        if (pos == m) {
            // If all museums have been visited
            if (graph.adj(path[pos - 1]).iterator().hasNext() && graph.adj(path[pos - 1]).iterator().next() == 0) {
                if (costSoFar + cost[path[pos - 1]][0] < minCost) {
                    minCost = costSoFar + cost[path[pos - 1]][0];
                    System.arraycopy(path, 0, minPath, 0, m); // Update minimum path
                }
            }
            return;
        }

        for (int v = 1; v < m; v++) {
            if (!visited[v] && graph.adj(path[pos - 1]).iterator().hasNext() && graph.adj(path[pos - 1]).iterator().next() == v) {
                visited[v] = true;
                path[pos] = v;
                tsp(graph, cost, visited, path, pos + 1, costSoFar + cost[path[pos - 1]][v], m);
                visited[v] = false;
            }
        }
    }
}
