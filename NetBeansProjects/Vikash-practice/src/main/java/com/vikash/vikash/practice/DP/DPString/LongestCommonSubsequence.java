/*
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */
package com.vikash.vikash.practice.DP.DPString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import javax.security.auth.kerberos.KerberosCredMessage;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
        return calc(text1,text2,text1.length(),text2.length(), dp);
          
      }
  
      int calc(String t1, String t2, int l1, int l2, int[][] dp)
      {
          if(l1==0 || l2==0) return 0;
  
          if(dp[l1][l2]!=-1) return dp[l1][l2];
  
          if(t1.charAt(l1-1)==t2.charAt(l2-1))
          {
               return dp[l1][l2] = 1+calc(t1,t2,l1-1,l2-1,dp);
          }
          else
          {
              dp[l1][l2] = Math.max(calc(t1,t2,l1-1,l2,dp),calc(t1,t2,l1,l2-1,dp));
              return dp[l1][l2];
          }
      }

    //count total LCS
    // Function to count all LCS of maximum length
    private static Map<String, Integer> memoCount = new HashMap<>();
    private static int countLCS(String s1, String s2, int m, int n, int[][] dp) {
        String key = m + "|" + n;
        if (memoCount.containsKey(key)) {
            return memoCount.get(key);
        }

        if (m == 0 || n == 0) {
            return 1;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memoCount.put(key, countLCS(s1, s2, m - 1, n - 1, dp));
        } else {
            int count = 0;
            if (dp[m - 1][n] >= dp[m][n - 1]) {
                count += countLCS(s1, s2, m - 1, n,dp);
            }
            if (dp[m][n - 1] >= dp[m - 1][n]) {
                count += countLCS(s1, s2, m, n - 1,dp);
            }
            memoCount.put(key, count);
        }
        return memoCount.get(key);
    }



    //Print all LCS
      int count=0;
      private Set<String> st = new TreeSet<>();

      public int printAllLCS(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
        int res=calc(text1,text2,text1.length(),text2.length(), dp);
        helper(dp,text1.length(),text2.length(),text1, text2,"");
        st.stream().forEach(System.out::println);
        System.out.println(count);
        return res;
          
      }

    private Map<String, List<String>> memo = new HashMap<>();  //memoization to handle Time limit
      private void helper(int[][] dp, int i, int j, String s, String t, String ans) {
        if (i == 0 || j == 0) {
            if (!ans.isEmpty()) {
                count++;
                st.add(new StringBuilder(ans).reverse().toString());
            }
            return;
        }
        
       String key = i + "," + j + "," + ans;
        if (memo.containsKey(key)) {
            count++;
            st.addAll(memo.get(key));
            return;
        }

        Set<String> localSet = new TreeSet<>();
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            helper(dp, i - 1, j - 1, s, t, ans + s.charAt(i - 1));
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                helper(dp, i - 1, j, s, t, ans);
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                helper(dp, i, j - 1, s, t, ans);
            }
        }
        localSet.addAll(st);
        memo.put(key, new ArrayList<>(localSet));
    }


      public static void main(String[] args)
      {
        //abaabaaaaa aabbaaaaaabb
        LongestCommonSubsequence longestCommonSubsequence=new LongestCommonSubsequence();
        //longestCommonSubsequence.longestCommonSubsequence("abaaa", "baabaca");
        longestCommonSubsequence.printAllLCS("rabbbit", "rabbit");
      }

    
}
