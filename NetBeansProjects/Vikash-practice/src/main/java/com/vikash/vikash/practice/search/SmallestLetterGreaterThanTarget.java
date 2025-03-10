package com.vikash.vikash.practice.search;
/*
You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
 There are at least two different characters in letters.
Return the smallest character in letters that is lexicographically greater than target.
If such a character does not exist, return the first character in letters.
Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
 */
public class SmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(letters[mid]>target){
                end = mid -1;
            }
            else{
                start = mid +1;
            }

        }
        return letters[start%letters.length];
    }
}
