/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
 */
package com.vikash.vikash.practice.DP.MaxMin;

import java.util.ArrayList;
import java.util.Arrays;

public class MinFallingPathSum {


    //-------------------------------MEMOIZATION-----------------------------------------------------------------
    //------------------------------------------------------------------------------------
    public int minFallingPathSum(int[][] matrix) {
        int depth = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp=new int[depth+1][depth+1];
        for(int[] row: dp)
        {
            Arrays.fill(row, 200);
        }
        for(int i=0;i<matrix[0].length;i++){
            ans = Math.min(ans , solve(matrix,0,i,depth,dp));
            for(int[] row: dp)
            {
                Arrays.fill(row, 200);
            }
        }
        return ans;
    }
    public int solve(int [][] arr , int i , int j, int depth, int[][] dp)
    {
        if(i>=depth || j>=depth || j<0) return 200;
        int min = 200;

        if(dp[i][j]!=200) return dp[i][j];

        if(i+1 == depth)
        {
            return arr[i][j];
        }

        min = Math.min(min , arr[i][j] + solve(arr,i+1,j,depth, dp));
        min = Math.min( min , arr[i][j] + solve(arr,i+1,j+1,depth, dp));
        min = Math.min(min , arr[i][j] + solve(arr,i+1,j-1,depth, dp));
        dp[i][j]=min;

        return dp[i][j];
    }


    //-------------------------TABULATION-----------------------------------------------
    //---------------------------------------------------------------------------------
    public int minFallingPathSumTabulation(int[][] matrix) {
        int minValue=Integer.MAX_VALUE;
       int[][] dp=new int[matrix.length][matrix[0].length];
       for(int i=0;i<matrix.length;i++){
           dp[0][i]=matrix[0][i];
       }
       for(int i=1;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
               int upLeft=Integer.MAX_VALUE;
               int upRight=Integer.MAX_VALUE;
               int  up=dp[i-1][j];
               if(j>0) {
                   upLeft = dp[i - 1][j - 1];
               }if(j<matrix[i].length-1) {
                   upRight = dp[i - 1][j+1];
               }

               dp[i][j]=matrix[i][j]+Math.min(up,Math.min(upLeft,upRight));
               if(i<matrix.length-1 && j<matrix[i].length-1) {
                   minValue=Math.min(minValue,dp[i][j]);
               }

           }
       }
       return minValue;
    }
}
