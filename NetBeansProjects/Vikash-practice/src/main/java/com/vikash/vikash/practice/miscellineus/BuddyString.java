/*
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 */
package com.vikash.vikash.practice.miscellineus;

import java.util.HashSet;
import java.util.Set;

public class BuddyString {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {                         //If both equal if contains duplicates can be swap
            HashSet<Character> set = new HashSet<>();
            for (char c: s.toCharArray()) {
                if (!set.add(c)) {
                    return true;
                }
            }
            return false;
        }

        int dif = 0;
        Character swapS = null;
        Character swapG = null;
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char gChar = goal.charAt(i);
            if (sChar != gChar) {
                if (dif == 2 || (dif == 1 && (swapS != gChar || swapG != sChar))) {
                    return false;
                }
                swapS = sChar;
                swapG = gChar;
                dif++;
            }
        }
        return dif == 2;
    }

    //-------------------------------------------------------------------------------------------------
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord)
    {

       StringBuilder sb1=new StringBuilder();
       StringBuilder sb2=new StringBuilder();
       StringBuilder sb3=new StringBuilder();

        for(int i=0;i<firstWord.length();i++)
            {
                int f1=firstWord.charAt(i)-'a';

                sb1.append(f1);
        }

        for(int i=0;i<secondWord.length();i++)
            {

               int f1=secondWord.charAt(i)-'a';
                sb2.append(f1);
        }

        for(int i=0;i<targetWord.length();i++)
            {
                int f1=targetWord.charAt(i)-'a';

                sb3.append(f1);
        }

        long a=Integer.valueOf(sb1.toString());
        long b=Integer.valueOf(sb2.toString());
        long c=Integer.valueOf(sb3.toString());

        return (a+b)==c;
        
    }

/*
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */

    public boolean closeStrings(String word1, String word2) {

        int l1=word1.length();
        int l2=word2.length();

        if(l1!=l2) return false;

        int[] m1=new int[26];
        int[] m2=new int[26];

        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();


        for(int i=0;i<l1;i++)
        {
            m1[word1.charAt(i)-'a']++;
            m2[word2.charAt(i)-'a']++;

        }

        for(int i=0;i<26;i++)
        {
            if((m1[i]==0 && m2[i]!=0) || (m1[i]!=0 && m2[i]==0)) {
                return false;
            }

            if(m1[i]!=0)
            {
                sb1.append(m1[i]);
            }

            if(m2[i]!=0)
            {
                sb2.append(m2[i]);
            }
        }

        String ss1=sb1.toString();
        String ss2=sb2.toString();

        int flag=0;
        for(int i=0; i<ss1.length(); i++)
        {
            flag=0;
            for(int j=0; j<ss2.length(); j++)
            {
                if(ss2.charAt(j)==ss1.charAt(i))
                {
                     flag=1;
                     break;
                }
            }
        }

        if(flag==0) return false;


     return true;
    }



    public static void main(String[] args)
    {
        BuddyString buddyString=new BuddyString();
       // buddyString.isSumEqual("acb", "cba", "cdb");

       // buddyString.checkIfCanBreak("szy", "cid");
       buddyString.closeStrings("cabbba", "abbcca");

    }
    
}
