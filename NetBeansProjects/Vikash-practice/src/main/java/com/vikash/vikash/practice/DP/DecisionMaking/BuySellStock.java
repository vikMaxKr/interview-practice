/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a
 *  transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the 
transaction fee for each transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.
 */

package com.vikash.vikash.practice.DP.DecisionMaking;

import java.util.Arrays;

public class BuySellStock {

    
    //------------------Recursion+Memoization-------------------------------------------------------------------
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
        return maxProfitUtilRecursion(prices, fee, 0, 0);
    }

    private int maxProfitUtilDP(int[] prices, int fee, int day, int hold, int[][] dp)
    {
        if(day==prices.length) return 0;
        
        if(dp[day][hold]!=-1) return dp[day][hold];
        //neither buy or sell
        int ans=maxProfitUtilDP(prices, fee, day+1, hold, dp);


        if(hold==0)
        {
            ans=Math.max(ans, maxProfitUtilDP(prices, fee, day+1, 1, dp)-prices[day]);
        }
        else{
            ans=Math.max(ans, maxProfitUtilDP(prices, fee, day+1, 0, dp)+prices[day]-fee);
        }

        return dp[day][hold]=ans;
    }

    private int maxProfitUtilRecursion(int[] prices, int fee, int day, int hold)
    {
        if(day==prices.length) return 0;
        

        //neither buy or sell
        int ans=maxProfitUtilRecursion(prices, fee, day+1, hold);

        if(hold==0)
        {
            ans=Math.max(ans, maxProfitUtilRecursion(prices, fee, day+1, 1)-prices[day]);
        }
        else{
            ans=Math.max(ans, maxProfitUtilRecursion(prices, fee, day+1, 0)+prices[day]-fee);
        }

        return ans;
    }



    public static void main(String[] args)
    {
        BuySellStock buySellStock=new BuySellStock();
        System.out.println(buySellStock.maxProfit(new int[]{1,3,7}, 2));
    }
    
}
