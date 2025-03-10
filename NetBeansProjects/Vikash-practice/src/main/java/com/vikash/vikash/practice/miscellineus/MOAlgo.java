/*
Given an array nums of n elements and q queries . Each query consists of two integers l and r .
You task is to find the number of elements of nums[] in range [l,r] which occur atleast k times.
Ex:-
Input: nums = {1,1,2,1,3}, Queries = {{1,5},
{2,4}}, k = 1
Output: {3,2}
Explanation: For the 1st query, from l=1 to r=5
1, 2 and 3 have the frequency atleast 1.
For the second query, from l=2 to r=4, 1 and 2 have
the frequency atleast 1.
 */
package com.vikash.vikash.practice.miscellineus;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class MOAlgo {

    public int[] solveQueries(int[] nums, int[][] Queries, int k)
    {
        int block=(int)Math.sqrt(nums.length);
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int[] query : Queries) {
            String key = query[0] + "" + query[1];
            map.put(key, 0);
        }

        Arrays.sort(Queries, (a, b) -> {

            if(a[0]/block!=b[0]/block)  return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });

        int currL = 0, currR = 0;
        int currSum = 0;
        int[] res=new int[k];

        for(int i=0;i<k;i++)
        {

            int L=Queries[i][0]-1;
            int R=Queries[i][1]-1;

            while (currL < L)
            {
                currSum -= nums[currL];
                currL++;
            }

            // Add Elements of current Range
            while (currL > L)
            {
                currSum += nums[currL-1];
                currL--;
            }
            while (currR <= R)
            {
                currSum += nums[currR];
                currR++;
            }

            while (currR > R+1)
            {
                currSum -= nums[currR-1];
                currR--;
            }

            String key=(L+1)+""+(R+1);
            map.put(key, currSum);
        }

        int i=0;
        for(Map.Entry<String, Integer> entries: map.entrySet())
        {
            res[i]=entries.getValue();
            System.out.println("---res----"+res[i]);
            i++;
        }

        return res;
    }

    public static void main(String[] args)
    {
        MOAlgo moAlgo=new MOAlgo();
        int[] nums= {1,1,2,1,3};
        int[][] Queries = {{1,5},{2,4}};
        moAlgo.solveQueries(nums, Queries, Queries.length);
    }
}
