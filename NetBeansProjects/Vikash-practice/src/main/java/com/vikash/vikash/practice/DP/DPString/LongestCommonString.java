/*
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 * 
 * ----------APPROACH-------------
 * 
 * 
 */
package com.vikash.vikash.practice.DP.DPString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LongestCommonString {

      //Print all LCS
    Set<String> st=new TreeSet<>();
    int ans=Integer.MIN_VALUE;
    public int longestCommonSubString(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
         calc(text1,text2,text1.length(),text2.length(),dp);
         printAllLCS(text1, text2, text1.length(), text2.length(), dp, "",  ans);
         st.forEach(System.out::println);
         return ans;
          
      }

      int calc(String t1, String t2, int l1, int l2,int[][] dp)
      {
          if(l1==0 || l2==0) return 0;
  
          if(dp[l1][l2]!=-1) return dp[l1][l2];


          //If both equals find maximum length string common to both
          int pos=0;
          if(t1.charAt(l1-1)==t2.charAt(l2-1))
          {
              pos= 1+calc(t1,t2,l1-1,l2-1,dp);
          }
        
            ans=Math.max(pos, ans);

            //else move ahead to search next with pos==0
            calc(t1,t2,l1-1,l2,dp);
            calc(t1,t2,l1,l2-1,dp);
            return dp[l1][l2]=pos;
      }

      //------------------------------Print all subStrings
      Map<String, List<String>> memo=new HashMap<>();
      private void printAllLCS(String s1, String s2, int i, int j, int[][] dp , String ans, int maxLength)
      {
        if(!ans.isEmpty() && ans.length()==maxLength)
        {
            st.add(new StringBuilder(ans).reverse().toString());
        }
        if (i == 0 || j == 0) {
            return;
        }
        String key=i+","+j+ans;

        if(memo.containsKey(key))
        {
            st.addAll(memo.get(key));
            return ;
        }

        Set<String> localSet=new TreeSet<>();
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            printAllLCS(s1, s2, i-1, j-1,dp,ans + s1.charAt(i - 1), maxLength);
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                printAllLCS(s1, s2, i-1, j,dp, "", maxLength);
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                printAllLCS(s1, s2, i, j-1, dp, "", maxLength);
            }
        }
        localSet.add(ans);
        memo.put(key,new ArrayList<>(localSet));
    }

      public static void main(String[] args)
      {
          LongestCommonString longestCommonString=new LongestCommonString();
          System.out.println(longestCommonString.longestCommonSubString("abcdeaf", "abceaf"));
      }
      
    
    }