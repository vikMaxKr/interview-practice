package com.vikash.vikash.practice.miscellineus;

import java.util.HashMap;
import java.util.Map;
/*
Given an unsorted array of integers, the task is to find the number of subarrays having a sum exactly equal to a given number k.
Input : arr[] = [10, 2, -2, -20, 10], k = -10
Output : 3
 */

public class SubArrayWithSumK {

    static int countSubarrays(int[] arr, int k) {

        // HashMap to store prefix sums frequencies
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int res = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum so far.
            currSum += arr[i];

            // If currSum is equal to desired sum, then a new subarray is found.
            if (currSum == k)
                res++;

            // Check if the difference exists in the prefixSums map.
            if (prefixSums.containsKey(currSum - k))
                res += prefixSums.get(currSum - k);

            // Add currSum to the set of prefix sums.
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }
}
