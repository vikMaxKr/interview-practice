/*
Given a N x M grid. Find All possible paths from top left to bottom right.
From each cell you can either move only to right or down.
 */
package com.vikash.vikash.practice.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AllPossiblePaths {

    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n, int m, int[][] grid) {
        // code here
        boolean[][] visited = new boolean[n][m];

        ArrayList<ArrayList<Integer>> allPossiblePaths = new ArrayList<>();
        findPaths(0, 0, n, m, grid, allPossiblePaths, new ArrayList<>(), visited);
        allPossiblePaths.forEach(System.out::println);
        return allPossiblePaths;
    }

    private static void findPaths(int i, int j, int n, int m, int[][] grid, ArrayList<ArrayList<Integer>> allPossiblePaths,
                                  ArrayList<Integer> path, boolean[][] visited) {

        if (i == n - 1 && j == m - 1) {                                          //Add last block
            path.add(grid[i][j]);
            allPossiblePaths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        path.add(grid[i][j]);


        if(i<n-1) findPaths(i + 1, j, n, m, grid, allPossiblePaths, path, visited);
        if(j<m-1) findPaths(i, j + 1, n, m, grid, allPossiblePaths, path, visited);
        path.remove(path.size() - 1);    //backtrack
        visited[i][j] = false;

    }

    //----------------------------------------sum---------------------------------------------
    //-------------------------------------------------------------------------------------
    /*
     * Given a n x n matrix such that each of its cells contains some coins. Count the number of ways to collect exactly k coins 
     * while moving from top left corner of the matrix to the bottom right. From a cell (i, j), you can only move to (i+1, j) or (i, j+1).
     */

   static long numberOfPath(int n, int k, int[][] arr) {
        // code here
//        boolean[][] visited = new boolean[n][n];
//        long paths=numberPathUtil(0, 0, n, k, arr, visited, 0);
//        return  paths;
       // code here
       long[] res=new long[1];
       boolean[][] visited=new boolean[n][n];
       numberPathUtil(arr, k, 0, 0, 0, n, res, visited);
       return res[0];
    }

//    static private long findSumUtil(int x, int y, int n, int sum, int[][] arr, boolean[][] visited, int input) {
//
//        if (x >= n || y >= n) return 0;
//
//        if(visited[x][y]) return 0;
//
//        input += arr[x][y];
//
//        if (x == n - 1 && y == n - 1) {
//            return  input==sum?1:0;
//        }
//
//        visited[x][y]=true;
//
//        long x1=findSumUtil(x + 1, y, n, sum, arr, visited, input); // recursively call the path function for the cell below
//        long x2= findSumUtil(x, y + 1, n, sum, arr, visited, input); // recursively call the path function for the cell on the right
//        visited[x][y]=false;
//        return  x1+x2;
//    }

    private static void numberPathUtil(int[][] arr, int sum, int temp,
                                int i, int j, int n, long[] res, boolean[][] visited)
    {
        if(i==n-1 && j==n-1)
        {
            temp+=arr[i][j];
            if(sum==temp)
            {
                res[0]+=1L;
            }
            temp-=arr[i][j];
            return;
        }

        if(visited[i][j]) return;
        temp+=arr[i][j];

        if(i<n-1) numberPathUtil(arr, sum, temp, i+1, j, n, res, visited);
        if(j<n-1) numberPathUtil(arr, sum, temp, i, j+1, n, res, visited);
        visited[i][j]=false;
        temp-=arr[i][j];
    }



    public static void main(String[] args) {
       // 2 1 4 5 4   1 3 3 3 4    3 4 2 2 3    4 5 3 3 2   3 5 5 5 1
        int[][] grid = new int[][]{{2, 1, 4,5,4}, {1,3,3,3,4}, {3,4,2,2,3},{4,5,3,3,2},{3,5,5,5,1}};


    }
}
