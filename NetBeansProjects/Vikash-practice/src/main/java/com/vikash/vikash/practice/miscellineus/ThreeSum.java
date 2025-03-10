/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
 */
package com.vikash.vikash.practice.miscellineus;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<nums.length-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;  //remove duplicates

            for(int j=i+1; j<nums.length-1;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1]) continue; //avoid duplicates

                int target= -(nums[i] + nums[j]);

                //binary search
                int left=j+1;
                int right=nums.length-1;

                while(left<=right)
                {
                    int mid=left+(right-left)/2;
                    if(nums[mid]==target)
                    {
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[mid]);
                        res.add(list);
                        break;
                    }
                    else if(nums[mid]>target)
                    {
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }
            }
        }
        return res;
    }
}
