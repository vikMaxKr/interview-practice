package com.vikash.vikash;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




public class Solution {

     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
public int widthOfBinaryTree(TreeNode root) {
    int res=0;
    if(root==null) return res;
    Queue<TreeNode> q=new LinkedList<>();
    q.offer(root);

    List<Integer> ls=new ArrayList<>();
    a: while(!q.isEmpty())
    {
        List<Integer> temp=new LinkedList<>();
        int sz=q.size();
        for(int i=0; i<sz; i++)
        {
            TreeNode tn=q.poll();
            if(tn==null)
            {
                temp.add(-1);
                q.offer(null);
                q.offer(null);
            }
            else{
                temp.add(1);
                q.offer(tn.left);
                q.offer(tn.right);
            }
        }


        int size=0;
        boolean ones=false;
        for(int i=0;i<temp.size();i++)
        {
            if(i==0 && temp.get(i)==-1) continue;
            if(i==temp.size()-1 && temp.get(i)==-1) continue;

            if(temp.get(i)==1) {
                ones=true;
            }
            size++;
        }
        System.out.println(size);
        ls.add(size);
        if(!ones)
        {
            break a;
        }
    }


    int max=0;
    for(int i=0;i<ls.size();i++)
    {
        if(ls.get(i)>max)
        {
            max=ls.get(i);
        }
    }
    return max;
}


    public static void main(String[] args) {
        //[1,3,2,5,null,null,9,6,null,7]

        Solution solution=new Solution();
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(3);
        treeNode.right=new TreeNode(2);
        treeNode.left.left=new TreeNode(5);
        treeNode.right.right=new TreeNode(9);
        treeNode.left.left.left=new TreeNode(6);
        treeNode.right.right.left=new TreeNode(7);
        solution.widthOfBinaryTree(treeNode);


    }
}
