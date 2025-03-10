package com.vikash.vikash.practice.DP.unboundedKnap;
/*
Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you
can make sum by using different combinations from coins[ ].
 */
public class CoinChange1 {

    public int count(int coins[], int sum) {
        // code here.
        return findSum(sum, 0, coins);
    }

    private int findSum(int sum, int index, int[] coins)
    {

        if(index==coins.length)
        {
            if(sum==0)
            {
                return 1;
            }
            return 0;
        }


        int take=0;
        int notT=0;
        if(coins[index]<=sum)
        {
            take+=findSum(sum-coins[index],index,coins);
        }

        notT=findSum(sum,index+1,coins);

        return take+notT;
    }
}
