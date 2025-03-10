/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java8features;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author vikashkumar
 */
public class Test extends Test2 {
    
    
   void show()
   {
       System.out.println("child");
   }
    
    public static void main(String[] args)
    {
        
        
        
       String input="qrssaqqzibbssraib";
       int[] in=new int[26];
       String out="";
       int k=0;
       int counter=-1;
       for(int i=0;i<input.length();i++)
       {
           int val=input.charAt(i)-97;
           System.out.println(val);
           in[val]++;
           
       }
       
       for(int i=0;i<input.length();i++)
       {
           k=0;
           counter=-1;
           for(int j=0;j<in.length;j++)
           {
               if(counter<in[j] && in[j]!=0)
               { 
                   counter=in[j];
                   k=j;
               
               }
                   
           }
           if(in[k]!=0)
           out+=(char)(k+97);
           in[k]=0;
       }
       System.out.println(out);
       
       
       ////////
       
       
       int[][] A=new int[][]{{1,0},{0,1}};
       int[][] B=new int[][]{{2,3},{3,2}};
       int[][] O=new int[A.length][A[0].length];
       
       int result=0;
       int l=0;
       int v=0;
       for(int i=0;i<A.length;i++)
       {
           v=0;
           while(v<B.length)
           {
           for(int j=0;j<A[0].length;j++)
           {
               result+=A[i][j]*B[j][v];
           }
           O[i][v]=result;
           result=0;
           v++;
       }
           
       }
       
       for(int i=0;i<A.length;i++)
       {
           for(int j=0;j<A[0].length;j++)
           {
               O[i][j]=O[i][j]+A[i][j];
           }
       }
       
       //////////////////////
       
       String input2="readable content of a page when looking at its layout";
       String[] split=input2.split("\\s+");
       String output="";
       int num;
       int index;
       for(int i=0;i<split.length;i++)
       {
           num=Integer.MIN_VALUE;
           index=0;
           for(int j=i;j<split.length;j++)
           {
               if(num<split[j].length())
               {
                   num=split[j].length();
                   index=j;
               }
               
           }
           String str=split[i];
           split[i]=split[index];
           split[index]=str;
           
           output+=split[i]+" ";
          
       }
       
       System.out.println(output);
       
       
       ////////////
       
       
       char[] ch="9805621".toCharArray();
       char find='6';
       int outputIndex;
       for(int i=0;i<ch.length;i++)
       {
           if(ch[i]==find)
           {
               outputIndex=i;
               break;
           }
       }
       
       
       ///////////////
       
       
       
        
    }

    
}
