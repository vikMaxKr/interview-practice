package com.vikash.vikash.practice.BackTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniquePermutations {

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findPermutations(result,arr,0,n-1);
        result.sort((list1, list2) -> {
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
        return result;
    }

    private static void findPermutations(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arr, int l, int r)
    {
        if(l==r)
        {
            result.add(new ArrayList<>(arr));
        }

        Set<Integer> set = new HashSet<>();                     //to track duplicates
            for(int i=l;i<=r;i++)
            {
                if(set.contains(arr.get(i))) continue;;
                set.add(arr.get(i));
                swap(arr,l,i);
                findPermutations(result,arr,l+1,r);
                swap(arr,l,i);                                   //backtrack the above swap
            }
    }

    private static void swap(ArrayList<Integer> arr, int l,int h)
    {
        int temp = arr.get(l);
        arr.set(l,arr.get(h));
        arr.set(h,temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        System.out.println(uniquePerms(arr,arr.size()));
    }
}
