/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author vikashkumar
 */
public class Main {
    
    private Object[] res;
    public static void main(String[] args)
    {
        List<Employee> list=new ArrayList<>();
        list.add(new Employee("vik","male","civil",21));
        list.add(new Employee("vikas","femal","mech",21));
        list.add(new Employee("raj","tra","elect",21));
        list.add(new Employee("pk","male","civil",21));
        
        list.stream().map(x->x.getDepartment()).collect(Collectors.toSet()).forEach(System.out::println);
       System.out.println( list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
       
    
      
     Main main =new Main();
      main.getobj();
      
      int arr[]={3,2,5,7};
      int arr1[]={2,3,5,9};
      int flag=0;
      Arrays.sort(arr);
      Arrays.sort(arr1);
      
      if(arr.length!=arr1.length)
          System.out.println("not equal");
      
      else{
          for(int i=0;i<arr.length;i++)
          {
              if(arr[i]!=arr1[i])
              {
                  flag=1;
                  System.out.println("not equal");
                  break;
              }
          }
          
          if(flag==0)
              System.out.println("equal");
          
      }
      
      
     
    }
    
  public void getobj()
  {
     String str="vikashvivv";
     res= str.chars().
               mapToObj(s->Character.toLowerCase((char)s)).filter(x->x!='v').collect(Collectors.toList()).toArray();
       
       String ss=Arrays.toString(res);
     System.out.println(ss);
     
     
  }  
    
    
}
