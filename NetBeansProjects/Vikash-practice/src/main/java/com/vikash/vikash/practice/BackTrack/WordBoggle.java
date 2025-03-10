/*
 * Given a dictionary of distinct words and an M x N board where every cell has one character. 
 * Find all possible words from the dictionary that can be formed by a sequence of adjacent characters on the board.
 *  We can move to any of 8 adjacent characters
Note: While forming a word we can move to any of the 8 adjacent cells. A cell can be used only once in one word.
 */

package com.vikash.vikash.practice.BackTrack;
import java.util.*;
public class WordBoggle {

    public String[] wordBoggles(char board[][], String[] dictionary)
    {
        // Write your code here

        ArrayList<String> res= new ArrayList<>();
        for (String s : dictionary) {
            if (isBoggle(board, s)) {
                res.add(s);
            }
        }

        String[] result=new String[res.size()];
        return res.toArray(result);
    }

    public boolean isBoggle(char[][] board, String word)
    {
        int M=board.length;
        int N=board[0].length;
        boolean[][] visited =new boolean[M][N];
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(board[i][j]==word.charAt(0)){
                if(isBoggleUtil(board, word,i, j,visited,0))
                {
                    return true;
                }
            }
            }
        }
        return false;
    }

    private boolean isBoggleUtil(char board[][] , String word, int i, int j , boolean visited[][], int count)
    {
         if(count==word.length()) return true;

         if(i>=0 && i<board.length && j>=0 && j<board[0].length && !visited[i][j] && word.charAt(count)==board[i][j])
         {
            visited[i][j]=true;

            if(isBoggleUtil(board, word, i+1, j, visited,count+1)
             || isBoggleUtil(board, word, i, j+1, visited, count+1)
             || isBoggleUtil(board, word, i-1, j, visited,count+1)
             || isBoggleUtil(board, word, i, j-1, visited,count+1)
             || isBoggleUtil(board, word, i-1, j-1, visited,count+1)
             || isBoggleUtil(board, word, i+1, j+1, visited,count+1)
             || isBoggleUtil(board, word, i+1, j-1, visited,count+1)
             || isBoggleUtil(board, word, i-1, j+1, visited,count+1)){
                return true;
             }
             visited[i][j]=false;
         }
        return false;

    }

    // Driver program to test above function
    public static void main(String[] args) {
        String[] dictionarys = { "GEEKS", "FOR", "QUIZ", "GO" };
        char[][] boggle = {
                { 'G', 'I', 'Z' },
                { 'U', 'E', 'K' },
                { 'Q', 'S', 'E' }
        };
        WordBoggle wordBoggle=new WordBoggle();
        wordBoggle.wordBoggles(boggle, dictionarys);
    }
}