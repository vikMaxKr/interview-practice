package com.vikash.vikash.practice.DP.unboundedKnap;
/*
Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of lengths of all parts.
You must make at least one cut. Assume that the length of rope is more than 2 meters.
 */
public class RopeCutting {

    static int maxProd(int n)
    {
        // Base cases
        if (n == 0 || n == 1) return 0;

        // Make a cut at different places
        // and take the maximum of all
        int max_val = 0;
        for (int i = 1; i < n; i++)
            max_val = Math.max(max_val,
                    Math.max(i * (n - i),
                            maxProd(n - i) * i));

        // Return the maximum of all values
        return max_val;
    }



}
