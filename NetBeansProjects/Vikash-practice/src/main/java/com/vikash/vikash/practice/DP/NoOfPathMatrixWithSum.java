package com.vikash.vikash.practice.DP;

/*
Given a n x n matrix such that each of its cells contains some coins. Count the number of ways to collect exactly k coins while moving from top left corner
 of the matrix to the bottom right. From a cell (i, j), you can only move to (i+1, j) or (i, j+1).
 */
public class NoOfPathMatrixWithSum {

    private long total = 0;

    public static void main(String[] args) {
        NoOfPathMatrixWithSum np = new NoOfPathMatrixWithSum();
        int[][] arr = new int[][]{{1, 1}, {1, 1}};
        np.numberOfPath(2, 3, arr);
    }

    long numberOfPath(int n, int k, int[][] arr) {
        // code here
        boolean[][] visited = new boolean[n][n];
        long paths=findSumUtil(0, 0, n, k, arr, visited, 0);
        System.out.println(paths);
        return  paths;
    }

    private long findSumUtil(int x, int y, int n, int sum, int[][] arr, boolean[][] visited, int input) {

        if (x >= n || y >= n) return 0;

        input += arr[x][y];

        if (x == n - 1 && y == n - 1) {
           return  input==sum?1:0;
        }

        long x1=findSumUtil(x + 1, y, n, sum, arr, visited, input); // recursively call the path function for the cell below
       long x2= findSumUtil(x, y + 1, n, sum, arr, visited, input); // recursively call the path function for the cell on the right

        return  x1+x2;
    }
}
