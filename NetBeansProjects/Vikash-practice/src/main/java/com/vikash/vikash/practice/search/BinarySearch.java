/*
Binary search can only be sorted / or rotated array
 */
package com.vikash.vikash.practice.search;

import java.io.InputStream;

public class BinarySearch {

    int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

                // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // If we reach here, then element was
        // not present
        return -1;
    }
    public static void main(String[] args)
    {
        BinarySearch binarySearch=new BinarySearch();
        int[] arr=new int[]{1,1,2,7,10};
        int res=binarySearch.binarySearch(arr,2);
        System.out.println(res);
    }

}
