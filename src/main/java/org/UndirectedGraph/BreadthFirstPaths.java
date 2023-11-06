package org.UndirectedGraph;

public class BreadthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;


    public boolean[] getMarked() {
        return marked;
    }

    public void setMarked(boolean[] marked) {
        this.marked = marked;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }

    public void setEdgeTo(int[] edgeTo) {
        this.edgeTo = edgeTo;
    }

    public int[] getDistTo() {
        return distTo;
    }

    public void setDistTo(int[] distTo) {
        this.distTo = distTo;
    }

    public void bfs(Graph G, int s) {
        Queue q = new Queue();
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        distTo = new int[G.getV()];
        q.enqueue(s);
        marked[s] = true;
        distTo[s] = 0;

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }
}