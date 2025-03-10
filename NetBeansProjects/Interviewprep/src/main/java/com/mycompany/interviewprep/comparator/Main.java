/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author vikashkumar
 */
public class Main {
    
    public static void main(String[] args)
    {
        Employee e1=new Employee(1, 23, "vikash",new Address("Baker street",23));
         Employee e2=new Employee(2, 25, "vik",new Address("Baker223",24));
          Employee e3=new Employee(3, 22, "vsh",new Address("Baker23",26));
          
          List<Employee> emp=new ArrayList<>();
          emp.add(e1);
          emp.add(e2);
          emp.add(e3);
          
          //age 
         emp.stream().sorted((o1,o2)->o2.getAddress().compareTo(o1.getAddress())).forEach(m->System.out.println(m));
          
         // System.out.println("Eleeeeeee");
         // Collections.sort(emp, (emp.get(0)));
          String s="A man, a plangg, a canal: Panama";
          String ss=s.toLowerCase().replaceAll(" ", "");
         // System.out.println(ss);
         // List<Character> list=Arrays.asList(ss.split(""));
          //list.stream().filter(m->m.).forEach(m->System.out.println(m));
           char[] res=ss.toCharArray();
          
          //stream().filter(m->m>2).forEach(m->System.out.println(m));
          
          // Arrays.stream(arr).filter(e -> e < 2 || e > 10).forEach(e->System.out.println(e));
          
          
          
          
//          List<Character> list=new ArrayList<>();
//          for(int i=0;i<ch.length;i++)
//          {
//              if(ch[i]>=97 && ch[i]<=122)
//              {
//                  list.add(ch[i]);
//              }
//          }
//          String rrrr=list.toString();
//          System.out.println(rrrr);
List<Character> list=new  ArrayList<>();

for(int i=0;i<res.length;i++)
        {
            if((res[i]>=97 && res[i]<=122)|| (res[i]>=48 && res[i]<=57))
            {
                list.add(res[i]);
            }
        }
        
        for(int i=0,j=list.size()-1;i<j;i++,j--)
        {
            if(list.get(i)!=list.get(j))
                System.out.println("Yes");
        }
        
        //return true;
        System.out.print(list.toString());
    }
    
}
