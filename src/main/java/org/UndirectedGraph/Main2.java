package org.UndirectedGraph;

import java.util.Objects;
import java.util.Scanner;

// Main class for question 2
public class Main2 {



   static int[][] cost;

    public static int getCost(Comparable a , Comparable b) {
        return cost[(int)a][(int)b];
    }

    // Utility method to convert a queue to a space-separated string
    public static String pathToString(Queue path) {
        StringBuilder pathString = new StringBuilder();

        while (!path.isEmpty()) {
            pathString.append((int)path.dequeue()+1).append(" ");
        }

        // Remove the trailing space
        if (pathString.length() > 0) {
            pathString.deleteCharAt(pathString.length() - 1);
        }

        String ass = pathString.toString();
        String ass2 = "";
        for(int i=ass.length() ; i >= 0 ; i--)
            ass2 += ass.charAt(i);
        return ass2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        m = sc.nextInt(); // Number of museums
        n = sc.nextInt(); // Number of roads between museums
        cost = new int[m][m];
        Graph graph = new Graph(m);

        for (int i = 0; i < n; i++) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            graph.addEdge(a - 1, b - 1);

            cost[a - 1][b - 1] = cost[b - 1][a - 1] = c;
        }
        System.out.println("Loop bitti");

        int mincost = 100;
         Queue path = new Queue();


        for (int i = 0; i < m; i++) {

            DepthFirstPaths dfs = new DepthFirstPaths();
            Queue temp = dfs.DepthFirstSearch(graph, i);

            if (dfs.getCostPath() < mincost) {
                mincost = dfs.getCostPath();
                path = temp;
            }
        }
        System.out.println(mincost);
        System.out.println(pathToString(path));



        /*DepthFirstPaths dfs = new DepthFirstPaths();
        Queue temp = dfs.DepthFirstSearch(graph, 3);
        System.out.println("Minimum Cost: " + dfs.getCostPath());
        System.out.println("Minimum Cost Path: ");
        temp.printQueue();*/




    }
}