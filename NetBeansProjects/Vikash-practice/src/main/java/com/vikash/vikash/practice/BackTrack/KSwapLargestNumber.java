
package com.vikash.vikash.practice.BackTrack;

/*
Given a number K and string str of digits denoting a positive integer, build the largest number possible by 
performing swap operations on the digits of str at most K times
Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5
 */

public class KSwapLargestNumber {

    static String ss="0";
    public static void main(String[] arg)
    {
        String input="1034";
        findMaximumNum(input,2);
    }
    
    public static void findMaximumNum(String str, int k)
    {
        ss=str;               //we have to make ss equal to str at start for case when str is already max and no swap
        findMaxUtil(str.toCharArray(),k);
        String temp=ss;
        ss="0";                //reinitialize to original for next input set
        System.out.println(temp);
    }

    private static void findMaxUtil(char[] ch, int k)
    {
        if(k==0) return;
        for(int i=0; i<ch.length-1; i++)
        {
            for(int j=i+1; j<ch.length; j++)
            {
                if(ch[j]>ch[i])
                {
                    swap(ch,i,j);
                    String str=new String(ch);
                    if(str.compareTo(ss)>0)
                    {
                        ss=str;
                    }
                    findMaxUtil(ch,k-1);
                    swap(ch,i,j);
                }
            }
        }
    }

    private static void swap(char[] ch,int i,int j)
    {
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;

    }
}
