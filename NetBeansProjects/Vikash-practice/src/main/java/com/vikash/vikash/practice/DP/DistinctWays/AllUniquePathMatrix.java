/*
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any 
 * point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */

package com.vikash.vikash.practice.DP.DistinctWays;

import java.util.Arrays;

public class AllUniquePathMatrix {

    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for(int[] row: cache)
        {
          Arrays.fill(row, -1);
        }
      return findPaths(0,0,m,n,cache);
   }
       private int findPaths(int i, int j, int n, int m, int[][] cache) {

        if (i == n - 1 && j == m - 1) {                                          //Add last block
            return 1;
        }

       if(cache[i][j]!=-1) return cache[i][j];

       int left=0;
       int right=0;

        if(i<n-1) {
            left = findPaths(i + 1, j, n, m, cache);
        }
        if(j<m-1) {
            right = findPaths(i, j + 1, n, m, cache);
        }
        
        cache[i][j]=left+right;

        return cache[i][j];

    }






    //-----------------------------------------------------------------------------------------------------
    /*
     * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). 
     * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any
     *  point in time.

    An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     */



    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] cache = new int[n][m];
        for(int[] row: cache)
        {
          Arrays.fill(row, -1);
        }
      return findPathsObstacle(0,0,n,m,cache,obstacleGrid);
    }

    private int findPathsObstacle(int i, int j, int n, int m, int[][] cache, int[][] obstacleGrid) {

        if(i>n || j>m) return 0;

        if (i == n - 1 && j == m - 1) {                                          //Add last block
            return 1;
        }

       if(cache[i][j]!=-1) return cache[i][j];

       int left=0;
       int right=0;

        if(i<n-1 && obstacleGrid[i][j]!=1)
        left=findPathsObstacle(i + 1, j, n, m, cache,obstacleGrid);
        if(j<m-1 && obstacleGrid[i][j]!=1)
        right=findPathsObstacle(i, j + 1, n, m, cache, obstacleGrid);
        
        cache[i][j]=left+right;

        return cache[i][j];
    }
    public static void main(String[] args)
    {
        int[][] obs=new int[][]{{0,0}};
        AllUniquePathMatrix allUniquePathMatrix=new AllUniquePathMatrix();
        allUniquePathMatrix.uniquePathsWithObstacles(obs);
        //allUniquePathMatrix.uniquePaths(2, 2);
    }
    
}
