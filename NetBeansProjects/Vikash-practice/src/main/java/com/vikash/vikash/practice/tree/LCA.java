package com.vikash.vikash.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class LCA {
    static Node lca(Node root, int n1, int n2) {

        // to store paths to n1 and n2 from the root
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();

        // Find paths from root to n1 and
        // root to n2. If either
        // n1 or n2 is not present, return null.
        if(!findPath(root, path1, n1) ||
                !findPath(root, path2, n2))
            return null;

        // Compare the paths to get the first
        // different value
        int i;
        for(i = 0; i<path1.size() &&
                i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i))
                return path1.get(i-1);
        }

        // if both the datas are same, return last node
        return path1.get(i-1);
    }

    // Finds the path from root to given node
    static boolean findPath(Node root, List<Node> path, int n) {

        // base case
        if (root == null) {
            return false;
        }

        // Store current node
        path.add(root);

        if (root.data == n ||
                findPath(root.left, path, n) ||
                findPath(root.right, path, n)) {
            return true;
        }

        // remove root from path and return false
        path.remove(path.size() - 1);

        return false;
    }

    public static void main(String[] args) {

        // construct the binary tree
        //               1
        //           /   \
        //          2     3
        //         / \   / \
        //        4  5  6   7

        Node root = new Node(1);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node ans = lca(root, 4, 5);
        if(ans == null){
            System.out.println("No common ancestor found");
        }
        else{
            System.out.println(ans.data);
        }
    }
}
