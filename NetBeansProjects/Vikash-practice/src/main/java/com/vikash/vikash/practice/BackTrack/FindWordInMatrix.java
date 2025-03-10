/*
 * Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent 
 * cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.
 */

package com.vikash.vikash.practice.BackTrack;

public class FindWordInMatrix {

    public boolean isWordExist(char[][] board, String word)
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(search(i, j, board, word, board.length, board[i].length, 0)) {

                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(int i, int j, char[][] board, String word, int n ,int m,int k) {  
      if (k==word.length()) return true;
      if(i>=n || j>=m || i<0 || j<0 || board[i][j]!=word.charAt(k)) return false;

      board[i][j] = '*';

      boolean i1=search(i+1,j,board,word,n,m,k+1);
      boolean i2=search(i-1,j,board,word,n,m,k+1);
      boolean i3=search(i,j+1,board,word,n,m,k+1);
      boolean i4=search(i,j-1,board,word,n,m,k+1);

      board[i][j] = word.charAt(k);                  //backtrack
      
      return i1 || i2 || i3 || i4;                   //If any above able to find String return true

    }

    public static void main(String[] args) {
        FindWordInMatrix findWordInMatrix = new FindWordInMatrix();
        char[][] board = new char[][]{{'a','g','b','c'},{'q','e','e','l'},{'g','b','k','s'}};
        System.out.println(findWordInMatrix.isWordExist(board,"geeks"));
    }
}
