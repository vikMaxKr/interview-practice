package com.vikash.vikash.practice.search;

public class SortedRotated {

    /*
    find target  in sorted and rotated array
     */
        public int search(int[] nums, int target) {

            int left=0;
            int right=nums.length-1;

            while(left<=right)
            {
                int mid=left+(right-left)/2;

                if(nums[mid]==target) return mid;

                // Handle the case where we have duplicates at the edges (low, mid, high)
                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    // When nums[low], nums[mid], and nums[high] are equal, we can't determine which half is sorted
                    // So we shrink the search space by incrementing low and decrementing high to narrow the range
                    left++;
                    right--;
                }

                else if(nums[left]<=nums[mid])
                {
                    if(target>=nums[left] && target<=nums[mid])
                    {
                        right=mid-1;
                    }
                    else{
                        left=mid+1;
                    }
                }
                else{
                    if(target>=nums[mid] && target<=nums[right])
                    {
                        left=mid+1;
                    }
                    else{
                        right=mid-1;
                    }
                }
            }
            return -1;
        }

        //Find smallest in sorted and rotated array
    public static int smallest(int[] arr)
    {
        int l=0;
        int h=arr.length-1;

        while(l<h)
        {
            if(arr[l]<arr[h])         //already sorted
            {
                return arr[l];
            }
            int mid=l+(h-l)/2;

            if(arr[mid]> arr[h])    //right half not sorted
            {
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return arr[l];
    }

    // find
    }
