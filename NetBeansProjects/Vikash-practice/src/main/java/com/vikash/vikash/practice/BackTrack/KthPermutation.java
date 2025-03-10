/*
Given two integers N (1<=N<=9) and K. Find the kth permutation sequence of first N natural numbers. Return the answer in string format
Steps:-
1. find Factorials of 0-9
2.Index=k/(n-1)!    [if(k%(n-1)!)==0 ; index-=1]
3. ans+=char(digit[index])
4. erase used digit from input
5. new k=k-((n-1)!*index);
base condition ; If n==1, add the last digit
Example:-

Input: N = 4, K = 3
Output: 1324
Explanation: 
Permutations of first 4 natural numbers:
1234,1243,1324,1342,1423,1432.....
So the 3rd permutation is 1324. 
 */

 //NOTE:- If we use Permutations of String. It will result in TLE


package com.vikash.vikash.practice.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    static List<Integer> factorials=new ArrayList<>();
    public static String kthPermutation(int n,int k) {
        StringBuilder number=new StringBuilder();
        for(int i=1;i<=n;i++) {
            number.append(i);
        }
        StringBuilder result=new StringBuilder();
        solve(k,number,result,n);
        System.out.println(result);
        return result.toString();
    }

    private static void solve(int k, StringBuilder input, StringBuilder result, int n) {
        if(n==1) {
            result.append(input);                //Base condition
            return;
        }


        int factorial=factorials.get(n-1);                //return block size
        int index=k/(factorial);

        if(k%(factorial)==0) {                          //when switching block
            index-=1;
        }

        result.append(input.charAt(index));
        input.deleteCharAt(index);
        k-=(factorial*index);              //skip prev blocks
        solve(k,input,result,n-1);
    }


    private static int getFactorial(int n) {
        int result=1;
        while(n>=1)
        {
            result=result*n;
            n=n-1;
        }
        return result;
    }

    public static void main(String[] args) {
        for(int i=0;i<=9;i++)
        {
           int num=getFactorial(i);
           factorials.add(num);
        }
        kthPermutation(4,14);
    }

}


