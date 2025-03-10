/*
 * A string s is called happy if it satisfies the following conditions:
s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings,
*  return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.
Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
 */
package com.vikash.vikash.practice.DP.DPString;

public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {

        StringBuilder sb=new StringBuilder();
        int total=a+b+c;
        int currA=0, currB=0, currC=0;
    
        for(int i=0;i<total;i++)
        {
            if((a>=b && a>=c && currA!=2) || (a>0 && (currB==2 || currC==2)))
            {
                sb.append("a");
                a--;
                currA++;
                currB=0;
                currC=0;
            }
            else if((b>=c && b>=a && currB!=2) || (b>0 && (currA==2 || currC==2 )))
            {
                sb.append("b");
                b--;
                currB++;
                currA=0;
                currC=0;
            }
            else if((c>=a && c>=b  && currC!=2)|| (c>0 && (currA==2 || currB==2)))
            {
                sb.append("c");
                c--;
                currC++;
                currA=0;
                currB=0;
            }
        }
        return sb.toString();   
        }
    
}
