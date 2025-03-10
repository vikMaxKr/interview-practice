package com.vikash.vikash.practice.tree;

import java.util.HashMap;

public class PostFromInPre {

    static void printPost(int[] in, int[] pre, int inStart,
                          int inEnd,
                          HashMap<Integer, Integer> mp,
                          int[] preIndex) {
        if (inStart > inEnd)
            return;

        // Find index of next item in preorder traversal in
        // inorder.
        int inIndex = mp.get(pre[preIndex[0]++]);

        // Traverse left tree
        printPost(in, pre, inStart, inIndex - 1, mp,
                preIndex);

        // Traverse right tree
        printPost(in, pre, inIndex + 1, inEnd, mp,
                preIndex);

        // Print root node at the end of traversal
        System.out.print(in[inIndex] + " ");
    }

    // Wrapper function to initialize map and call printPost
    static void printPostOrder(int[] in, int[] pre, int n) {

        // Map to store the elements
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] preIndex = { 0 };

        // Store index of each element to
        // access it later
        for (int i = 0; i < n; i++)
            mp.put(in[i], i);

        printPost(in, pre, 0, n - 1, mp, preIndex);
    }

    public static void main(String[] args) {

        int[] in = { 4, 2, 5, 1, 3, 6 };
        int[] pre = { 1, 2, 4, 5, 3, 6 };
        int n = pre.length;

        printPostOrder(in, pre, n);
    }
}
