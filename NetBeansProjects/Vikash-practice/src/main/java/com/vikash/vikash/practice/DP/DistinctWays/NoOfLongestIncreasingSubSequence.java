package com.vikash.vikash.practice.DP.DistinctWays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.
 */
public class NoOfLongestIncreasingSubSequence {

    public int lengthOfLIS(int[] nums) {

        int[] cache = new int[nums.length+1];
        lengthOfLISUtil(nums,nums.length,0, 0, -1 , cache);
        Arrays.stream(cache).forEach(System.out::print);
        return Arrays.stream(cache).max().orElse(0);
    }

    private void lengthOfLISUtil(int[] nums, int length, int index, int size, int min, int[] cache) {

        if(index>=length)
        {
            //if(size>longest) longest=size;
            cache[size] +=1;
            return ;
        }

        if(min==-1 || nums[index]>nums[min])
        {
            lengthOfLISUtil(nums,length,index+1, size+1, index ,cache);
        }
        lengthOfLISUtil(nums,length,index+1,size, min, cache);
    }


    //-------TABULATION-------------------------------------------------------------------
    public int lengthOfLISTabulation(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n], count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int res = 0, maxi = 1;

        for (int i = 0; i < n; ++i) {
            for (int prev = 0; prev < i; ++prev) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    count[i] = count[prev];
                } else if (nums[prev] < nums[i] && 1 + dp[prev] == dp[i])
                    count[i] += count[prev];
            }
            maxi = Math.max(maxi, dp[i]);
        }

        for (int i = 0; i < n; ++i) {
            if (dp[i] == maxi)
                res += count[i];
        }

        return res;

    }


    public static void main(String[] args) {
        NoOfLongestIncreasingSubSequence no = new NoOfLongestIncreasingSubSequence();
        System.out.println(no.lengthOfLISTabulation(new int[]{1,2,4,3,5,4,7,2}));
    }
}
