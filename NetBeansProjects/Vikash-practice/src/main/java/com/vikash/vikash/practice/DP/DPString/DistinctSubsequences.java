/*
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
Input: txt = banana, pat = ban
Output: 3
Explanation: pat appears in txt as below three subsequences.
[ban], [ba  n], [b   an]

The test cases are generated so that the answer fits on a 32-bit signed integer.
 */

//INTUITION:-
/*
We can easily identify the recursive nature of this problem. For each character in the pattern, we can either choose to include it in our subsequence or ignore it.
If we match the current character in the pattern with the current character in the text, we have two options:
 we can either include this character and move to the next character in both the pattern and the text, or we can skip the current character in the text
 and try to match the same character in the pattern with the next character in the text.


 */


package com.vikash.vikash.practice.DP.DPString;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubsequences {

    int count=0;
    public int numDistinct(String s, String t) {
        subCountRec(s.length(), t.length(), s, t);
        return count;
    }

    static int subCountRec(int i, int j, String txt, String pat) {
        if (j == 0) {

            // Empty pattern is found in all suffixes
            return 1;
        }

        if (i == 0) {

            // No more characters in txt to match pat
            return 0;
        }

        if (txt.charAt(i - 1) == pat.charAt(j - 1)) {

            // Count both cases
            return subCountRec(i - 1, j - 1, txt, pat)  +  //take
                    subCountRec(i - 1, j, txt, pat);         //skip
        }

        return subCountRec(i - 1, j, txt, pat);
    }
    

    // DP + Memoization
    private int solveMemo(String s, int idx, String t, int t_idx, int[][] dp) {
        // Base Case
        if (t_idx >= t.length())
            return 1;
        if (idx >= s.length())
            return 0;

        // step-2 => if already calculate just return it
        if (dp[idx][t_idx] != -1) {
            return dp[idx][t_idx];
        }

        // step-3 => if not calculate just calculate it and then return it

        // case when character are equal we take it
        if (s.charAt(idx) == t.charAt(t_idx)) {
            dp[idx][t_idx] = solveMemo(s, idx + 1, t, t_idx + 1, dp) + solveMemo(s, idx + 1, t, t_idx, dp);
            return dp[idx][t_idx];
        }

        // case when character aren't equal
        return dp[idx][t_idx] = solveMemo(s, idx + 1, t, t_idx, dp);
    }



    //FIND ALL DISTINCT SUBSEQUENCES OF A STRING
    public int distinctSubsequence(String s) {
       Set<String> set=new HashSet<>();
       subsequence(set,s, "", 0, s.length());
       System.out.println(set.size());
       return set.size();
    }

    private void subsequence(Set<String> set, String s, String temp, int i, int length) {

        if(i==length)
        {
            System.out.println(temp);
            set.add(temp);
            return;
        }
        temp+=s.charAt(i);
        subsequence(set, s, temp, i+1, length);
        temp=temp.substring(0, temp.length()-1);
        subsequence(set, s, temp, i+1, length);
    }


    public static void main(String[] args)
    {
        DistinctSubsequences distinctSubsequences=new DistinctSubsequences();
        //distinctSubsequences.numDistinct("banana", "ban");
        distinctSubsequences.distinctSubsequence("gfg");
       // distinctSubsequences.calcRecursive(null, null, 0, 0, null);
    }
}
