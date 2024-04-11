package org.UndirectedGraph;


public class Graph2
{
    private final int V;
    private Bag2<Integer>[] adj;

    public int getV() {
        return V;
    }

    public Graph2(int V)
    {
        this.V = V;
        adj = (Bag2<Integer>[]) new Bag2[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag2<Integer>();
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
}
