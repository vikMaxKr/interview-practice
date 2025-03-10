package com.vikash.vikash.practice.BackTrack;
import java.util.*;

/*
 * Given a string S. The task is to print all unique permutations of the given
 *  string that may contain duplicates in lexicographically sorted order.
 */

/**
 * @author vikashkumar
 */
public class BackTrackPermutationsOfString {
    public static String result="0";
    public static void main(String[] args)
    {
        String str="abc";
        List<String> result=new ArrayList<>();
        findPermutations(result,str,0,str.length()-1);
        result.forEach(System.out::println);
    }



    private static void findPermutations(List<String> result, String str, int l, int r)
    {
     if(l==r)
    {
        if(!result.contains(str)) result.add(str);
    }else{
        for(int i=l;i<=r;i++)
        {
            str=swap(str, l, i);
            findPermutations(result,str, l+1, r);
            str=swap(str,l,i);
        }
    }
    }
    
    private static String swap(String str, int l,int h)
    {
        char[] cha=str.toCharArray();
        char temp=cha[l];
        cha[l]=cha[h];
        cha[h]=temp;
        return  String.valueOf(cha);
    }

    
     //------------------------------------------------------------------------
    /*
    Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
    Return a list of all possible strings we could create. Return the output in any order.
    Input: s = "a1b2"
    Output: ["a1b2","a1B2","A1b2","A1B2"]
     */

    public List<String> letterCasePermutation(String s) {
        List <String> result = new ArrayList<>();
        dfs(s.toCharArray(),result,0);
        return result;
    }

    public void dfs(char[] chArr, List<String> ans, int i) {
        if(i >= chArr.length){
            ans.add(String.valueOf(chArr));
            return;
        }
        char letter = chArr[i];
        if(letter  >= '0' && letter <= '9') {
            dfs(chArr, ans, i + 1);
        } else {
            chArr[i] = Character.toUpperCase(chArr[i]);
            dfs(chArr, ans, i + 1);
            chArr[i] = Character.toLowerCase(chArr[i]);           //back-track
            dfs(chArr, ans, i + 1);
        }
    }


    //----------------------------------------------------------------------------
    
    
     public static String findMaximumNum(String str, int k)
        {
            //code here.
            
          findPermutations(str,0,str.length()-1);
          return result;
        }
        private static void findPermutations(String str, int l,int r)
    {
        if(l==r)
        {
            if(!result.equals(str)) 
            {
                int n1=Integer.parseInt(result);
                int n2=Integer.parseInt(str);
                if(n2>n1)
                {
                    result=str;
                }
            }}
            else{
            for(int i=l;i<=r;i++)
            {
                str=swap1(str,l,i);
                findPermutations(str,l+1,r);
                str=swap(str,l,i);
            }
        }

    }
    
    private static String swap1(String str, int l,int h)
    {
        char[] cha=str.toCharArray();
        char temp=cha[l];
        cha[l]=cha[h];
        cha[h]=temp;
        return  String.valueOf(cha);
    }
}