/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datastructure1;

/**
 *
 * @author vikashkumar
 */
public class RadixSort {
    
    
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
    
    private static void sort(int arr[], int loop)
    {
        int n=arr.length;
        int count[]=new int[10];
        int output[]=new int[n];
        for(int i=0;i<n;i++)
        {
            count[(arr[i]/loop)%10]+=1;
        }
        for(int i=1;i<10;i++)
        {
            count[i]+=count[i-1];
        }
        for(int i=n-1;i>=0;i--)
        {
            count[(arr[i]/loop)%10]-=1;
            output[count[(arr[i]/loop)%10]]=arr[i];
        }
       
//        for(int i=0;i<n;i++)
//        {
//            arr[i]=output[i];
//        }
        
    }
    
    private static void radixSort(int arr[])
    {
        int m =findMax(arr);
        
        for(int loop=1 ;m/loop>0;loop*=10)
        {
            sort(arr,loop);
        }
        
        
    }
    
    
    
    public static void main(String[] args){
        int arr[]=new int[]{6,3,9,10,15,6,8,12,3,6};
        radixSort(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        
        }
       }
    
}
