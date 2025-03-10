/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 */
package com.vikash.vikash.practice.tree;

public class CheckIfBST {

    public boolean isValidBST(Node root) {


        return isValidBSTUtil(root,Long.MIN_VALUE,Long.MAX_VALUE);


    }

    public boolean isValidBSTUtil(Node root, long min, long max)
    {
        if(root==null)
            return true;

        if(root.data<=min || root.data>=max)
            return false;

        return (isValidBSTUtil(root.left,min,root.data)
                && isValidBSTUtil(root.right,root.data,max));
    }
}
