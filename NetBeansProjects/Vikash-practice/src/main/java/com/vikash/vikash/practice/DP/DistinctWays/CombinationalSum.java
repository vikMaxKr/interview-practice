/*
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 * Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
 */

package com.vikash.vikash.practice.DP.DistinctWays;

import java.util.Arrays;

public class CombinationalSum {



    //-----memoization----------------------------------------------
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp, -1);
        return findSum(nums,target, nums.length, dp);
    }

    private int findSum(int[] nums, int sum, int n, int[] dp)
    {
        if(sum<0) return 0;

            if(sum==0){
              return 1;
            } 

            if(dp[sum]!=-1) return dp[sum];

      int ans=0;  
     for(int i=0;i<n;i++)
     {
           ans+=findSum(nums, sum-nums[i],n, dp);
     }

     dp[sum]=ans;
     return dp[sum];
}

//----------------------tabulation---------------------------------------

public int findSumTabulation(int[] nums, int target)
{

    int[] cache=new int[target+1];
    cache[0]=1;

    for(int i=1;i<=target;i++)
    {
       for(int j=0;j<nums.length;j++)
       {
          if(i-nums[j]>=0)
          {
            cache[i]+=cache[i-nums[j]];
          }
       }
    }
    return cache[target];

}
    
}
