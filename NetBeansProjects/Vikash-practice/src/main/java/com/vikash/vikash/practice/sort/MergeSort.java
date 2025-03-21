/*
NOT IN PLACE SORTING SINCE REQUIRES EXTRA SPACE.
TIME COMPLEXITY - 0(nlogn)
 */

package com.vikash.vikash.practice.sort;

class MergeSort {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] leftPart = new int[n1];
        int[] rightPart = new int[n2];

        for(int k=0;k<n1;k++)
        {
            leftPart[k]=array[k+low];
        }

        for(int k=0;k<n2;k++)
        {
            rightPart[k]=array[mid+1+k];
        }


//        System.arraycopy(array, low, leftPart, 0, n1);
//        System.arraycopy(array, mid + 1, rightPart, 0, n2);

        int p1 = 0, p2 = 0, writeInd = low;

        while (p1 < n1 && p2 < n2) {
            if (leftPart[p1] <= rightPart[p2]) {
                array[writeInd++] = leftPart[p1++];
            } else {
                array[writeInd++] = rightPart[p2++];
            }
        }

        while (p1 < n1) {
            array[writeInd++] = leftPart[p1++];
        }

        while (p2 < n2) {
            array[writeInd++] = rightPart[p2++];
        }
    }

    public static void main(String[] args)
    {
        String str="abbbc";
        System.out.println(str.indexOf(str.charAt(1)));
        MergeSort mergeSort=new MergeSort();
        mergeSort.sortArray(new int[]{5,2,3,1});
    }
}
