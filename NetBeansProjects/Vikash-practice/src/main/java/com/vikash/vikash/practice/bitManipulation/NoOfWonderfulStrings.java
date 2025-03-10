/*
 * A wonderful string is a string where at most one letter appears an odd number of times.

For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word.
*  If the same substring appears multiple times in word, then count each occurrence separately.

A substring is a contiguous sequence of characters in a string.
 */
package com.vikash.vikash.practice.bitManipulation;

public class NoOfWonderfulStrings {

    public static void main(String[] args) {
        NoOfWonderfulStrings no = new NoOfWonderfulStrings();
        long wonders=no.wonderfulSubstrings("ccjjc");
        System.out.println(wonders);
    }

    public long wonderfulSubstrings(String word) {


        long wonderful = 0;
        final int TOTAL = 1 << 10;
       // System.out.println("Total----" + TOTAL);
        long[] map = new long[TOTAL];
        map[0] = 1L;
        int value = 0;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            value ^= (1 << index);
            map[value]++;
        }
        for (int i = 0; i < TOTAL; i++) {
            wonderful += map[i] * (map[i] - 1) / 2;
            for (int j = 1; j <= i; j <<= 1) {
                if ((i & j) == j)
                    wonderful += map[i] * map[i - j];
            }
        }
        return wonderful;
    }

}
