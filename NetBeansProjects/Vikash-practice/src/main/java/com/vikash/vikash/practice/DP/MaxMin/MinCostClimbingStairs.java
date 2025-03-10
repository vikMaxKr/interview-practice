/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
 */
package com.vikash.vikash.practice.DP.MaxMin;

public class MinCostClimbingStairs {

    //---RECURSION----------------------
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCostClimb(cost,n-1),minCostClimb(cost,n-2));
    }

    private int minCostClimb(int[] cost, int n) {
        if(n<0) return 0;
        if(n==0 || n==1) return cost[n];
        return cost[n]+Math.min(minCostClimb(cost, n-1),minCostClimb(cost, n-2));
    }


    //--------------Memoization----------------------
    public int minCostClimbingStairsMemo(int[] cost) {
        int n = cost.length;
        int[] dp=new int[n];
        return Math.min(minCostClimb(cost,n-1,dp),minCostClimb(cost,n-2,dp));
    }

    private int minCostClimb(int[] cost, int n,int[] dp) {
        if(n<0) return 0;
        if(dp[n]!=0) return dp[n];
        if(n==0 || n==1) return cost[n];
        return dp[n]=cost[n]+Math.min(minCostClimb(cost, n-1,dp),minCostClimb(cost, n-2,dp));
    }



    //-------------Tabulation---------------
    public int minCostClimbingStairsDP(int[] cost) {
        int n = cost.length;
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++)
        {
            if(i<2) dp[i]=cost[i];
            else{
                dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
            }
        }
        return Math.min(dp[n-1],dp[n-2]);
    }





    public static void main(String[] args) {
        MinCostClimbingStairs stairs = new MinCostClimbingStairs();
        System.out.println(stairs.minCostClimbingStairs(new int[]{1,2,3,4,5}));
        System.out.println(stairs.minCostClimbingStairsDP(new int[]{1,2,3,4,5}));
    }

}
