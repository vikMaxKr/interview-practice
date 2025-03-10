/*
Given an array arr[] of integers of size N that might contain duplicates,
the task is to find all possible unique subsets
Input: N = 3, arr[] = {2,1,2}
Output:(),(1),(1 2),(1 2 2),(2),(2 2)
Explanation:
All possible subsets = (),(2),(1),(1,2),(2),(2,2),(2,1),(2,1,2)
After Sorting each subset = (),(2),(1),(1,2),(2),(2,2),(1,2),(1,2,2)
Unique Susbsets in Lexicographical order = (),(1),(1,2),(1,2,2),(2),(2,2)
 */
package com.vikash.vikash.practice.BackTrack;

import java.util.*;

public class UniqueSubsets {

    public static void main(String[] args) {
        int[]  input = new int[]{1,2,1};
        AllSubsets(input,3);
    }

    public static ArrayList <ArrayList <Integer>> AllSubsets(int[] arr, int n)
    {
        // your code here
         ArrayList <ArrayList <Integer>> subsets = new ArrayList<>();
         Arrays.sort(arr);
         generateCombinations(arr, 0, new ArrayList<>(), subsets);
           subsets.sort((list1, list2) -> {
            int size1 = list1.size();
            int size2 = list2.size();
            for (int i = 0; i < Math.min(size1, size2); i++) {
                int cmp = Integer.compare(list1.get(i), list2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(size1, size2);
        });
        subsets.forEach(System.out::println);
        return subsets;
    }

    private static void generateCombinations(int[] input, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {


        if(index==input.length){
            result.add(new ArrayList<>(current));
            return;
        }
        // Include the current character and move to the next
        current.add(input[index]);
        generateCombinations(input, index + 1, current, result);

        current.remove(current.size() - 1);

        while(index+1<input.length && input[index+1] == input[index]) {           //skip the duplicates Ex:- 1,2,2
            index++;
        }
        generateCombinations(input, index + 1, current, result);
    }


    //FIND ALL SUBSETS :----
    /*
[1]
[1, 2]
[1, 2, 3]
[1, 2, 3, 3]
[1, 2, 3]
[1, 3]
[1, 3, 3]
[1, 3]
[2]
[2, 3]
[2, 3, 3]
[2, 3]
[3]
[3, 3]
[3]
     */
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        // code here
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        generateCombinations(a,0,new ArrayList<>(), result);
        result.forEach(System.out::println);
        return result;
    }

    private static void generateCombinations(ArrayList<Integer> input, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {

        if (index >= input.size()) {
            return;
        }
        // Include the current character and move to the next
        current.add(input.get(index));
        // current+=input.charAt(index);
        result.add(new ArrayList<>(current));
        generateCombinations(input, index + 1,current, result);
        // Exclude the current character and move to the next
        current.remove(current.size()-1);
        generateCombinations(input, index + 1, current, result);
    }

    //----------------------------------------------------------------------------------------
    /*
     * The XOR total of an array is defined as the bitwise XOR of all its elements,
     * or 0 if the array is empty.

For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
Given an array nums, return the sum of all XOR totals for every subset of nums.

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some
(possibly zero) elements of b.
     */
    //1863. Sum of All Subset XOR Totals
    int ans=0;
    public int subsetXORSum(int[] nums) {
        List<Integer> al=new ArrayList<>();
        findAns(0,nums,al);
        return ans;
    }

    public void findAns(int index,int[] nums,List<Integer> al){
        if(index==nums.length){
            int result = 0;
            for (int num : al) {
                result ^= num;
            }
            ans+=result;
            return;
        }
        al.add(nums[index]);
        findAns(index+1,nums,al);
        al.remove(al.size()-1);     //back track
        findAns(index+1,nums,al);

    }

    //since subset similar to subsequence so above problem can be solved as
    public int ans(int[] nums,int index,int xor)
    {
        if(index == nums.length) return xor;
        int pick = ans(nums,index+1,xor^nums[index]);
        int nopick = ans(nums,index+1,xor);
        return pick+nopick;
    }
}
