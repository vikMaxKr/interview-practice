package com.vikash.vikash.graph;

import java.util.Vector;

public class AddDeleteEdge {

    static void addEdge(Vector<Integer>[] adj, int i, int j)
    {
        adj[i].add(j);
        adj[j].add(i);
    }

    static void delEdge(Vector<Integer>[] adj, int source, int dest)
    {
        for(int i=0; i<adj[source].size();i++)
        {
            if(adj[source].get(i)==dest)
            {
                adj[source].remove(i);
            }
        }

        for(int i=0; i<adj[dest].size(); i++)
        {
            if(adj[dest].get(i)==source)
            {
                adj[dest].remove(i);
            }
        }
    }

    static void printStack(Vector<Integer>[] adj)
    {
        for(int i=0;i<adj.length;i++)
        {
            for(int j : adj[i])
            {
                System.out.print(" "+j);
            }
        }

    }

    public static void main(String[] args) {
        int vertex=6;
        Vector<Integer>[] adj=new Vector[vertex];

        for(int i=0; i<vertex; i++)
        {
            adj[i]=new Vector<>();
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        System.out.println("before delete");
        printStack(adj);

        delEdge(adj, 1, 4);

        System.out.println(" after delete");
        printStack(adj);
    }
}
