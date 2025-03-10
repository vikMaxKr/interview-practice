package com.vikash.vikash.practice.search;

public class BinarySearchClosestToX {
    int findClosestNumber(int x, int[] arr)
    {
        int left=0;
        int right=arr.length-1;

        while(left<right)
        {
            int mid=left+(right-left)/2;

            if(arr[mid]==x)
            {
                return mid;
            }

            else if(arr[mid]>x)
            {
                right=mid;
            }
            else{
                left=mid+1;
            }
        }

        if(left==0) return 0;
        if(left==arr.length) return arr.length-1;

        if (Math.abs(arr[left] - x) < Math.abs(arr[left - 1] - x)) {
            return left;
        } else {
            return left - 1;
        }
    }
}
