/*
0/1 KnapSack:-

 */
package com.vikash.vikash.practice.DP.knapsack;

import java.util.Arrays;

public class KnapSack {

    /* UNBOUNDED KNAPSACK
 Given a set of items, each with a weight and a value, represented by the array wt and val respectively. Also, a knapsack with a weight limit capacity.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.
     */


    //RECURSION

    static int knapSack(int val[], int wt[], int capacity) {
        // code here

        return knap(val, wt, capacity, 0);
    }

    static int knap(int[] val, int[] wt, int capacity, int i)
    {
        if(i>=val.length) return 0;

        int take=0;

        if(wt[i]<=capacity)
        {
            take=val[i]+knap(val, wt, capacity-wt[i], i);
        }
        int notTake=knap(val, wt, capacity, i+1);

        return Math.max(take, notTake);
    }

    //memoization

    static int knapSackRecur(int i, int capacity, int[] val,
                             int[] wt, int[][] memo) {
        if (i == val.length)
            return 0;

        // If value is memoized.
        if (memo[i][capacity] != -1)
            return memo[i][capacity];

        // Consider current item only if
        // its weight is less than equal
        // to maximum weight.
        int take = 0;
        if (wt[i] <= capacity) {
            take = val[i]
                    + knapSackRecur(i, capacity - wt[i], val, wt,
                    memo);
        }

        // Skip the current item
        int noTake = knapSackRecur(i + 1, capacity, val, wt, memo);

        // store maximum of the two and return it.
        return memo[i][capacity] = Math.max(take, noTake);
    }

    static int knapSack(int capacity, int[] val, int[] wt) {

        // 2D matrix for memoization.
        int[][] memo = new int[val.length][capacity + 1];
        for (int i = 0; i < val.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return knapSackRecur(0, capacity, val, wt, memo);
    }

}
