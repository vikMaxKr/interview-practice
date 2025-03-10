/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 */
package com.vikash.vikash.practice.DP.unboundedKnap;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {

    //------------RECURSION --BACKTRACK--------------------------------------
    private static void findSum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> input, int sum, int index, ArrayList<Integer> temp)
    {

        if(index==input.size())
        {
            if(sum==0)
            {
                ArrayList<Integer> temp1=new ArrayList<>(temp);
                temp1.sort((a,b)->b-a);
                result.add(new ArrayList<>(temp1));
            }
            return;
        }

        if(input.get(index)<=sum)
        {
            temp.add(input.get(index));
            findSum(result,input,sum-input.get(index),index,temp);
            temp.remove(temp.size()-1);
        }

        findSum(result,input,sum,index+1,temp);
    }

    ///----------------------------------MEMOIZATION---------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------
    int doCoinChange(int[] coins, int cur, int amount, int[][] dp,int n) {

        if (cur == n || amount <= 0){
           // System.out.println("curr--"+cur);
           // System.out.println("Amount is " + amount);
            return (amount == 0) ? 0 : Integer.MAX_VALUE - 1;
        }

        int take=Integer.MAX_VALUE;
        int doNotTake;


        if (dp[cur][amount] != -1)
            return dp[cur][amount];


        if (coins[cur] <= amount) {
            //System.out.println("coin " + coins[cur]);
            take=  1 + doCoinChange(coins, cur, amount - coins[cur],dp, n);
            //System.out.println("take:"+take);
        }
        doNotTake = doCoinChange(coins, cur + 1, amount, dp, n);
       // System.out.println("doNotTake:"+doNotTake);

        dp[cur][amount] = Math.min(take, doNotTake);
        return dp[cur][amount] ;
    }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
        int result=doCoinChange(coins,0,amount,dp,n);
        System.out.println("result:"+result);
        return  result==(Integer.MAX_VALUE - 1) ? -1 : result;
    }


//-------------------------------------------------------TABULATION----------------------------------
    //---------------------------------------------------------------------------------------------
    public int coinChangeTabulation(int[] coins, int amount) {
        int[][] dp;
            dp = new int[coins.length+1][amount+1];
            for(int i = 0;i<dp.length;i++)
            {
                for(int j = 0;j<dp[0].length;j++)
                {
                    if(i == 0)
                        dp[i][j] = Integer.MAX_VALUE - 1;
                    if(j == 0)
                        dp[i][j] = 0;
                    if(i == 1 && j!=0)
                    {
                        if(j%coins[0] == 0)
                            dp[i][j] = j/coins[0];
                        else
                            dp[i][j] = Integer.MAX_VALUE - 1;
                    }
                }
            }
            for(int i = 2;i<dp.length;i++)
            {
                for(int j = 1;j<dp[0].length;j++)
                {
                    if(coins[i-1]<=j)
                        dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }

        for(int i = 0;i<dp.length;i++)
        {
            for(int j = 0;j<dp[0].length;j++)
            {
                System.out.println(dp[i][j]+" ");
            }
        }
            if(dp[coins.length][amount] >= Integer.MAX_VALUE - 1)
                return -1;
            return dp[coins.length][amount];
        }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {2,3};
        System.out.println(coinChange.coinChangeTabulation(coins,5));

    }
}
