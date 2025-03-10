package com.vikash.vikash.practice.tree;

import java.util.*;

public class DuplicateTrees {

    public static List<Node> printAllDups(Node root) {
        // code here
        List<Node> dups=new ArrayList<>();
        if(root==null) return dups;

        Map<String, Integer> map=new LinkedHashMap<>();
        printDup(map, root);
        for(Map.Entry<String, Integer> mp: map.entrySet()) {
            System.out.println(mp.getKey()+"value--"+mp.getValue());
           // System.out.println(mp.getKey());
        }

        return dups;
    }

    private static String printDup(Map<String, Integer> map, Node root)
    {
        if(root==null) return "";

        if(root.left==null && root.right==null) {
            String tmp=String.valueOf(root.data);
            map.put(tmp, map.getOrDefault(tmp,0)+1);
            return tmp;
        }

        String nd1=printDup(map, root.left);
        String nd2=printDup(map, root.right);

        String nd="";
        nd+=root.data+nd1+nd2;
        map.put(nd, map.getOrDefault(nd,0)+1);
        return nd;
    }

    public static void main(String[] args) {

        // Representation of the input tree:
        //       20
        //      /  \
        //     8   22
        //    / \    \
        //   25   3   25
        //      / \
        //     10 10
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(25);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(10);
        root.right.right = new Node(25);

        printAllDups(root);

        //ArrayList<Integer> result = pr(root);

//        for (int val : result) {
//            System.out.print(val + " ");
//        }
    }
}
