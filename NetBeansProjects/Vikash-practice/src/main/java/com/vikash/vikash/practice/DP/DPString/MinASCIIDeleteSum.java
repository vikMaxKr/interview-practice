/*
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
 * Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 */
package com.vikash.vikash.practice.DP.DPString;

import java.util.Arrays;

public class MinASCIIDeleteSum {

    public static void main(String[] args) {
        MinASCIIDeleteSum minASCIIDeleteSum = new MinASCIIDeleteSum();
        System.out.println(minASCIIDeleteSum.minimumDeleteSum("sea", "eat"));
    }

    public int minimumDeleteSum(String s1, String s2) {

        return minimumDeleteUtil(s1, s2, 0, 0);
    }

    private int minimumDeleteUtil(String s1, String s2, int i, int j) {

        if (i >= s1.length()) {
            int delete = 0;
            for (int k = j; k < s2.length(); k++) {
                delete += s2.charAt(k);
            }
            return delete;
        }

        if (j >= s2.length()) {
            int delete = 0;
            for (int l = i; l < s1.length(); l++) {
                delete += s1.charAt(l);
            }

            return delete;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return minimumDeleteUtil(s1, s2, i + 1, j + 1);
        } else {
            int a = s1.charAt(i) + minimumDeleteUtil(s1, s2, i + 1, j);
            int b = s2.charAt(j) + minimumDeleteUtil(s1, s2, i, j + 1);
            return Math.min(a, b);
        }

    }

    //-------------Memoization-----------------
    public int minimumDeleteSumMemo(String s1, String s2) {

        int[][] cache = new int[s1.length()][s2.length()];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return minimumDeleteUtil(s1, s2, 0, 0, cache);
    }

    private int minimumDeleteUtil(String s1, String s2, int i, int j, int[][] dp) {

        if (i >= s1.length()) {
            int delete = 0;
            for (int k = j; k < s2.length(); k++) {
                delete += s2.charAt(k);
            }
            return delete;
        }

        if (j >= s2.length()) {
            int delete = 0;
            for (int l = i; l < s1.length(); l++) {
                delete += s1.charAt(l);
            }

            return delete;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = minimumDeleteUtil(s1, s2, i + 1, j + 1, dp);
        } else {
            int a = (int) s1.charAt(i) + minimumDeleteUtil(s1, s2, i + 1, j, dp);
            int b = (int) s2.charAt(j) + minimumDeleteUtil(s1, s2, i, j + 1, dp);
            return dp[i][j] = Math.min(a, b);
        }

    }

}