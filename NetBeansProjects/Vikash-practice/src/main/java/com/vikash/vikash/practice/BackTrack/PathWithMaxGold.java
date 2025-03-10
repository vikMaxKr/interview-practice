/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 */

package com.vikash.vikash.practice.BackTrack;

import java.util.Arrays;

public class PathWithMaxGold {
    
    public int getMaximumGold(int[][] grid) {
        
        int max=0;
        
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]!=0)
                {
                    max=Math.max(max,getMaxGold(i,j,grid,grid.length, grid[i].length));
                    System.out.println("complete-----");
                }
            }
        }
        
        return max;
        
}

    private int getMaxGold(int i, int j, int[][] grid, int n, int m) {

        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0) return 0;

        int t=grid[i][j];
        grid[i][j]=0;

        int a=getMaxGold(i+1,j,grid,n,m);
        int b=getMaxGold(i-1,j,grid,n,m);
        int c= getMaxGold(i,j+1,grid,n,m);
        int d= getMaxGold(i,j-1,grid,n,m);

        grid[i][j]=t;     //backtrack

        System.out.println("a--"+a);
        System.out.println("b--"+b);
        System.out.println("c--"+c);
        System.out.println("d--"+d);

        int max=Math.max(Math.max(a,b),Math.max(c,d));
        return max+grid[i][j];

    }

    public static  void main(String[] args)
    {
        PathWithMaxGold path=new PathWithMaxGold();
        int[][] grid=new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        path.getMaximumGold(grid);
    }
}
