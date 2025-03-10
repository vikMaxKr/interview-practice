package com.vikash.vikash.practice.tree;

import java.util.HashMap;

public class DuplicateSubTree {

    static String dupSubRecur(Node1 root,
                              HashMap<String, Integer> map) {

        // For null Node1s,
        if (root == null) return "N";

        // For leaf Node1s, return its value in string.
        if (root.left == null && root.right == null) {
            return String.valueOf(root.data);
        }

        // Process the left and right subtree.
        String left = dupSubRecur(root.left, map);
        String right = dupSubRecur(root.right, map);

        // Generate the serialized form.
        String curr = "";
        curr += root.data;
        curr += '*';
        curr += left;
        curr += '*';
        curr += right;

        // Store the subtree in map.
        map.put(curr, map.getOrDefault(curr, 0) + 1);

        return curr;
    }

    static int dupSub(Node1 root) {
        HashMap<String, Integer> map = new HashMap<>();

        // Generate all the subtrees.
        dupSubRecur(root, map);

        // Check for all subtrees.
        for (int val : map.values()) {

            // If subtree is duplicate.
            if (val > 1) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        //         A
        //       /   \
        //      B     C
        //     / \     \
        //    D   E     B
        //           /   \
        //          D     E
        Node1 root = new Node1('A');
        root.left = new Node1('B');
        root.right = new Node1('C');
        root.left.left = new Node1('D');
        root.left.right = new Node1('E');
        root.right.right = new Node1('B');
        root.right.right.left = new Node1('D');
        root.right.right.right = new Node1('E');

        if (dupSub(root) == 1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

class Node1 {
    char data;
    Node1 left, right;

    Node1(char x) {
        data = x;
        left = null;
        right = null;
    }
}

