/*
A Maze is given as n*n matrix of blocks where source block is the upper left most block i.e., matrix[0][0] and destination block is lower rightmost block i.e.,
 matrix[n-1][n-1]. A rat starts from source and has to reach the destination. The rat can move in only two directions: first forward if possible or down.
  If multiple solutions exist, the shortest earliest hop will be accepted. For the same hop distance at any point, forward will be preferred over downward.
  In the maze matrix, 0 means the block is the dead end and non-zero number means the block can be used in the path from source to destination.
  The non-zero value of mat[i][j] indicates number of maximum jumps rat can make from cell mat[i][j]. In this variation, Rat is allowed to jump multiple steps at
   a time instead of 1. Find a matrix which describes the position the rat to reach at the destination
 */

package com.vikash.vikash.practice.BackTrack;

import java.util.ArrayList;

public class RatInMazeMultipleJumps {

    //---------------------------------------------------This solution will give all paths in traversal----------------------------------------
    public int[][] ShortestDistance(int[][] matrix) {
        // Code here
        int n = matrix.length;
        int[][] visit = new int[n][n];
        int[][] res = new int[n][n];
        ArrayList<String> result = new ArrayList<>();
        res[0][0]=1;

        ArrayList<Integer> pathCounts=new ArrayList<>();
        findPathUtil(0, 0, matrix, n, "", result, visit,0, pathCounts);

        if(!result.isEmpty()){
            String path=getShortestPath(pathCounts, result);
            char[] value=path.toCharArray();
            for(int i=0;i<value.length-1;i+=2){
                res[value[i]-48][value[i+1]-48]=1;
            }
        }
        if(res[n-1][n-1] == 0){
            int [][] ans = new int[1][1];
            ans[0][0] = -1;
            System.out.println(ans[0][0]);
            return ans;
        }
        return res;
    }

    private String  getShortestPath(ArrayList<Integer> pathCounts, ArrayList<String> result) {

        int max=0;
        int index=0;
        String res;
        for(int i=0;i<pathCounts.size();i++){
            if(max<pathCounts.get(i)){
                max=pathCounts.get(i);
                index=i;
            }
        }
        res=result.get(index);
        return res;
    }

    // THIS APPROACH USING THE TRACK OF PATH TAKEN
    private static void findPathUtil(int x, int y, int[][] m, int n, String str, ArrayList<String> result, int[][] visit, int count,
                                     ArrayList<Integer> arr) {

        if (x == n - 1 && y == n - 1) {
            arr.add(count);            // add count
            result.add(str);          //add current path
            return;
        }

        if(!isSafe(x,y,m,visit,n)) return;

        int noSteps = m[x][y];
        visit[x][y] = 1;
        for (int step = 1; step <= noSteps && step<n; step++) {   // jumps from that index
            //RIGHT
            String ss=""+x+(y+step);
             System.out.println(ss);
            findPathUtil(x, y + step, m, n, str+ss, result,visit,count+step, arr);
            //DOWN
            ss=""+(x+step)+y;
             System.out.println(ss);
            findPathUtil(x + step, y, m, n, str+ss, result,visit,count+step, arr);
            visit[x][y] = 0;
        }
    }

    private static boolean isSafe(int x, int y,int[][] m, int[][] visit, int n)
    {
        if(x>=0 && x<n && y>=0 && y<n && visit[x][y]!=1 && m[x][y]!=0)  return true;
        return false;
    }

    //---------------------------------------This will return only shortest path----------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------------------------

    // Code here
    boolean isSafe(int x, int y, int [][] matrix){
        int n = matrix.length;
        return (x >= 0 && x < n && y >=0 && y < n && matrix[x][y] != 0);
    }

    // Recursive helper function to find the shortest distance from (0, 0) to (n-1, n-1) in the matrix.
    boolean helper(int x, int y, int [][] matrix, int [][] sol){
        int n = matrix.length;

        // If we have reached the destination (n-1, n-1), mark it as a valid path.
        if(x == n-1 && y == n-1){
            sol[x][y] = 1;
            return true;
        }

        // If we are at a safe position, mark it as a valid path and explore all possible steps.
        if(isSafe(x, y, matrix)){
            sol[x][y] = 1;

            // Explore all possible steps from the current position.
            for(int step = 1; step <= matrix[x][y] && step < n; step++){
                // Try moving right and check if it leads to a valid path.
                if(helper(x, y+step, matrix, sol))
                    return true;

                // Try moving down and check if it leads to a valid path.
                if(helper(x+step, y, matrix, sol))
                    return true;
            }

            // If no valid path is found, mark the current position as invalid and backtrack.
            sol[x][y] = 0;
            return false;
        }

        // If we are at an unsafe position, return false.
        return false;
    }

    public int[][] ShortestDistances(int[][] matrix)
    {
        int  n = matrix.length;
        int [][] sol = new int[n][n];
        // Call the helper function to find the shortest distance path from (0, 0) to (n-1, n-1).
        helper(0, 0, matrix, sol);

        // If no valid path is found, return a matrix with a single element indicating failure.
        if(sol[n-1][n-1] == 0){
            int [][] ans = new int[1][1];
            ans[0][0] = -1;
            return ans;
        }

        // Otherwise, return the solution matrix representing the shortest distance path.
        return sol;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[][]{{2,0,0,0},{3,0,0,1},{0,1,0,1},{0,0,0,1}};
        RatInMazeMultipleJumps r=new RatInMazeMultipleJumps();
        r.ShortestDistances(matrix);
    }

}
