/*
You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days.
Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.
 */
package com.vikash.vikash.practice.DP.MaxMin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinTktCost {

    public int mincostTickets(int[] days, int[] costs) {

     /// int res=getMinimumCost(days, costs, 0,days.length);
        int[] dp=new int[days.length+1];
        Arrays.fill(dp,-1);
        int res=getMinimumCostDP(days, costs, 0,days.length, dp);
        System.out.println(res);
      return res;
    }


    //-------------------RECURSION------------------------------------
    private int getMinimumCost(int[] days, int[] costs, int index, int length) {
        if(index>=length) return 0;

        int day1=costs[0]+getMinimumCost(days,costs,index+1, length);

        int i;
        for(i=index; i<length && days[i]<days[index]+7; i++){}

        int day2=costs[1]+getMinimumCost(days,costs,i, length);

        for(i=index;i<length && days[i]<days[index]+30;i++){}

        int day3=costs[2]+getMinimumCost(days,costs,i, length);

        return Math.min(day1,Math.min(day2,day3));

    }


    //-------------------memoization--------------------------------
    //------------------------------------------------------------
    private int getMinimumCostDP(int[] days, int[] costs, int index, int length, int[] dp) {
        if(index>=length) return 0;

        if(dp[index]!=-1) return dp[index];

        int day1=costs[0]+getMinimumCostDP(days,costs,index+1, length, dp);

        int i;
        for(i=index; i<length && days[i]<days[index]+7; i++){

        }

        int day2=costs[1]+getMinimumCostDP(days,costs,i, length, dp);

        for(i=index;i<length && days[i]<days[index]+30;i++){

        }

        int day3=costs[2]+getMinimumCostDP(days,costs,i, length, dp);

        dp[index]=Math.min(day1,Math.min(day2,day3));

        return dp[index];

    }

    //--------------------------TABULATION----------------------------------------

    public int minCostTicketsTabulation(int[] days, int[] costs) {

        Set<Integer> set=new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        int[] dp=new int[days[days.length-1]+1];
        int j=2;
        for(int i=1;i<dp.length;i++){
            if(set.contains(i)){
               dp[i]=Math.min(
                       dp[Math.max(i-30,0)]+costs[j],Math.min(
                       dp[Math.max(i-7,0)]+costs[j-1],dp[i-1]+costs[j-2]
               ));
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length-1];
    }


    public static void main(String[] args) {
        MinTktCost minTktCost = new MinTktCost();
        int[] days = new int[]{1,4,6,7,8,20};
        int[] costs = new int[]{2,7,15};
        minTktCost.mincostTickets(days, costs);
    }
}
