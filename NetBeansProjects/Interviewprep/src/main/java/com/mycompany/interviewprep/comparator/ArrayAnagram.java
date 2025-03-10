/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep.comparator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vikashkumar
 */
public class ArrayAnagram {
    
    public static void main(String[] args)
    {
        
        String s="AABABBA";
        int k=2;
        int j=0,i=0,f=0,maxL=0;
        Map<Character, Integer> map=new HashMap<>();
        
        while(j<s.length())
        {
           char c=s.charAt(j); 
           map.put(c, map.getOrDefault(c,0)+1);
           f=Math.max(map.get(c),f);
           
//           if(j-i+1-f<=k)
//           {
//               maxL=Math.max(j-i+1, maxL);
//           }
//           else{
//               map.put(s.charAt(i), map.get(s.charAt(i))-1);
//               i++;
//           }
          j++; 
           
        }
        
        System.out.println(f);
        
     
    }
    
}
