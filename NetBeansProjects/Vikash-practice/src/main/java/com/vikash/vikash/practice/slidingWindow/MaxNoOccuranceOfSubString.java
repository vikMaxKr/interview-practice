/*
 * Given a string s, return the maximum number of occurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.
 

Example 1:

Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
Output: 2
Explanation: Substring "aab" has 2 occurrences in the original string.
It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
 */

package com.vikash.vikash.practice.slidingWindow;

import java.util.*;

public class MaxNoOccuranceOfSubString {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        Map<String, Integer> map= new HashMap<>();

        int left=0;
        int right=minSize;
        int maxOccurance=0;

        while(right<=s.length())
        {
            String str=s.substring(left, right);
            map.put(str,map.getOrDefault(str, 0)+1);
            left++;
            right++;
        }

        for(String ss: map.keySet())
        {
            int count=map.get(ss);

            if(count>maxOccurance && isValid(ss, maxLetters)){
                maxOccurance=count;
            }
        }

        System.out.println(""+maxOccurance);
        return maxOccurance;
    }

    boolean isValid(String str, int maxUnique)
    {
        Set<Character> set=new HashSet<>();

        char[] ch=str.toCharArray();
        for(char cc: ch)
        {
            set.add(cc);
        }

        return set.size()<=maxUnique;
    }
public static void main(String[] args)
{

    MaxNoOccuranceOfSubString maxNoOccuranceOfSubString=new MaxNoOccuranceOfSubString();
    maxNoOccuranceOfSubString.maxFreq("aababcaab", 2, 3, 4);
}
    
}
