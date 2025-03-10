/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.dynamicp;

/**
 *
 * @author vikashkumar
 */
public class DynamicP {

//    public static void main(String[] args) {
//        String s1="ABCDGH";
//        String s2="ABCDGH";
//        int m=s1.length();
//        int n=s2.length();
//       
//        
//       System.out.println(calcLCS(m,n,s1,s2));
//    }
    
    public static int calcLCS( int m ,int n,String s1,String s2)
    {
        
        int[][] dp=new int[m+1][n+1];
        int result=0;
        int tx=0,ty=0;
        
       for(int i=0;i<m+1;i++)
       {
           for(int j=0;j<n+1;j++)
           {
               if(i==0||j==0)
               {
                   dp[i][j]=0;
               }
              else if(s1.charAt(i-1)==s2.charAt(j-1))
               {
                   dp[i][j]=1+dp[i-1][j-1];
                   result=Math.max(result, dp[i][j]);
                   tx=i;
                   ty=j;
               }
               
               else
                  dp[i][j]=0;
               
           }
           
       }
       
       int a=tx;
       int b=ty;
       char[] ch=new char[result+1];
       ch[result]='\u0000';
       int index=result-1;
       
       while(a>0 && b>0)
       {
           
            if(dp[a][b]!=0)
           {
               ch[index--]=s1.charAt(a-1);
               a--;
               b--;
           }
            else
                
                break;
           
          
       }
       
       System.out.print(new String(ch));
        
      return result;  
        
    }
}
