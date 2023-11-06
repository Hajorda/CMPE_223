package org.UndirectedGraph;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n, m, x, y;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // Total stations
        m = sc.nextInt(); // Railway tracks
        x = sc.nextInt(); // Home station
        y = sc.nextInt(); // Tedu station

        Graph graph = new Graph(n);

        int a, b;
        System.out.println(y);
        for (int i = 0; i < m; i++) {

            a = sc.nextInt();
            b = sc.nextInt();

            graph.addEdge(a - 1, b - 1);
        }

     /*
        int V = 5; // Number of vertices
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        y = 2; //tedu
        x = 4; //home

      */

        BreadthFirstPaths bfs = new BreadthFirstPaths();
        bfs.bfs(graph, y - 1);
        int initialDistance = bfs.getDistTo()[x - 1];
        //  System.out.println("Distance from Tedu to Home: "+initialDistance);


        bfs.bfs(graph, 0);
        int[] edgeTo = bfs.getEdgeTo();

        // Printing all possible paths on the graph except the one that we already declared above
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {


                if (edgeTo[i] != j && edgeTo[j] != i) {

                    graph.addEdge(i, j);

                    bfs.bfs(graph, y - 1);
                    int tdistance = bfs.getDistTo()[x - 1];
                    // System.out.println("Distance from Tedu to Home: !!!"+tdistance);


                    if (tdistance >= initialDistance) {
                        System.out.println((i + 1) + " " + (j + 1));
                        bfs.bfs(graph, i);
                    } else {
                        graph.removeEdge(i, j);
                        // System.out.println("Path from " + (i+1) + " to " + (j+1) + " is removed");
                    }


                }
            }

        }


    }
}
