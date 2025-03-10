/*
There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:
Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
 */
package com.vikash.vikash.practice.DP.MaxMin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyBoards2 {


    private static void checkSet()
    {

    }

    Set<List<Integer>> set;
    public int minSteps(int n) {
        set=new HashSet<>();
       return getSteps(1,0,n);

    }

    private int getSteps(int screen, int key, int n)
    {
        if(screen>n) return 100000;
        if(screen==n) return 0;
        List<Integer> list=new ArrayList<>();
        list.add(screen);
        list.add(key);

        if(set.contains(list)) return 100000;
        set.add(list);

        int copy=1+getSteps(screen, screen, n);
        int paste=1+getSteps(screen+key,key,n);

        return Math.min(copy, paste);
    }


    //----------------------------------TABULATION--------------------------------------
    //------------------------------------------------------------------------------

    private int getStepsTabulation(int n)
    {
        int[] dp=new int[n+1];
        dp[0]=0;;
        dp[1]=0;
        dp[2]=2;

        for(int i=3;i<=n;i++)
        {
             int primeFactor=getPrimeFactor(i);
             if(primeFactor==i) dp[i]=primeFactor;
             else{
                 dp[i]=dp[primeFactor]+dp[i/primeFactor];
             }
        }
        return dp[n];
    }

    private int getPrimeFactor(int n) {
        int res=2;
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                res=i;
                n=n/i;
            }
        }

        return Math.max(n, res);
    }

    public static void main(String[] args) {

        KeyBoards2 keyBoards2=new KeyBoards2();
       // System.out.println(keyBoards2.minSteps(31));
        System.out.println(keyBoards2.getStepsTabulation(33));
    }


}
