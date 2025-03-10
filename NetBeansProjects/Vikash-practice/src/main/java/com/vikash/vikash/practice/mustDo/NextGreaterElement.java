/*
Given an array arr[ ] of integers, the task is to find the next greater element for each element of the array in order of their appearance in the array.
 Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
 Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]
 */


//INTUITION:-  Start from end of array. Put the element in stack. check if top stack is greater than current element return else pop lesser elements

package com.vikash.vikash.practice.mustDo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here

        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();
        int[] rs=new int[arr.length];

        for(int i=arr.length-1; i>=0; i--)
        {
            if(st.isEmpty())
            {
                rs[i]=-1;
                st.push(arr[i]);
            }
            else{
                if(st.peek()>arr[i])
                {
                    rs[i]=st.peek();
                    st.add(arr[i]);
                }
                else{
                    while(!st.isEmpty() && st.peek()<=arr[i])
                    {
                        st.pop();
                    }

                    if(!st.isEmpty())
                    {
                        rs[i]=st.peek();
                        st.add(arr[i]);
                    }
                    else{
                        rs[i]=-1;
                        st.push(arr[i]);
                    }
                }
            }
        }

        for(int i=0;i<arr.length;i++)
        {
            res.add(rs[i]);
        }

        return res;
    }


    //Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
    //The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search
    // circularly to find its next greater number. If it doesn't exist, return -1 for this number.

    //INTUITION:-- Here we have to traverse in both direction so imagine an array of 2*n where each element copied
    // ie [1,2,3,4]==> [1,2,3,4,1,2,3,4]. Now run loop from 2n-1 to 0
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        Arrays.fill(res, -1);

        for(int i=2*n-1; i>=0; i--)
        {
            while(!st.isEmpty() && nums[i%n]>=st.peek())
            {
                st.pop();
            }
            if(!st.isEmpty() && i<n)
            {
                res[i]=st.peek();
            }
            st.push(nums[i%n]);
        }
        return res;
    }
}
