package com.vikash.vikash.practice.DP.knapsack;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSumPartition {


    // Function to calculate the minimum absolute difference
    static int findMinDifference(ArrayList<Integer> arr, int n,
                                 int sumCalculated, int sumTotal) {

        // Base case: if we've considered all elements
        if (n == 0) {
            return Math.abs((sumTotal - sumCalculated)
                    - sumCalculated);
        }

        // Include the current element in the subset
        int include = findMinDifference(arr, n - 1,
                sumCalculated + arr.get(n - 1), sumTotal);

        // Exclude the current element from the subset
        int exclude = findMinDifference(arr,
                n - 1, sumCalculated, sumTotal);

        // Return the minimum of both choices
        return Math.min(include, exclude);
    }

    // Function to get the minimum difference
    static int minDifference(ArrayList<Integer> arr) {
        int sumTotal = 0;

        // Calculate total sum of the array
        for (int num : arr) {
            sumTotal += num;
        }

        // Call recursive function to find
        // the minimum difference
        return findMinDifference(arr,
                arr.size(), 0, sumTotal);
    }

    //memoization



    static int findMinDifference(ArrayList<Integer> arr, int n,
                                 int sumCalculated, int sumTotal,
                                 int[][] memo) {

        // Base case: if we've considered all elements
        if (n == 0) {
            return Math.abs((sumTotal - sumCalculated)
                    - sumCalculated);
        }

        // Check if result is already computed
        if (memo[n][sumCalculated] != -1) {
            return memo[n][sumCalculated];
        }

        // Include the current element in the subset
        int include = findMinDifference(arr, n - 1,
                sumCalculated + arr.get(n - 1),
                sumTotal, memo);

        // Exclude the current element from the subset
        int exclude = findMinDifference(arr, n - 1,
                sumCalculated, sumTotal, memo);

        // Store the result in memo and return
        memo[n][sumCalculated] = Math.min(include, exclude);
        return memo[n][sumCalculated];
    }

    // Function to get the minimum difference
    static int minDifferenceMemo(ArrayList<Integer> arr) {
        int sumTotal = 0;

        // Calculate total sum of the array
        for (int num : arr) {
            sumTotal += num;
        }

        // Create a memoization table initialized to -1
        int[][] memo = new int[arr.size() + 1][sumTotal + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function with memoization
        return findMinDifference(arr, arr.size(), 0, sumTotal, memo);
    }



    public static void main(String[] args) {

        ArrayList<Integer> arr
                = new ArrayList<>(Arrays.asList(1, 6, 11, 5));

        System.out.println(minDifference(arr));
    }
}
