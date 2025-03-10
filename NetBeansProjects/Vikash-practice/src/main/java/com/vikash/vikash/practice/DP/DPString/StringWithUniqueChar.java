/*
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4. 
*/
package com.vikash.vikash.practice.DP.DPString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringWithUniqueChar {

    int max=0;
    public int maxLength(List<String> arr) {
        if(arr.size()==1) return arr.get(0).length(); 
        backTrack(arr, 0, "");
        return max;
        
    }
    void backTrack(List<String> arr, int start, String curr)
    {
        if(max<curr.length())
        {
            max=curr.length();
        }

        for(int i=start; i< arr.size(); i++)
        {
            if(!isValid(curr, arr.get(i))) continue;

            backTrack(arr, i+1, curr+arr.get(i));
        }
    }


   private boolean isValid(String currentString, String newString) {
        Set<Character> charSet = new HashSet<>();

        for (char ch : newString.toCharArray()) {
            if (charSet.contains(ch)) {
                return false; 
            }

            charSet.add(ch);

            if (currentString.contains(String.valueOf(ch))) {
                return false;  
            }
        }

        return true;
    }


    public static void main(String[] arg)
    {
        StringWithUniqueChar stringWithUniqueChar=new StringWithUniqueChar();
        List<String> list=new ArrayList<>();
        list.add("uu");
        stringWithUniqueChar.maxLength(list);
    }

    
    
}
