
package com.mycompany.interviewprep.comparator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vikashkumar
 */
public class Anagram {
    
    public static void main(String[] args)
    {
        

        String s="anagram";
        String t="nagaram";
        String[] str={"flower","flower","flower","flower"};
        
       // isAnagram(s,t);
        //isPrefix(str);
        
        int N=5;
       int count=0;
       while(N!=0)
       {
           N=N&(N-1);
           System.out.println("----"+N);
       }
       System.out.println(4&5);
          
    }
    
    public  static boolean isAnagram(String s, String t)
    {
        
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> map1=new HashMap<>();
        
        
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
         for(int i=0;i<t.length();i++)
        {
            map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)+1);
        }
        
        for(Map.Entry<Character,Integer> mp:map.entrySet())
        {
            System.out.println("from first  "+mp.getKey()+"----"+mp.getValue());
            for(Map.Entry<Character ,Integer> mp1:map1.entrySet())
            {
                System.out.println(mp1.getKey()+"----"+mp1.getValue());
               // if(mp.getKey()==mp1.getKey() && mp.getValue()!=mp1.getValue())
                  //  return false;
            }
        }
        
        
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<t.length();j++)
            {
                if(s.charAt(i)==t.charAt(j))
                    break;
                if(s.charAt(i)!=t.charAt(j) && j==t.length()-1)
                    return false;
            }
               
        }
               
               return true;
            
            }
    
    public  static String isPrefix(String[] strs)
    {
         Map<Character,Integer> map=new HashMap<>();
        String result="";
        
        if(strs.length==1)
        {
            return result=strs[0];
        }
        
        note:for(int i=0;i<strs.length-1;i++)
        {
            if(strs[i].length()<=strs[i+1].length())
            {
                for(int j=0;j<strs[i].length();j++)
                {
                    if(strs[i].charAt(j)==strs[i+1].charAt(j))
                    {
                        map.put(strs[i].charAt(j),map.getOrDefault(strs[i].charAt(j),0)+1);
                    }
                    else{
                        break note;
                    }
                }
                
            }
            else{
                
                for(int j=0;j<strs[i+1].length();j++)
                {
                    if(strs[i+1].charAt(j)==strs[i].charAt(j))
                    {
                        map.put(strs[i].charAt(j),map.getOrDefault(strs[i].charAt(j),0)+1);
                    }
                    else{
                        break note;
                    }
                }
                
            }
        }
        if(!map.isEmpty()){
        for(Map.Entry<Character,Integer> mp:map.entrySet())
        {
            if(mp.getValue()==strs.length-1)
            {
                System.out.println(mp.getKey()+"---"+mp.getValue());
                result=result+mp.getKey();
            }
        }
        }
        
     return result;   
    }
    
}
