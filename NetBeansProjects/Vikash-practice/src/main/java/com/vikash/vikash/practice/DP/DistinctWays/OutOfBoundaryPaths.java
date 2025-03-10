package com.vikash.vikash.practice.DP.DistinctWays;

import java.util.Arrays;

/*
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells
in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary.
Since the answer can be very large, return it modulo 109 + 7.
 */
public class OutOfBoundaryPaths {

    int paths=0;
    public void findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        if(maxMove<0) return;
        if(startColumn>=n || startRow>=m || startColumn<0 || startRow<0)
        {
            paths++;
            return;
        }

        findPaths(m,n,maxMove-1, startRow-1, startColumn);
        findPaths(m,n,maxMove-1, startRow, startColumn-1);
        findPaths(m,n,maxMove-1, startRow, startColumn+1);
        findPaths(m,n,maxMove-1, startRow+1, startColumn);
    }




    public int findPathsMemo(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp=new int[maxMove][m][n];
        for(int[][] row: dp)
        {
            for(int[] col: row)
            {
                Arrays.fill(col, -1);
            }
        }
        return findPathsUtilMemoization(m,n,maxMove,startRow,startColumn,dp);
    }
    public int findPathsUtilMemoization(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp) {

        if(maxMove<0) return 0;
        if(startColumn>=n || startRow>=m || startColumn<0 || startRow<0)
        {
            return 1;
        }
        if(dp[maxMove][startRow][startColumn]!=-1) return dp[maxMove][startRow][startColumn];
        dp[maxMove][startRow][startColumn]=
                (findPathsUtilMemoization(m,n,maxMove-1, startRow-1, startColumn, dp)+
                findPathsUtilMemoization(m,n,maxMove-1, startRow, startColumn-1, dp)+
                findPathsUtilMemoization(m,n,maxMove-1, startRow, startColumn+1, dp)+
                findPathsUtilMemoization(m,n,maxMove-1, startRow+1, startColumn, dp))%100000007;
        return dp[maxMove][startRow][startColumn];
    }

    public static void main(String[] args) {
        OutOfBoundaryPaths outOfBoundaryPaths = new OutOfBoundaryPaths();
        outOfBoundaryPaths.findPathsMemo(1,3,3,0,1);
        System.out.println(outOfBoundaryPaths.paths);
    }
}
