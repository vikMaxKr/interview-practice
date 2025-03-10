package com.vikash.vikash.practice.DP.knapsack;

import java.util.ArrayList;

/*
Given an array of integers A[] of length N and an integer target.
You want to build an expression out of A by adding one of the symbols '+' and '-' before each integer in A and then concatenate all the integers.

For example, if arr = {2, 1}, you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that can be built, which evaluates to target and return your answer with modulo 109+7.

Input:
N = 5
A[] = {1, 1, 1, 1, 1}
target = 3
Output:
5
Explanation:
There are 5 ways to assign symbols to
make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

 */
public class TargetSum {

    //recursive
    static int findTargetSumWays( int N, int[] A ,int target) {
        // code here
        return  knap(0, A, target);
        // return res[0];

    }
    static int knap(int i, int[] A, int capacity)
    {
        if(capacity==0 && i==A.length) return 1;

        if(i>=A.length) return 0;

        return knap(i+1, A, capacity-A[i]) + knap(i+1, A, capacity+A[i]);

    }

    //memoization
    static int findTotalWays(ArrayList<Integer> arr,
                             int[][] dp, int i, int s,
                             int target, int totalSum)
    {

        // If target is reached, return 1
        if (s == target && i == arr.size())
            return 1;

        // If all elements are processed and
        // target is not reached, return 0
        if (i >= arr.size())
            return 0;


        if (dp[i][s + totalSum] != -1)
            return dp[i][s + totalSum];


        return dp[i][s + totalSum]
                = findTotalWays(arr, dp, i + 1, s + arr.get(i),
                target, totalSum)
                + findTotalWays(arr, dp, i + 1,
                s - arr.get(i), target,
                totalSum);
    }

    // Driver Program
    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);

        int totalSum = 0;
        for (int i = 0; i < arr.size(); i++)
            totalSum += arr.get(i);

        // Target number
        int target = 3;

        int[][] dp = new int[arr.size()][2 * totalSum + 1];
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(
                findTotalWays(arr, dp, 0, 0, target, totalSum));
    }

}
