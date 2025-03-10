/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */

package com.vikash.vikash.practice.DP.MaxMin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquare {

    public int numSquares(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i*i<=n;i++)
        {
            list.add(i*i);
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int result=solveNums(list,n, dp);
        return  result==Integer.MAX_VALUE?-1:result;
    }
    private int solveNums(List<Integer> list,int amount, int[] dp)
    {
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-1) return dp[amount];
        int minValue=Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++)
        {
            int ans=solveNums(list,amount-list.get(i), dp);
            if(ans!=Integer.MAX_VALUE)
                minValue=Math.min(minValue,ans+1);
        }
        dp[amount]=minValue;
        return dp[amount];
    }


    public static void main(String[] args) {
        PerfectSquare perfectSquare=new PerfectSquare();
        System.out.println(perfectSquare.numSquares(13));
    }


}
