/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dynamicp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author vikashkumar
 */

class Node {
	Node parent;
	Long id;
        
        Node(Node parent,Long id)
        {
            this.id=id;
            this.parent=parent;
        }
         
}

public class Test22 {
    
    public static void main(String[] args)
    {
               List<Node> node=new ArrayList<>();
                Node root = new Node(null, 1l);
		Node node1 = new Node(root, 2l);
		Node node2 = new Node(root, 3l);
		Node node3 = new Node(root, 4l);
		Node node4 = new Node(node1, 5l);
		Node node5 = new Node(node1, 6l);
		Node node6 = new Node(node5, 7l);
                node.add(root);
                node.add(node1);
                node.add(node2);
                node.add(node3);
                node.add(node4);
                node.add(node5);
                node.add(node6);
              //  getChildCounts(node);
              String str="ilovejavaprogramming";
             // String[] s=str.split("\\s+");
           // Map<String,Long> map=Stream.of(s).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//      Set<Entry<Character,Long>>  map=   
              str.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))
                      .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
              .entrySet().forEach(System.out::println);
      
      
        
    }
    
    static Map<Long, Integer> getChildCounts(List<Node> nodes) {
        //Iterate nodes
    //Check if in map current node's parent id exist
// if not exist then add it with parent id key and 0 value
//if exists then increment value by 1
        
	Map<Long,Integer> map=new HashMap<>();
        Map<Node,Long> map1=new LinkedHashMap<>();
        for(int i=0;i<nodes.size();i++)
        {
     
            map1.put(nodes.get(i).parent, map1.getOrDefault(nodes.get(i).parent,0L)+1L);
            
        }
        for(Map.Entry entries:map1.entrySet())
        {
            System.out.println(entries.getKey()+"--"+entries.getValue());
        }
            
   return map;
}
    
}
