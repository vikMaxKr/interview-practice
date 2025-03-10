package com.vikash.vikash.practice.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class CommonAnscestor {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) {
                return root;
            }

            return left != null ? left : right;
        }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<>();
        TreeNode tg=null;
        findTarget(root, target, tg);
        System.out.println(tg.val);
        if(tg!=null)
        {
            int[] count=new int[1];
            dfs(tg, k, res, count);
        }
        return res;
    }

    TreeNode findTarget(TreeNode root, TreeNode target, TreeNode tg)
    {
        if(root==null) return null;

        if(root==target) {
            tg=root;
            return tg;
        }
        findTarget(root.left, target, tg);
        findTarget(root.right, target, tg);
        return tg;

    }

    void dfs(TreeNode root, int k, List<Integer> ls, int[] count)
    {
        if(root==null) return;
        if(root.left==null && root.right==null)
        {
            count[0]-=1;
            return;
        }
        if(count[0]==k) ls.add(root.val);

        count[0]+=1;
        dfs(root.left, k, ls, count);
        dfs(root.right, k, ls, count);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        CommonAnscestor commonAnscestor=new CommonAnscestor();

        //commonAnscestor.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(5));
        commonAnscestor.distanceK(root, new TreeNode(5), 2);
    }
}
