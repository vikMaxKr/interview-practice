package com.vikash.vikash.practice.tree;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryToBST {
    Node binaryTreeToBST(Node root)
    {
        // Your code here
        if(root==null) return root;
        ArrayList<Integer> ar=new ArrayList<>();
        inorder(root, ar);

        Collections.sort(ar);
        int[] index=new int[1];
        toBST(root, ar,index);
        return root;
    }

    private void toBST(Node root, ArrayList<Integer> ar, int[] index)
    {
        if(root==null) return;

        toBST(root.left, ar, index);

        root.data=ar.get(index[0]);
        index[0]++;
        toBST(root.right, ar, index);
    }

    private void inorder(Node root, ArrayList<Integer> ar)
    {
        if(root==null) return;

        inorder(root.left, ar);
        ar.add(root.data);
        inorder(root.right, ar);
    }
}
