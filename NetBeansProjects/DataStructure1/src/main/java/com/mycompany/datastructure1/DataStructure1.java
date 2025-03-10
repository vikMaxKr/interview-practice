
package com.mycompany.datastructure1;

/**
 *
 * @author vikashkumar
 */
public class DataStructure1 {
    
    private static void swap(int arr[],int j,int i)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    private static int performSort(int arr[],int l,int h)
    {
        int value=arr[h];
        int i=l-1;
        for(int j=l;j<=h;j++)
        {
            if(arr[j]<value)
            {
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);
        return i+1;
    }
    private static void quickSort(int arr[],int l,int h)
    {
        if(l<h)
        {
            int value=performSort(arr,l,h);
            quickSort(arr,l,value-1);
            quickSort(arr,value+1,h);
        }
    }

    public static void main(String[] args) {
        
        int arr[]=new int[]{50,70,60,90,40,80,10,20,30};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        
        }
        
    }
}
