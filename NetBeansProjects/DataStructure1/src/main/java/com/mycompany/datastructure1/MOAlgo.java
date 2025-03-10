/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datastructure1;
import java.util.*;

/**
 *
 * @author vikashkumar
 */

class Query{
int L;
int R;
public Query(int L,int R)
{
    this.L=L;
    this.R=R;
}
}



public class MOAlgo {
    
    
    public  static void printQuerySums(int a[],int n , ArrayList<Query> q, int m)
{
       int block=(int)Math.sqrt(n);
       int arr[][]=new int[2][3];
       System.out.println(arr.length);
       
       Collections.sort(q, ( x, y)->{
                 
                      if (x.L/block != y.L/block)
                    return (x.L < y.L ? -1 : 1);
 
                // Same block, sort by R value
                return (x.R < y.R ? -1 : 1);
} 
               );
       Iterator it =q.iterator();
        Query qq[]=new Query[3];
        int j=0;
       while(it.hasNext())
       {
           qq[j++]=(Query)it.next();
           // System.out.println((Query)it.next());
       }
      for(int i=0;i<qq.length;i++)
      {
          System.out.println(qq[i].L+" "+qq[i].R);
      }
       
      
       
}



    
    
    public static void main(String argv[])
    {
        int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        int n = a.length;
         
        ArrayList<Query> q = new ArrayList<>();
        q.add(new Query(0,4));
        q.add(new Query(1,3));
        q.add(new Query(2,4));
         
        int m = q.size();
        printQuerySums(a, n, q, m);
    }
    
}
