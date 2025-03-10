/*
 * Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no 
elements without changing the order of the remaining elements.
 */
package com.vikash.vikash.practice.DP.DPString;

public class LongestPallindroneSequence {

    public int longestPalindromeSubseq(String s) {
        return DFS(s,0,s.length()-1);
    }

    private int DFS(String s, int start, int end)
    {
        if(start>end) return 0;

        if(start==end) return 1;

        if(s.charAt(start)==s.charAt(end))
        {
            return 2+DFS(s, start+1, end-1);
        }
        else{
            return Math.max(DFS(s, start+1,end), DFS(s, start, end-1));
        }
    }
    
}
