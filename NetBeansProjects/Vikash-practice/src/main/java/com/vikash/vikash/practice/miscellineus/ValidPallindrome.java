/*
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 */
package com.vikash.vikash.practice.miscellineus;

public class ValidPallindrome {

    public boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;

        while(left<right)
        {
            if(s.charAt(left)==s.charAt(right))
            {
                left++;
                right--;
            }
            else{
                 if(isValid(left+1, right, s))
                 {
                    return true;
                 }
                 else if(isValid(left, right-1, s))
                 {
                    return true;
                 }

                 return false;
            }
        }

         return true;
    }

    boolean isValid(int i, int j, String s)
    {
        for(; i<=j ; i++, j--)
        {
            if(s.charAt(i)!= s.charAt(j))
            {
                return false;
            }
        }

        return true;
    }
    
}
