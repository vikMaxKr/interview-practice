package com.vikash.vikash.practice.tree;

import java.util.*;

public class AllSumOfTree {

    int count=0;
    public int pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum, new ArrayList<>());
        return count;
    }

    private void dfs(TreeNode root, int targetSum, ArrayList<Integer> ar) {

        if(root==null) return;
        int sum=0;

        for(int i=ar.size()-1;i>=0;i--)
        {
            sum+=ar.get(i);
            if(sum==targetSum) count++;
        }

        dfs(root.left, targetSum, ar);
        dfs(root.right, targetSum, ar);

        ar.remove(ar.size()-1);   //backtrack
    }

    public static void main(String[] args) {
        TreeNode tn=new TreeNode(10);
        tn.left=new TreeNode(5);
        tn.right=new TreeNode(-3);
        tn.left.left=new TreeNode(3);
        tn.left.right=new TreeNode(2);
        tn.right.right=new TreeNode(11);
        tn.left.left.right=new TreeNode(-2);
        tn.left.left.left=new TreeNode(3);
        tn.left.right.right=new TreeNode(1);

        int[] res=new int[]{1,2,3,4,5};
        List<String> ls=new ArrayList<>();
        ls.add("12");
        ls.add("23");
        ls.add("45");
        Collections.sort(ls, (o1, o2) -> {
           String A=o1+o2;
           String B=o2+o1;
           return  A.compareTo(B)>0? -1: 1;
        });

    }



     static class TreeNode
    {
        int data;
        TreeNode left, right;

        TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
}
