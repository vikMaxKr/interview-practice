/*
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
 */
package com.vikash.vikash.practice.miscellineus;

import java.util.Arrays;

public class ClimbingMountains {

    public int longestMountain(int[] arr) {
        int length=arr.length;
        if(length<3) return 0;

        int[] lis=new int[length];
        int[] lds=new int[length];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for(int i=1; i<length; i++)
        {
            if(arr[i] > arr[i-1])
            {
                lis[i]=lis[i-1]+1;
            }
        }

        for(int i=length-2; i>=0; i--)
        {
            if(arr[i] > arr[i+1])
            {
                lds[i]= lds[i+1]+1;
            }
        }

        int max=0;
        for(int i=0; i<length; i++)
        {
            if(lis[i]>1 && lds[i]>1)
            {
                max=Math.max(max, lis[i]+lds[i]-1);
            }
        }
        return max;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int[] temp=new int[k];
        ListNode head1=head;

        int size=0;
        while(head1!=null)
        {
            head1=head1.next;
            size++;
        }

        if(size%k==0)
        {
            Arrays.fill(temp, size/k);
        }
        else if(size<k){
            for(int i=0;i<k;i++)
            {
                temp[i]=1;
            }
        }else{
            Arrays.fill(temp, size/k);
            int rem=size%k;
            int i=0;
            while(rem!=0)
            {
                temp[i]++;
                i++;
            }
        }

        ListNode newNode=head;
        ListNode[] node=new ListNode[k];
        for(int i=0;i<k;i++) {
            node[i] = newNode;
            ListNode prev = null;
            ListNode currNode = newNode;

            int n = temp[i];

            while (n > 0) {
                prev = currNode;
                currNode = currNode.next;
                n--;
            }

            newNode = currNode;
            if (prev != null) {
                prev.next = null;
            }
        }

        return node;
    }

    public static void main(String[] args)
    {
        ClimbingMountains climbingMountains=new ClimbingMountains();
      //  System.out.println(climbingMountains.longestMountain(new int[]{2,1,4,3}));

        ListNode listNode=new ListNode();
        ListNode listNode1=new ListNode();
        ListNode listNode2=new ListNode();
        listNode.val=1;
        listNode1.val=2;
        listNode2.val=3;
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=null;

        climbingMountains.splitListToParts(listNode,3);
    }

}

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
