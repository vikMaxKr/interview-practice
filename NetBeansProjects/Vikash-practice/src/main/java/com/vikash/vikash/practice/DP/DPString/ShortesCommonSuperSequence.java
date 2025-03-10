package com.vikash.vikash.practice.DP.DPString;

/*
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
If there are multiple valid strings, return any of them.
Input: str1 = "abac", str2 = "cab"
Output: "cabac"
 */
import java.util.Arrays;


public class ShortesCommonSuperSequence {
    public String shortestCommonSupersequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
       for(int[] row: dp)
       {
           Arrays.fill(row, -1);
       }
       calcSuperSeq(text1,text2,text1.length(),text2.length(), dp);

       StringBuilder sb=new StringBuilder();
        helper(dp,text1.length(),text2.length(),text1, text2,sb);
        String str=sb.reverse().toString();


        
        String ans="";
         int p1=0,p2=0,p3=0;
      
       for(char c:str.toCharArray()){
           while(p1<text1.length()&&text1.charAt(p1)!=c){
               ans+=text1.charAt(p1++);
           }
           while(p2<text2.length()&&text2.charAt(p2)!=c){
               ans+=text2.charAt(p2++);
           }
           ans+=c;
           p1++;
           p2++;
           
       }

       if(p1<text1.length())ans+=text1.substring(p1);
       if(p2<text2.length())ans+=text2.substring(p2);
       return ans;   
   }

      private void helper(int[][] dp, int i, int j, String s, String t, StringBuilder ans) {
       if(i==0 || j==0) return;

       if(s.charAt(i-1)==t.charAt(j-1))
       {
           ans.append(s.charAt(i-1));
           helper(dp, i-1, j-1, s, t, ans);
       }
       else if(dp[i-1][j]>dp[i][j-1]){
           helper(dp, i-1, j, s, t, ans);
       }else{
           helper(dp, i, j-1, s, t, ans);
       }
   }


    int calcSuperSeq(String t1, String t2, int l1, int l2, int[][] dp)
     {
         if(l1==0 || l2==0) return 0;
 
         if(dp[l1][l2]!=-1) return dp[l1][l2];
 
         if(t1.charAt(l1-1)==t2.charAt(l2-1))
         {
              return dp[l1][l2] = 1+calcSuperSeq(t1,t2,l1-1,l2-1,dp);
         }
         else
         {
             dp[l1][l2] = Math.max(calcSuperSeq(t1,t2,l1-1,l2,dp),calcSuperSeq(t1,t2,l1,l2-1,dp));
             return dp[l1][l2];
         }
     }


     public static void main(String[] args)
     {
        ShortesCommonSuperSequence sequence=new ShortesCommonSuperSequence();
        sequence.shortestCommonSupersequence("abac", "cab");
     }
    
}
