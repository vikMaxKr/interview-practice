/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datastructure1;

/**
 *
 * @author vikashkumar
 */
public class MergeSort {
    
    private static void sort(int arr[],int l,int mid,int h)
    {
        
    }
    
    
    
   private static void mergeSort(int arr[], int l,int h)
    {
        
        if(l<h)
            
        {
            int mid=(l+h)/2;
            mergeSort(arr,l,mid-1 );
            mergeSort(arr,mid+1,h);
            sort(arr,l,mid,h);
        }
        
    }
    
 
    
    public static void main(String[] args) {
        
   
        int arr[]=new int[]{50,70,60,90,40,80,10,20,30};
        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        
        }
    
    
    
}
}