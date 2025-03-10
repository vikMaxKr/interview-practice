/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author vikashkumar
 */
public class Info1 {
    
    
    public static void main(String[] args)
    {
        Map<Character,Integer> map=new HashMap<>();
        map.put('e', 1);
        map.put('a', 2);
        map.put('c', 5);
        map.put('f', 8);
        map.put('b', 8);
       // System.out.println(map);
//        for(Map.Entry entry:map.entrySet())
//        {
//            System.out.println(entry.getKey()+"----"+entry.getValue());
//        }
        
       Map<Character,Integer> res= map.entrySet()
                .stream()
            .sorted((a,b)->(a.getValue()-b.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    
        // System.out.println(res);
        
       // countDuplicate();
      // minMax();
      nonRepeated();
        
    }
    static void countDuplicate()
    {
//        map.entrySet().stream()
//                .filter(x->Collections.frequency(, x)>1)
//                .
        
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("aa");
        list.add("cc");
        
        
     // Map<Character,Integer> res= 
       Map<String,Long> res=list.stream()
                     .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                     .entrySet()
                     .stream()
                      //.peek(System.out::println)
                     .filter(x->x.getValue()>1)
                     .peek(System.out::println)
                     .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                     ;
       
       System.out.print(res);
                     
                
    }
    static void minMax()
    {
        Long[] arr=new Long[]{1L,2L,380L,4L};
       List<Integer> list=Arrays.asList(1,2,3,4,50);
     // Long x= Stream.of(arr).min(Comparator.comparing(Long::valueOf)).get();
       
      //int x=IntStream.of(arr).max().getAsInt();
      
      
     list.stream().map(x->x*x).filter(x->x>100).mapToInt(x->x).average().ifPresentOrElse(x->System.out.println(x), ()->System.out.print("not found"));
     Stream.of(arr).map(x->x*x).filter(x->x>100L).mapToLong(x->x).average().ifPresentOrElse(x->System.out.println(x), ()->System.out.print("not found"));
     
    // System.out.println(z);
    }
    static void nonRepeated()
    {
        String str="Java is Hungry Blog Alive here";
        str.chars()
                .mapToObj(x->Character.toLowerCase((char)x))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
               // .peek(System.out::println)
                
              //  .filter(x->x.getValue()==2L)
              //  .map(x->x.getKey())
                .findFirst()
                .ifPresentOrElse(x->System.out.println(x), ()->System.out.println("Not present"));
                ;
                
//         str.chars().mapToObj(x->x)
//                 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
//                 .entrySet()
//                 .stream();

               String[] ss=str.split(" ");
               Stream.of(ss)
                       .findFirst().ifPresentOrElse(x->System.out.println(x), ()->System.out.println("bb"));
               
//               Employee emp=new Employee(12,"vik");
//               Employee emp1=new Employee(13,"kr");
//               Employee emp2=new Employee(14,"vik");
//               Employee emp3=new Employee(15,"vik");
               List<Employee> list=new ArrayList<>();
               list.add(new Employee(12,"vik"));
               list.add(new Employee(13,"kr"));
               list.add(new Employee(14,"vik"));
               list.add(new Employee(15,"vik"));
               
        Map<Integer,Set<Employee>> r= list.stream()
                       .collect(Collectors.groupingBy(x->x.getAge(),Collectors.toSet()));
        
        System.out.println(r.size());
               
              
    }
}
