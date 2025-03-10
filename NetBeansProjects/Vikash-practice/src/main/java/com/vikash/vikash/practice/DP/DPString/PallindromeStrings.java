/*
 * Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
 */
package com.vikash.vikash.practice.DP.DPString;

import java.util.Arrays;

public class PallindromeStrings {

        public int countSubstrings(String s) {
            int count=0;
            int n=s.length();
            int[][] dp=new int[n][n];
            for(int[] row: dp)
            {
                Arrays.fill(row, -1);
            }
            for(int i=0;i<n;i++)
            {
                StringBuilder str=new StringBuilder();
                for(int j=i;j<n;j++)
                {
                    int res=subStringUtil(s, i, j,dp, str);
                    count+=res==-1?0:res;
                    System.out.println("---string----"+str.toString());
                }
            }
            return count;   
        }
         
        private int subStringUtil(String s, int i, int j, int[][] dp,StringBuilder sb) {

            if(i>j) return 1;

            if(dp[i][j]!=-1) {
                return dp[i][j];
            }

            if(s.charAt(i)==s.charAt(j))
            {
                int temp=subStringUtil(s, i, j-1, dp, sb);
                if(temp==-1) return -1;
                else {
                        sb.append(s.charAt(j));
                    return dp[i][j]=temp;
                }
            }
            else{
               return dp[i][j]=-1;
            }
        }



        public static void main(String[] args)
        {
            PallindromeStrings pallindromeStrings=new PallindromeStrings();
            pallindromeStrings.countSubstrings("babad");
        }
    
}
