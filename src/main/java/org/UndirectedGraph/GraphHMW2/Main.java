package org.UndirectedGraph.GraphHMW2;

import org.UndirectedGraph.Graph;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        m = sc.nextInt(); // Number of museums
        n = sc.nextInt(); // Number of roads between museums
        int[][] cost = new int[m][m];
        org.UndirectedGraph.Graph graph = new Graph(m);

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
    }


}
