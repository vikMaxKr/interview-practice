/*
Given an m x n binary matrix filled with 0's and 1's,
find the largest square containing only 1's and return its area.
 */

package com.vikash.vikash.practice.DP.MaxMin;

import java.util.Arrays;

public class MaximalSquare {


    //----------------------MEMOIZATION-------------------------------
    int max=0;
    public int maximalSquare(char[][] matrix) {
        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        int result=calcMaximalSquare(matrix,0,0, dp);
        return result*result;
    }
    int calcMaximalSquare(char[][] matrix, int row, int col, int[][] dp)
    {
        if(row>=matrix.length || col>=matrix[row].length) return 0;

        if(dp[row][col]!=-1) return dp[row][col];

        int right=calcMaximalSquare(matrix,row,col+1, dp);
        int diagonal=calcMaximalSquare(matrix,row+1,col+1, dp);
        int down=calcMaximalSquare(matrix,row+1,col, dp);

        if(matrix[row][col]=='1')
        {
            int tt=Math.min(right,Math.min(diagonal,down))+1;
            max=Math.max(max,tt);
            dp[row][col]=max;
        }
        else{
            dp[row][col]=0;
        }

        return  dp[row][col];
    }


    //--------------------TABULATION---------------------
    public int maximalSquareTabulation(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              if(i==0 || j==0){
                  if(matrix[i][j]=='1') {
                      dp[i][j]=1;
                      result=Math.max(result, dp[i][j]);
                  }
              }
              else{
                  if(matrix[i][j]=='1') {
                      dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
                      result=Math.max(result, dp[i][j]);
                  }

              }
            }
        }
        return result*result;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalSquare.maximalSquare(matrix);
    }
}
