package org.UndirectedGraph.GraphHMW2;

public class DepthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private Queue queue = new Queue();
    public DepthFirstPaths(Graph2 G, int s)
    {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];

        queue.enqueue(s);
        dfs(G, s);

    }

    private void dfs(Graph2 G, int v)
    {
        marked[v] = true;
        queue.enqueue(v);

        for (int w : G.adj(v))
            if (!marked[w])
            {
                dfs(G, w);
                edgeTo[w] = v;
            }
    }
}