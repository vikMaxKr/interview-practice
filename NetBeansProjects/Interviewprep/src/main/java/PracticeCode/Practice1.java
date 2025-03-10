/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticeCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 *
 * @author vikashkumar
 */
public class Practice1 {
    
    public static void main(String[] args)
    {
        String[] input=new String[]{"2","1","+","3","*"};
        String a="foo";
        String b="eggnjhhjh";
        Practice1 pp=new Practice1();
      //  pp.calcResult(input);
        System.out.println(pp.calcIsomprphic(a, b));
        
        BiFunction<Integer,Integer,Integer> fn=(a1,b1)->a1*b1;
        System.out.println(fn.apply(2, 4));
        
        Optional<String> opt=Optional.ofNullable(0+"");
        opt.ifPresent(System.out::println);
        opt.ifPresentOrElse(n->System.out.println(n+"vik"), ()->System.out.println("not present"));
    }
    
    void calcResult(String[] input)
    {
        int val=0;
       Stack<String> list=new Stack<>();
       String str="+-*/";
        for (String input1 : input) {
            if (!str.contains(input1)) {
                list.push(input1);
            } else {
                int a=Integer.valueOf(list.pop());
                int b=Integer.valueOf(list.pop());
                switch (input1) {
                    case"+" -> {
                        val=a+b;
                        list.push(""+val);
                    }
                    case"-" -> {
                        val=a-b;
                        list.push(""+val);
                    }
                    case"*" -> {
                        val=a*b;
                        list.push(""+val);
                    }
                    case"/" -> {
                        val=a/b;
                        list.push(""+val);
                    }
                }
            }
        }
        
        System.out.println(list.pop());
    }
    
    boolean calcIsomprphic(String a, String b)
    {
        if(a.length()!=b.length())
           return false;
        
        Map<Character,Integer> map1=new HashMap<>();
         Map<Character,Integer> map2=new HashMap<>();
         
         for(int i=0;i<a.length();i++)
         {
             map1.put(a.charAt(i), map1.getOrDefault(a.charAt(i), 0)+1);
         }
         
          for(int i=0;i<b.length();i++)
         {
             map2.put(b.charAt(i), map2.getOrDefault(b.charAt(i), 0)+1);
         }
          
          if(map1.size()==map2.size())
              return true;
         
         
         
         
         return false;
        
        
    }
    
}
