package com.vikash.vikash.practice.LinkedList;
/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return divideAndConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideAndConquer(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];

        int mid = left + (right - left) / 2;
        ListNode l1 = divideAndConquer(lists, left, mid);
        ListNode l2 = divideAndConquer(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args)
    {
        MergeKSortedList mergeKSortedList=new MergeKSortedList();
        ListNode[] listNodes=new ListNode[3];
       // [[1,4,5],[1,3,4],[2,6]]
        ListNode ln1=new ListNode(1);
        ln1.next=new ListNode(4);
        ln1.next.next=new ListNode(5);
        ListNode ln2=new ListNode(1);
        ln2.next=new ListNode(3);
        ln2.next.next=new ListNode(4);
        ListNode ln3=new ListNode(2);
        ln3.next=new ListNode(6);
        listNodes[0]=ln1;
        listNodes[1]=ln2;
        listNodes[2]=ln3;

        mergeKSortedList.mergeKLists(listNodes);

    }
}
