/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datastructure1;

/**
 *
 * @author vikashkumar
 */
public class CountSort {
    
    private static int findMax(int arr[])
    {
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        return max;
    }
   
    
    private static void radixSort(int arr[],int l, int h)
    {
        int max=findMax(arr);
        
        int count[]=new int[max+1];
        int output[]=new int[arr.length];
       for(int i=0;i<arr.length;i++)
      {
           count[arr[i]]+=1;
       }
        for(int i=1;i<=max;i++)
        {
            count[i]+=count[i-1];
        }
        for(int i=arr.length-1;i>=0;i--)
       {
           count[arr[i]]-=1;
           output[count[arr[i]]]=arr[i];
       }
        
        //arr=count;
       for(int i=0;i<arr.length;i++)
       {
           arr[i]=output[i];
       }
        
    }
    
    
    
    
       public static void main(String[] args){
        int arr[]=new int[]{6,3,9,10,15,6,8,12,3,6};
        radixSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        
        }
       }
    
}
