/*
Given an array arr[] which represents a Complete Binary Tree i.e., if index i is the parent, index 2*i + 1 is the left child and index 2*i + 2 is the right child.
The task is to find the minimum number of swaps required to convert it into a Binary Search Tree.
 */
package com.vikash.vikash.practice.tree;

import java.util.Arrays;

public class MinSwapToMakeBST {

    static void inorder(int[] arr, int[] inorderArr,
                        int index, int[] counter) {
        int n = arr.length;

        // Base case: if index is out of bounds, return
        if (index >= n)
            return;

        // Recursively visit left subtree
        inorder(arr, inorderArr, 2 * index + 1, counter);

        // Store current node value in the inorder array
        inorderArr[counter[0]] = arr[index];
        counter[0]++;

        // Recursively visit right subtree
        inorder(arr, inorderArr, 2 * index + 2, counter);
    }

    static int minSwaps(int[] arr) {
        int n = arr.length;
        int[] inorderArr = new int[n];
        int[] counter = new int[1];

        // Get the inorder traversal of the binary tree
        inorder(arr, inorderArr, 0, counter);

        // Create an array of pairs to store the value
        // and its original index
        int[][] t = new int[n][2];
        int ans = 0;

        // Store the value and its original index
        for (int i = 0; i < n; i++) {
            t[i][0] = inorderArr[i];
            t[i][1] = i;
        }

        // Sort the array based on values to get BST order
        Arrays.sort(t, (a, b) -> Integer.compare(a[0], b[0]));

        // Find minimum swaps by detecting cycles
        boolean[] visited = new boolean[n];

        // Iterate through the array to find cycles
        for (int i = 0; i < n; i++) {

            // If the element is already visited or in
            // the correct place, continue
            if (visited[i] || t[i][1] == i)
                continue;

            // Start a cycle and find the number of
            // nodes in the cycle
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = t[j][1];
                cycleSize++;
            }

            // If there is a cycle, we need (cycleSize - 1)
            // swaps to sort the cycle
            if (cycleSize > 1) {
                ans += (cycleSize - 1);
            }
        }
        // Return the total number of swaps
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 10, 5, 7, 9, 11};
        System.out.println(minSwaps(arr));
    }
}
