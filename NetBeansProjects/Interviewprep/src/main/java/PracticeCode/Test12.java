/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticeCode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author vikashkumar
 

Given two arrays of integers A[] and B[] of size N and M, the task is to check if 
a pair of values
(one value from each array) exists such that swapping the
elements of the pair will make the sum of two arrays equal.*/


public class Test12 {
    
    public static void main(String[] args)
    {
       String key="thequickbrownfoxjumpsoverthelazydog"; 
       String message="vkbsbstsuepuv";
       Map<Character,Character> map=new LinkedHashMap<>();
        char c='a';
        String result="";
        for(int i=0;i<key.length();i++)
        {
            if(!map.containsKey(key.charAt(i)))
           {
            //System.out.println(key.charAt(i)+"--"+c);
               map.put(key.charAt(i),c);
               c++;
           } 
        }
       for(int i=0;i<message.length();i++)
       {
           result+=""+map.get(message.charAt(i));

        }

       System.out.println(result);
    
       
    }
    
    private static int checksum(int A[],int n,int B[],int m,int sum1,int sum2)
    {
        int temps1,temps2;
         for(int i=0;i<n;i++)
        {
           for(int j=0;j<m;j++) 
           {
               temps1=sum1-A[i]+B[j];
               temps2=sum2-B[j]+A[i];
               if(temps1==temps2)
               {
                 return 1;  
               }
           }
        }
        
        return -1;
    }
     public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result=0;
        for(int i=0;i<items.size();i++)
        {
            if(ruleKey.equals("type"))
            {
                if(items.get(i).get(0).equals(ruleValue))
                { System.out.println("inside type");
                result++;
                }
            }
            else if(ruleKey.equals("color"))
            {
            if(items.get(i).get(1).equals(ruleValue))
            {
                System.out.println("inside color"+items.get(i).get(1));
                result++;
            }
            }
            else if(ruleKey.equals("name"))
            {
                if(items.get(i).get(2).equals(ruleValue))
                {
                    System.out.println(result);
                    result++;
                }
            }
        }

        return result;
        
    }
    
}
