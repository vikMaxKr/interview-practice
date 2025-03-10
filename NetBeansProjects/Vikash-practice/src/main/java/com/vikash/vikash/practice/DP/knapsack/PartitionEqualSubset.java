package com.vikash.vikash.practice.DP.knapsack;
/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both
 subsets is equal or false otherwise.
 */
public class PartitionEqualSubset {

    public boolean canPartition(int[] nums) {

        int sum=0;
        for(int i: nums)
        {
            sum+=i;
        }

        if(sum%2!=0) return false;
        else{
            boolean[][] dp = new boolean[nums.length+1][sum/2+1];
            return findSum(nums, sum/2,nums.length, dp);
        }
    }

    private boolean findSum(int[] nums, int sum, int index, boolean[][] dp) {
        if(sum==0) return true;
        if(sum<0 || index<=0) return false;
        if(dp[index][sum]) return dp[index][sum];
        if(nums[index-1]>sum)  return dp[index][sum]= findSum(nums,sum,index-1, dp);
        dp[index][sum]=findSum(nums, sum-nums[index-1], index-1, dp)|| findSum(nums, sum, index-1, dp);

        return dp[index][sum];
    }


    //Find total Partitions recursive

    public int totalPartition(int[] nums) {

        int sum=0;
        for(int i: nums)
        {
            sum+=i;
        }

        if(sum%2!=0) return 0;
        else{
            return findTotalSum(nums, sum/2,nums.length);
        }
    }

    private int findTotalSum(int[] nums, int sum, int index) {
        if(sum==0) return 1;
        if(index==0) return 0;
        if(nums[index-1]>sum) return findTotalSum(nums,sum,index-1);
        return  findTotalSum(nums, sum-nums[index-1], index-1) + findTotalSum(nums, sum, index-1);
    }

    public static void main(String[] args) {
        PartitionEqualSubset partitionEqualSubset = new PartitionEqualSubset();
        System.out.println(partitionEqualSubset.canPartition(new int[]{1,5,11,5}));
    }
}
