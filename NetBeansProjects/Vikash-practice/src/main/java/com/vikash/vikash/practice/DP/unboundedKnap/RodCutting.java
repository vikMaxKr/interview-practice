package com.vikash.vikash.practice.DP.unboundedKnap;

import java.util.Arrays;

/*
Given a rod of length n(size of price) inches and an array of prices, price. price[i] denotes the value of a
 piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 */
public class RodCutting {
    public int cutRod(int[] price) {
        // code here
        return cutRodUtil(price.length, price);
    }

    private int cutRodUtil(int n, int[] price)
    {
        if(n==0) return 0;

        int res=0;

        for(int j=1; j<=n; j++)
        {
            res=Math.max(res, price[j-1]+cutRodUtil(n-j, price));
        }

        return res;
    }

    //memoization

    static int cutRodRecur(int i, int[] price, int[] memo) {

        // Base case
        if (i == 0) return 0;

        // If value is memoized
        if (memo[i - 1] != -1) return memo[i - 1];

        int ans = 0;

        // Find maximum value for each cut.
        // Take value of rod of length j, and
        // recursively find value of rod of
        // length (i-j).
        for (int j = 1; j <= i; j++) {
            ans = Math.max(ans, price[j - 1] + cutRodRecur(i - j, price, memo));
        }

        return memo[i - 1] = ans;
    }

    static int cutRodMeme(int[] price) {
        int n = price.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return cutRodRecur(n, price, memo);
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRodMeme(price));
    }
}
