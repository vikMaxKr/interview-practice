/*
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 */
package com.vikash.vikash.practice.DP.DPString;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1.equals("") && word2.equals("")) return 0;
           int n=word1.length();
           int m=word2.length();
           int[][] dp=new int[n][m];
           for(int[] d:dp){
               Arrays.fill(d,-1);
           }
           return f(n-1,m-1,word1,word2,dp);
       }
       int f(int index1,int index2,String s1,String s2,int[][] dp){
   
           if(index1<0 )return index2+1;
           
           if(index2<0 )return index1+1;
          
           if(dp[index1][index2]!=-1){
               return dp[index1][index2];
           }
           
   
           if(s1.charAt(index1)==s2.charAt(index2)){
               return dp[index1][index2]=f(index1-1,index2-1,s1,s2,dp);
           }else{
                int insert=1+f(index1,index2-1,s1,s2,dp);
               int delete=1+f(index1-1,index2,s1,s2,dp);
               int replace=1+f(index1-1,index2-1,s1,s2,dp);
              return dp[index1][index2]=Math.min(insert,Math.min(delete,replace));
           }
           
       }
}
