package com.vikash.vikash.practice.LinkedList;

public class MergeTwoSortedListRecursion {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return mergeList(list1, list2);
    }

    private ListNode mergeList(ListNode l1, ListNode l2)
    {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
    }

  }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
