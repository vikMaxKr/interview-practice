package com.vikash.vikash.practice.tree;

import java.util.*;

public class BottomView {

    static ArrayList<Integer> bottomView(Node root) {

        if (root == null) return new ArrayList<>();

        // Map to store the last node at each
        // horizontal distance (HD)
        Map<Integer, Integer> hdMap = new TreeMap<>();

        // Queue to store nodes and their
        // horizontal distance
        Queue<Pair> q = new LinkedList<>();

        // Start level order traversal with
        // root at HD 0
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            // Get current node and its HD
            Node curr = q.peek().node;
            int hd = q.peek().hd;
            q.poll();

            // Update the map with the current
            // node's data
            hdMap.put(hd, curr.data);

            // Traverse the left subtree, HD - 1
            if (curr.left != null) {
                q.add(new Pair(curr.left, hd - 1));
            }

            // Traverse the right subtree, HD + 1
            if (curr.right != null) {
                q.add(new Pair(curr.right, hd + 1));
            }
        }

        // Extract bottom view nodes
        // from the map
        ArrayList<Integer> result = new ArrayList<>();

        // Iterate through the map in
        // sorted HD order
        for (int value : hdMap.values()) {
            result.add(value);
        }

        return result;
    }

    public static void main(String[] args) {

        // Representation of the input tree:
        //       20
        //      /  \
        //     8   22
        //    / \    \
        //   5   3   25
        //      / \
        //     10 14
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        ArrayList<Integer> result = bottomView(root);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}


class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
