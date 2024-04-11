package org.UndirectedGraph;

public class DepthFirstPaths
{
    private  boolean[] marked;
    private  int[] edgeTo;
    private int s;
    private  Queue queue = new Queue();

    private int count = 0 ;
    public  int costPath = 0;

    public int getCostPath() {
        return costPath;
    }

    public void setCostPath(int costPath) {
        this.costPath = costPath;
    }

    public  Queue DepthFirstSearch(Graph G, int s)
    {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        dfs(G, s);

        return queue;
    }

    private  void dfs(Graph G, int v)
    {
        marked[v] = true;
        queue.enqueue(v);
        count++;
        for (int w : G.adj(v)){
            if (!marked[w])
            {
                if(count == G.getV()-1 )
                    costPath = costPath - Main2.getCost(v, w);

                    costPath += Main2.getCost(v, w);



                dfs(G, w);

                if(count == G.getV())
                    return;
                else {
                    costPath += Main2.getCost(v, w);
                    edgeTo[w] = v;
                    queue.enqueue(v);
                }
            }
        }


    }
}
