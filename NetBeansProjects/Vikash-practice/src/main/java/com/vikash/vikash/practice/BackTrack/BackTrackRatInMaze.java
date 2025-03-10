package com.vikash.vikash.practice.BackTrack;
import java.util.*;
/**
 Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1).
 Find all possible paths that the rat can take to reach from source to destination.
 The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is
 blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
 Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.
 */
public class BackTrackRatInMaze {
    static int[][] visit=new int[5][5];
    
    // D L R U
 //-----------above is not working for all tests--------------------------------------------------------------------
   static int[][] visited=new int[5][5];
   static ArrayList<String> results=new ArrayList<>();
   
   public static ArrayList<String> findPaths(int[][] m, int n) {
        try {
            for(int i=0;i<5;i++) {
                Arrays.fill(visited[i], 0);
            }// initialize the visited array with 0
        } catch (ArrayStoreException ex) {
        }
        results.clear(); // clear the result list
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) { // if the top-left or bottom-right cell is blocked
            return results; // return an empty result list
        }

        findPathUtil(0, 0,m,n,""); // start finding paths from the top-left cell
        Collections.sort(results); // sort the result list lexicographically
        return results; // return the sorted result list
    }

 private static void findPathUtil(int x, int y,int[][] m, int n,String dir)
 {
     if (x == n - 1 && y == n - 1) { // if we reached the bottom-right corner of the matrix
            results.add(dir); // add the current direction to the path list
            return; // exit the recursive function
        }

        if (m[x][y] == 0 || visited[x][y] == 1) { // if the current cell is blocked or already visited
            return; // exit the recursive function
        }

        visited[x][y] = 1; // mark the current cell as visited
        if (x > 0) {
            findPathUtil(x - 1, y,m, n,dir + 'U'); // recursively call the path function for the cell above
        }
        if (y > 0) {
            findPathUtil(x, y - 1,m,n, dir + 'L'); // recursively call the path function for the cell on the left
        }
        if (x < n - 1) {
            findPathUtil(x + 1, y,m,n, dir + 'D'); // recursively call the path function for the cell below
        }
        if (y < n - 1) {
            findPathUtil(x, y + 1,m,n, dir + 'R'); // recursively call the path function for the cell on the right
        }
        visited[x][y] = 0; // mark the current cell as unvisited after backtracking

 }

 //--------------------------------------------------------------------------------------------------------------------------------------
    /*
    Given an N x M matrix, with a few hurdles(denoted by 0) arbitrarily placed, calculate the length of the longest possible route possible from source(xs,ys)
     to a destination(xd,yd) within the matrix. We are allowed to move to only adjacent cells which are not hurdles. The route cannot contain any diagonal
     moves and a location once visited in a particular path cannot be visited again.If it is impossible to reach the destination from the source return -1.
     */


 public static int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
     boolean[][] visited=new boolean[n][m];
     List<Integer> result=new ArrayList<>();
     if(xs<0 || ys<0 || xd>n || yd>m) return -1;

     if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
         return -1;
     }

     findPathUtil(xs,ys,xd,yd,0,mat,visited,result); // start finding paths from the top-left cell
      return result.isEmpty()?-1:result.get(0);
 }

    private static void findPathUtil(int x, int y,int xd, int yd, int move, int[][] m, boolean[][] visited, List<Integer> result)
    {

        if (x == xd && y == yd) {   // if we reached the bottom-right corner of the matrix
            if(!result.isEmpty())
            {
                if(result.get(0)>move) return;
                result.clear();
                result.add(move);
            }else {
                result.add(move);
            }
            return; // exit the recursive function
        }

        if(m[x][y]==0 || visited[x][y]) return;

        visited[x][y] = true; // mark the current cell as visited

        if (x>0) {
            findPathUtil(x - 1, y, xd, yd, move+1, m, visited, result); // recursively call the path function for the cell above
        }
        if (y>0) {
            findPathUtil(x, y - 1, xd, yd, move+1, m, visited, result); // recursively call the path function for the cell on the left
        }
        if (x<m.length-1) {
            findPathUtil(x + 1, y, xd, yd, move+1, m,visited, result); // recursively call the path function for the cell below
        }
        if (y<m[0].length-1) {
            findPathUtil(x, y + 1,xd, yd, move+1, m,visited, result); // recursively call the path function for the cell on the right
        }
        visited[x][y] = false; // mark the current cell as unvisited after backtracking

    }


//   static boolean isSafeVisit(int x, int y , int[][] mat,boolean[][] visited)
//    {
//        int n=mat.length;
//        int m=mat[0].length;
//        if(x>=0 && y>=0 && x<n && y<m && mat[x][y]!=0 && !visited[x][y]) return true;
//        return false;
//    }

    public static void main(String[] args)
    {
        int[][] m=new int[][]{{1,1},{1,1},{1,1,},{1,1}};
        //findPath(m,3);
        int[][] mat=new int[][]{{1,1,1,1,1,1,1,1,1,1},{1,1,0,1,1,0,1,1,0,1},{1,1,1,1,1,1,1,1,1,1}};
        longestPath(mat,mat.length,mat[0].length,0,0,1,7);
    }
}

