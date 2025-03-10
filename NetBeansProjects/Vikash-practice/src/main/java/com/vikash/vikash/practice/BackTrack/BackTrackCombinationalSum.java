package com.vikash.vikash.practice.BackTrack;

import java.util.ArrayList;
import java.util.Collections;

/*
  Given an array of integers and a sum B, find all unique combinations in the array 
  where the sum is equal to B. The same number may be chosen from the array any number of times to make B.
 N = 11
arr[] = {6,5,7,1,8,2,9,9,7,7,9}
B = 6
Output:
(1 1 1 1 1 1)
(1 1 1 1 2)
(1 1 2 2)
(1 5)
(2 2 2)
(6)
 */
public class BackTrackCombinationalSum {
    
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
       ArrayList<ArrayList<Integer>> result=new ArrayList<>();

       //sort it first
       Collections.sort(A);

       //remove duplicates
        ArrayList<Integer> removeDuplicates=new ArrayList<>();
        for(int i=0;i<A.size()-1;i++)
        {
            if(!A.get(i).equals(A.get(i+1))){
                removeDuplicates.add(A.get(i));
            }
        }
        removeDuplicates.add(A.get(A.size()-1));

        //find sum
        findSum(result,removeDuplicates,B,0,new ArrayList<>());

        //sort as per requirement
        result.sort((list1, list2) -> {
            int size1 = list1.size();
            int size2 = list2.size();
            for (int i = 0; i < Math.min(size1, size2); i++) {
                int cmp = Integer.compare(list2.get(i), list1.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(size2, size1);
        });
        result.forEach(System.out::println);
        return result;
    }

   private static void findSum(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> input, 
   int sum, int index, ArrayList<Integer> temp)
   {
       
       if(index==input.size())     //index will move from 0 to input.size()-1
       {
           if(sum==0)
           {
               ArrayList<Integer> temp1=new ArrayList<>(temp);
               temp1.sort((a,b)->b-a);
               result.add(new ArrayList<>(temp1));
           }
           return;
       }
       if(input.get(index)<=sum)
       {
           temp.add(input.get(index));
           findSum(result,input,sum-input.get(index),index,temp);  //include
           temp.remove(temp.size()-1);
       }
       findSum(result,input,sum,index+1,temp);   //do not include
   }



   /*
Find all valid combinations of K numbers that sum upto to N such that the following conditions are true:
Only number 1 through 9 are used.
Each number is used at-most once.
Return the list of all possible valid combinations.

Note: The list must not contain the same combination twice, and the combinations returned in any order.
    */
   //-----------------------------------------------------------------------------------------------------------------------

    public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {
        ArrayList<Integer> input=new ArrayList<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();

        for(int i=1;i<=9;i++)
        {
            input.add(i);
        }
        findSum(result,input,N,0,new ArrayList<>(),K);
        result.forEach(System.out::println);
        return result;
    }

    private static void findSum(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> input, int sum,
                                int index, ArrayList<Integer> temp,int k)
    {

        if(index>=input.size())
        {
            if(sum==0 && temp.size()==k)
            {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if(temp.size()==k)     //index will move from 0 to input.size()-1
        {
            if(sum==0)
            {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if(input.get(index)<=sum)
        {
            temp.add(input.get(index));
            findSum(result,input,sum-input.get(index),index+1,temp,k);
            temp.remove(temp.size()-1);
        }

        findSum(result,input,sum,index+1,temp,k);
    }




    /*
     * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
      Input: nums = [1,2,3], target = 4
    Output: 7
    Explanation:
    The possible combination ways are:
    (1, 1, 1, 1)
    (1, 1, 2)
    (1, 2, 1)
    (1, 3)
    (2, 1, 1)
    (2, 2)
    (3, 1)
    Note that different sequences are counted as different combinations.
     */

    public static int combinationSum4(int[] nums, int target) {

        return findSum(nums,target, nums.length);
    }

    private static int findSum(int[] nums, int sum, int n)
    {
        if(sum<0) {
            return 0;
        }

        if(sum==0){
            return 1;
        }

      int ans=0;  
     for(int i=0; i<n; i++)
     {
           ans+=findSum(nums, sum-nums[i], n);
     }
     return ans;
}





    public static void main(String[] args)
    {
        ArrayList<Integer> A=new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
       combinationSum(A,4);
    }
    
}
