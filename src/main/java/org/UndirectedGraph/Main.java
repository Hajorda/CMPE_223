package org.UndirectedGraph;


import java.util.ArrayList;
import java.util.Scanner;

//Main class for question 1
public class Main {
    public static boolean checkAdj(Graph g, int x, int y) {
        for (int w : g.adj(x)) {
            if (w == y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n, m, x, y;
          Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // Total stations
        m = sc.nextInt(); // Railway tracks
        x = sc.nextInt(); // Home station
        y = sc.nextInt(); // Tedu station

        Graph graph = new Graph(n);

        int a, b;
        for (int i = 0; i < m; i++) {

            a = sc.nextInt();
            b = sc.nextInt();

            graph.addEdge(a - 1, b - 1);
        }


          /* int V = 5; // Number of vertices
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        y = 2; //tedu
        x = 4; //home
        n = 4;
        m = 4;
 */

        BreadthFirstPaths bfs = new BreadthFirstPaths();
        bfs.bfs(graph, y - 1);
        int initialDistance = bfs.getDistTo()[x - 1];
        //  System.out.println("Distance from Tedu to Home: "+initialDistance);



        bfs.bfs(graph, 0);
        int[] edgeTo = bfs.getEdgeTo();

        // Printing all possible paths on the graph except the one that we already declared above

        ArrayList<String> path = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {


                if (!checkAdj(graph, i, j)) {

                    graph.addEdge(i, j);

                    bfs.bfs(graph, y - 1);
                    int tdistance = bfs.getDistTo()[x - 1];
                    // System.out.println("Distance from Tedu to Home: !!!"+tdistance);

                    if (tdistance >= initialDistance) {
                        path.add(((i + 1) + " " + (j + 1)));
                        count++;
                        bfs.bfs(graph, i);
                    } else {
                        graph.removeEdge(i, j);
                        // System.out.println("Path from " + (i+1) + " to " + (j+1) + " is removed");
                    }


                }
            }

        }
        System.out.println(count);
        for (String s : path) {
            System.out.println(s);
        }

    }
}
