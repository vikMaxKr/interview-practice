/*
You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.
 */
package com.vikash.vikash.practice.DP.MaxMin;

import java.util.Arrays;

public class OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {
        int l=strs.length;
        int[][][] dp=new int[strs.length+1][m+1][n+1];
        for(int[][] arr:dp)
        {
            for(int[] ar:arr)
            {
                Arrays.fill(ar,-1);
            }
        }
        return calcMaxForm(strs,m,n,l,dp);
    }
    int calcMaxForm(String[] strs, int m, int n,int l,int[][][] dp)
    {
        if(l<=0) return 0;
        if(m<0 || n<0) return -1;
        if(dp[l][m][n]!=-1) return dp[l][m][n];
        int[] nums=countOnesAndZeros(strs[l-1]);
        if(nums[0]<=m && nums[1]<= n)
        {
            dp[l][m][n]=Math.max(1+calcMaxForm(strs,m-nums[0],n-nums[1],l-1,dp)
                    ,calcMaxForm(strs,m,n,l-1,dp));
        }
        else{
            dp[l][m][n]=calcMaxForm(strs,m,n,l-1,dp);
        }
        return dp[l][m][n];
    }
    int[] countOnesAndZeros(String strs)
    {
        int[] count=new int[2];
        for(int i=0;i<strs.length();i++)
        {
            if(strs.charAt(i)=='0') count[0]++;
            else count[1]++;
        }
        return count;
    }


}
