/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java8features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author vikashkumar
 */
public class Practice1 {
    
    public static void main(String[] args)
    {
        
        List<Integer> list=new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(4);
//        list.add(4);
//        list.add(4);
     String str="i am fine you say say";
        String[] ss=str.split(" ");
     Map<String,Long> res= Stream.of(ss).map(x->x).collect(Collectors.groupingBy(Function.identity(),TreeMap::new,Collectors.counting()));
      // System.out.println(res);
       list.stream().findFirst().ifPresentOrElse(x->System.out.println(x), ()->System.out.println("vikas"));
      // System.out.println(list.stream().max(Integer::compare).if);
        
       // list.stream().forEach(System.out::println);
       // list.stream().map(x->x+x).forEach(System.out::println);
       //System.out.println(list.stream().forEach(i->i+i));
       
//       Set<Integer> set=new HashSet<>();
//       list.stream().filter(x->!set.add(x)).collect(Collectors.toSet()).forEach(System.out::println);
//       

int n1=4;
int n2=5;

BiFunction<Integer,Integer,Integer> fn=(a,b)->a+b;
fn.apply(2, 3);
       
     //System.out.println(fn.apply(2,4));
     //Optional<Integer> op=list.get(2);
     
     Map<String,Integer> map=new HashMap<>();
     map.put("vik", 4);
     map.put("kr",2);
     map.put("si", 3);
     
     map.entrySet().stream().sorted((a,b)->(a.getValue()-b.getValue())).collect(Collectors.toMap(Map.Entry::getKey
     ,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
//     int number=7;
//       
//    System.out.println(IntStream.rangeClosed(2, number).noneMatch(i->i%number==0));

//      IntStream.rangeClosed(2, 76).filter(x->isPrime(x)).forEach(System.out::println);
//      
//       Object[] obj=new Object[2];
//      obj[0]="biil";
      int L=1;
      int R=20;
      
    getPrime(L,R);
    
       
    }
    private static boolean isPrime(int number)
    {
       return IntStream.range(2, number).noneMatch(i->number%i==0);
        //return
    }
    
    private static void getPrime(int L,int R)
    {
        System.out.println("from getPrime--------------");
        int flag=0;
        int K=2;
        int res=0;
        for(int i=2;i<=R;i++)
        {
            flag=0;
            for(int j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
               
                int temm=i-1;
                for(int k=temm-1;k>1;k++)
                {
                    if(temm%k==0)
                    {
                       if(k<=K)
                       {
                           res++;
                       }
                       else{
                           break;
                       }
                    }
                        
                }
            }
            
        }
        
         System.out.println(res);
    }
    
   
    
    
}
