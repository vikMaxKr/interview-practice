/*
 * You have n dice, and each dice has k faces numbered from 1 to k.
Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, 
so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
 */

package com.vikash.vikash.practice.DP.DistinctWays;

import java.util.Arrays;

public class NoDiceRoll {

    int  MOD=1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] cache=new int[n+1][target+1];
        for(int[] row: cache)
        {
            Arrays.fill(row, -1);
        }
       return findRolls(n, k, target, cache); 
    }

    private int findRolls(int n , int k , int sum, int[][] dp)
    {
        if(n==0)
        {
            if(sum==0)
            {
                return 1;
            }
            return 0;
        }

        if(dp[n][sum]!=-1) return dp[n][sum];

        int res=0;
        for(int i=1;i<=k;i++)
        {
            if(sum-i>=0)
           res=(res+findRolls(n-1,k,sum-i,dp))%MOD;
        }

        return dp[n][sum]=res;
    }
    
}
