package com.vikash.vikash.graph;

public class AddDeleteNode {

    class AdjNode{
        int v;
        AdjNode next;
        public AdjNode(int v)
        {
            this.v=v;
            this.next=null;
        }
    }

    int vertex;
    AdjNode[]  graph;
    public AddDeleteNode(int size)
    {
        vertex=size;
        graph=new AdjNode[size];
        for(int i=0; i<size; i++)
        {
            graph[i]=null;
        }
    }


    void addVertex(int source, int destination)
    {
        AdjNode node=new AdjNode(destination);
        node.next= graph[source];
        graph[source]=node;

    }

    void addEdges(int vk, int source, int destination)
    {
        addVertex(source, vk);
        addVertex(vk, destination);
    }

    void deleteVertex(int v)
    {
        for(int i=0; i<vertex; i++)
        {
            AdjNode curr=graph[i];
            AdjNode prev=null;
            if(i==v) graph[i]=null;
            else{
                while(curr!=null) {

                    if(curr.v==v)
                    {
                        if(prev==null)
                        {
                            graph[i]=curr.next;
                        }
                        else{
                            prev.next=curr.next;
                        }
                    }
                    prev=curr;
                    curr=curr.next;
                }
            }
        }
    }


    // Function to print the graph
    public void printGraph()
    {
        for (int i = 0; i < vertex; ++i) {
            System.out.print(i + " ");
            AdjNode temp = graph[i];
            while (temp != null) {
                System.out.print("-> " + temp.v + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AddDeleteNode addDeleteNode =new AddDeleteNode(7);
        addDeleteNode.addVertex(0, 1);
        addDeleteNode.addVertex(0, 3);
        addDeleteNode.addVertex(0, 4);
        addDeleteNode.addVertex(1, 2);
        addDeleteNode.addVertex(3,2);
        addDeleteNode.addVertex(4,3);

        System.out.println("before add-edge");
        addDeleteNode.printGraph();
        addDeleteNode.addEdges(5, 3,4);
        addDeleteNode.addEdges(6, 1,3);
        System.out.println("before delete");
        addDeleteNode.printGraph();

        addDeleteNode.deleteVertex(3);

        System.out.println("after delete");
        addDeleteNode.printGraph();
    }
}
