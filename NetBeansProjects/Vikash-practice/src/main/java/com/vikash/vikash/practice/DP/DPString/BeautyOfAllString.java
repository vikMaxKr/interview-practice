package com.vikash.vikash.practice.DP.DPString;

import java.util.ArrayList;
import java.util.List;

public class BeautyOfAllString {

    int[] temp=new int[26];
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    int result=0;

    public int beautySum(String s) {
        List<String> str=new ArrayList<>();
        int ret=0;

        for(int i=0;i<s.length();i++)
        {
            for(int j=i+2;j<=s.length();j++)
            {
                String ss=s.substring(i,j);
                str.add(ss);
            }
        }

        int[] map=new int[27];

        for (String string : str) {
            char[] ch = string.toCharArray();
            for (char c : ch) {
                map[c - 'a']++;
            }

            int max = -1;
            int min = 10000;

            for (int i : map) {
                if (i > max) {
                    max = i;
                }
                if (i < min && i != 0) {
                    min = i;
                }
            }
            ret += (max - min);
            map = new int[27];
        }

        return ret;
    }

    public static void main(String[] args)
    {
         BeautyOfAllString beautyOfAllString=new BeautyOfAllString();
         beautyOfAllString.beautySum("aabcbaa");
    }

}
