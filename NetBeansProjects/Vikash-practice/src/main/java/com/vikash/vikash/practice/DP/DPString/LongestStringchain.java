/*
 * You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
Return the length of the longest possible word chain with words chosen from the given list of words.
 */
package com.vikash.vikash.practice.DP.DPString;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStringchain {

    public int longestStrChain(String[] words) {


        Arrays.sort(words, (a,b)-> a.length()-b.length());
        
            HashMap<String, Integer> chainLen = new HashMap<>();
            int maxLen = 0;
            for (var word : words) {
                for (int indx = 0; indx < word.length(); indx++) {
                    String pred = word.substring(0, indx) + word.substring(indx + 1);
                    chainLen.put(word, Math.max(chainLen.getOrDefault(word, 0), 
                    (!chainLen.containsKey(pred)) ? 1 : chainLen.get(pred) + 1));
                }
                maxLen = Math.max(maxLen, chainLen.get(word));
            }
            return maxLen;
    }



    public static void main(String[] args)
    {
        LongestStringchain longestStringchain=new LongestStringchain();
        String[] input=new String[]{"a","b","ba","bca","bda","bdca"};
        longestStringchain.longestStrChain(input);
    }
    
}
