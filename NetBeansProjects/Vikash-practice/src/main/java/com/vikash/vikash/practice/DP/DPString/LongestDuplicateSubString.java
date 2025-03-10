/*
 * Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.
Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".
Input: s = "banana"
Output: "ana"
 */
package com.vikash.vikash.practice.DP.DPString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestDuplicateSubString {

    public String numDistinct(String s) {

        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<s.length()-1;i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
             
                String str=s.substring(i, j+1);
                map.put(str, map.getOrDefault(str, 0)+1);
            }
        }

        String max="";
        int length=0;
        for(Map.Entry entries: map.entrySet())
        {
            if((int)entries.getValue()>1)
            {
                   String ss=(String)entries.getKey();
                   if(ss.length()>length)
                   {
                    max=ss;
                    length=ss.length();
                   }
            }
        }


        System.out.println(max);
        return max;
       
    }

    public static void main(String[] args)
    {
         LongestDuplicateSubString longestDuplicateSubString=new LongestDuplicateSubString();
      //  longestDuplicateSubString.numDistinct("aa");
    }
    
}
