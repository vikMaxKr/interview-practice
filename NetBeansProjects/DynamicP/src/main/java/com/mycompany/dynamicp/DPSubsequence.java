/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dynamicp;

/**
 *
 * @author vikashkumar
 */
public class DPSubsequence {
    
    
    public static void main(String[] args)
    {
         String s1="geeksforgeeks";
        String s2="gks";
   int result= subsequence(s1,s2,s1.length(),s2.length()); 
   System.out.println(result);
    }
    
    static int subsequence(String s1,String s2,int a,int b)
     {
         
         int[][] dp=new int[a+1][b+1];
         for(int i=0;i<b;i++)
         {
             dp[0][i]=0;
         }
         for(int j=0;j<a;j++)
         {
             dp[j][0]=1;
         }
         
         for(int i=1;i<a+1;i++)
         {
             for(int j=1;j<b+1;j++)
             {
                 if(s1.charAt(i-1)==s2.charAt(j-1))
                 {
                     dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                 }
                 else{
                     dp[i][j]=dp[i-1][j];
                 }
             }
         }
       return dp[a][b];
     }
      
}


