/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticeCode;

/**
 *
 * @author vikashkumar
 */

class Node{
    
    Node node;
    int val;
    Node(int val)
    {
        this.val=val;
    }
}

public class Test22 {
    
    
    public static void main(String[] args)
    {
        Node node=new Node(3);
        Node node1=new Node(4);
        Node node2=new Node(5);
        Node node3=new Node(6);
        node.node=node1;
        node1.node=node2;
        node2.node=node3;
        node3.node=null;
        int count=0;
        int temp=0;
        
        Node head=node1;
        Node head1=node1;
        
        while(head!=null)
        {
            count++;
            head=head.node;
        }
        
        while(head1!=null)
        {
            
            temp++;
            if(temp>=count/2)
                break;
            
            head1=head1.node;
        }
        
        System.out.println(head1.val);
        
        
    }
    
    //  select c1, c2 from  t1 inner join  t2 on t1.c1=t2.c2 ;
    
    //  list.stream().filter(x->x>1000).collect(Collectors.asList<>());
    
    
}
