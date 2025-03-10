/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
 */
package com.vikash.vikash.practice.DP.MaxMin;

import java.util.Arrays;

public class MinPathsum {
     int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        return findSumUtil(0,0,n,m,grid,0);
    }

    //-------RECURSION -------------------------
    private int findSumUtil(int x, int y, int n,int m, int[][] arr, int input) {

        if (x >= m || y >= n) return Integer.MAX_VALUE;

        input += arr[x][y];

        if (x == m - 1 && y == n - 1) {
            return  input;
        }

        int x1=findSumUtil(x + 1, y, n, m, arr, input); // recursively call the path function for the cell below
        int x2= findSumUtil(x, y + 1, n, m, arr, input); // recursively call the path function for the cell on the right

        return  Math.min(x1,x2);
    }

    //---------------MEMOIZATION--------------------------------------
    //---------------------------------------------------------------
    public int minPathSumDP(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int[] dd: dp)
        {
            Arrays.fill(dd, -1);
        }
        return findMinPathSum(grid,m-1,n-1,dp);
    }

    private int findMinPathSum(int[][] grid,int row,int col,int[][] dp)
    {
        if(row==0 && col==0) return grid[0][0];
        if(dp[row][col]!=-1) return dp[row][col];
        int right=Integer.MAX_VALUE;
        int down=Integer.MAX_VALUE;
        if(row>0)
        {
            right=grid[row][col]+findMinPathSum(grid,row-1,col,dp);
        }
        if(col>0)
        {
            down=grid[row][col]+findMinPathSum(grid,row,col-1,dp);
        }

        return dp[row][col]=Math.min(right,down);
    }


    //---------------------tabulation---------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    public int minPathSumTabulation(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] dd: dp)
        {
            Arrays.fill(dd, -1);
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==j && i==0)
                {
                    dp[i][j]=grid[i][j];
                    continue;
                }
                int down=Integer.MAX_VALUE;
                int right=Integer.MAX_VALUE;
                if(i>0)
                {
                    down=dp[i-1][j]+grid[i][j];
                }
                if(j>0)
                {
                    right=dp[i][j-1]+grid[i][j];
                }

                dp[i][j]=Math.min(down,right);
            }
        }
        return dp[m-1][n-1];
    }

}
