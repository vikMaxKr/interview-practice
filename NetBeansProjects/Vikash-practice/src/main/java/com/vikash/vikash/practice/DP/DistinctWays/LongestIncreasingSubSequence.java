//Given an integer array nums, return the length of the longest strictly increasing subsequence
package com.vikash.vikash.practice.DP.DistinctWays;

import java.util.Arrays;

public class LongestIncreasingSubSequence {


    //-------------------RECURSION----------------------------------------------------------------
    int longest=Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {

        lengthOfLISUtil(nums,nums.length,0, 0, -1);
        return longest;
    }

    private void lengthOfLISUtil(int[] nums, int length, int index, int size, int min) {

        if(index>=length)
        {
            if(size>longest) longest=size;
            return ;
        }

        if(min==-1 || nums[index]>nums[min])
        {
            lengthOfLISUtil(nums,length,index+1, size+1, index);
        }
            lengthOfLISUtil(nums,length,index+1,size, min);
    }


    //-------------------MEMOIZATION---------------------------------------------------------------
    public int lengthOfLISMemo(int[] nums) {

        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
       return lengthOfLISUtilMemo(nums,nums.length,0,  -1, dp);
    }

    private int lengthOfLISUtilMemo(int[] nums, int length, int current, int previous, int[][] dp) {

        if(current>=length)
        {
            return 0;
        }

        if(dp[current][previous+1]!=-1) return dp[current][previous+1];

        int take=0;
        if(previous==-1 || nums[current]>nums[previous])
        {
           take=1+lengthOfLISUtilMemo(nums,length,current+1, current, dp);
        }
         int notTake=lengthOfLISUtilMemo(nums,length,current+1,previous, dp);

        return dp[current][previous+1]=Math.max(take,notTake);
    }


    //----------------TABULATION----------------------------------------------
    //------------------------------------------------------------------------
    public int lengthOfLISTAB(int[] nums) {

        int n=nums.length;
        int[] cache=new int[n];
        Arrays.fill(cache,1);

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    cache[i]=Math.max(cache[i],cache[j]+1);
                }
            }
        }
        return Arrays.stream(cache).max().orElse(0);
    }

    public static void main(String[] args) {
        LongestIncreasingSubSequence longestIncreasingSubSequence = new LongestIncreasingSubSequence();
        System.out.println(longestIncreasingSubSequence.lengthOfLISMemo(new int[]{1,3,5,4,7}));
    }

    //1 3 5 4 7

}
