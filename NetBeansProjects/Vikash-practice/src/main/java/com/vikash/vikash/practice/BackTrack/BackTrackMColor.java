package com.vikash.vikash.practice.BackTrack;

import java.util.Arrays;

/*
Given an undirected graph and an integer M. The task is to determine if the graph can be colored with
at most M colors such that no two adjacent vertices of the graph are colored with the same color.
Here coloring of a graph means the assignment of colors to all vertices. 
Print 1 if it is possible to colour vertices and 0 otherwise.
*/
public class BackTrackMColor {
    
    public static void main(String[] args)
    {
       // Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
        boolean[][] edges=new boolean[3][3];
        edges[0][1]=true;
        edges[1][2]=true;
        edges[0][2]=true;
        edges[1][0]=true;
        edges[2][0]=true;
        edges[2][1]=true;
        BackTrackMColor backTrack=new BackTrackMColor();
        System.out.println(backTrack.graphColoring(edges, 2, 3));
    }
    
        public boolean graphColoring(boolean graph[][], int maxColor, int node) {
            int[] color=new int[node];
            Arrays.fill(color,-1); 
          return coloring(graph, maxColor, node , 0, color);
    }
    
        private boolean coloring(boolean graph[][], int maxColor,int node,int index, int[] color)
        {
            if(index==node) return true;      //Reached node limit
            
            for(int i=0;i<maxColor;i++)     //loop till max-color  ...representing color as 0,1,2...maxColor-1
            {
                if(safeToAssign(i,index,node,graph,color))          //If safe to assign color i to node 
                {
                    color[index]=i;
                    System.out.println("before recursion-----"+i);
                   if(coloring(graph, maxColor, node, index+1, color)) 
                   {
                       return true;
                   }
                   color[index]=-1;     //backtrack if not able to assign color
                   System.out.println("afer recursion-----"+color[index]);
                }
             }
            return false;
        }
        
        private boolean safeToAssign(int i, int index, int node , boolean graph[][],int[] temp)
        {
            //checking if i can assign color at index
            //no other neighbouring should have same color
            for(int k=0;k<node;k++)
            {
                if(graph[index][k] && temp[k]==i) return false;
            }
            return true;
        }
}