package com.vikash.vikash.practice.miscellineus;

public class FindDuplicates {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);

        slow=nums[0];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }

    public int subarraySum(int[] nums, int k) {
        int count=0;

        if(nums.length==1) return nums[0]==k?1:0;

        for(int i=0;i<nums.length;i++)
        {

            if(nums[i]>k) {
                i++;
                continue;
            }

            if(i==nums.length-1)
            {
                if(nums[i]==k)
                {
                    count++;
                    break;
                }
                break;
            }

            int sum=nums[i];
            int j=i+1;
            while(sum<=k)
            {
                if(sum==k) break;
                sum+=nums[j++];
            }
            if(sum==k)
            {
                count++;
            }
        }

        return count;
}
    }
