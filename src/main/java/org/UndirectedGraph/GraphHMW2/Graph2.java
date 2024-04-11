package org.UndirectedGraph.GraphHMW2;


import java.util.LinkedList;

public class Graph2
{
    private final int V;
    private Bag<Integer>[] adj;
    private  LinkedList<Bag<Integer>>[] adj2;



    public int getV() {
        return V;
    }

    public void generateBagVarations(Graph2 g, int v) {
        for(int i = 0 ; i < g.getV() ; i++) {
            BagPermutations a = new BagPermutations();
            LinkedList<Bag<Integer>> temp = a.generatePermutations((Bag)g.adj(v));
            adj2[i] = temp;
            System.out.println(i+""+ temp);
        }
    }
    public Graph2(int V)
    {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        adj2 = (LinkedList<Bag<Integer>>[]) new LinkedList[V];

        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Removes Edge from Graph
    public void removeEdge(int v, int w)
    {
        adj[v].remove(w);
        adj[w].remove(v);
    }


    public Iterable<Integer> adj(int v)
    { return adj[v]; }

    public LinkedList<Bag<Integer>> adj2(int v)
    { return adj2[v]; }

    public static void main(String[] args) {
        Graph2 g = new Graph2(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.generateBagVarations(g,0);
    }
}
