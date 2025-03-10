/*
Given an integer N representing the number of pairs of parentheses, the task is to generate
all combinations of well-formed(balanced) parentheses.
Input:
N = 3
Output:
((()))
(()())
(())()
()(())
()()()
 */
package com.vikash.vikash.practice.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthesis {

     void isValidParenthesis()
     {
         List<String> result = new ArrayList<>();
         checkValidity(3, 0, 0, "", result);
         result.forEach(System.out::println);
     }

    private void checkValidity(int n, int open, int close, String temp, List<String> result) {

         if(open == n && close == n)
         {
             result.add(temp);
             return;
         }

         //Add open
        if(open < n)
        {
            temp+="(";
            checkValidity(n,open+1,close,temp,result);
            temp=temp.substring(0, temp.length()-1);
        }

        //Add close
        if(close < open)
        {
            temp+=")";
            checkValidity(n,open,close+1,temp,result);
            temp=temp.substring(0, temp.length()-1);
        }
    }

    public static void main(String[] args) {
         ValidParenthesis validParenthesis = new ValidParenthesis();
         validParenthesis.isValidParenthesis();
    }
}
