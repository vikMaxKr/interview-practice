/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author vikashkumar
 */
public class Java8features {

    public static void main(String[] args) {
        
        List<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(50);
        
         
        List<String> list2=new ArrayList<>();
        list2.add("Saket");
        list2.add("Saurav");
        list2.add("Softwaretestinghelp");
        list2.add("Steve");
        
       //list.stream().distinct().forEach(x->System.out.println(x));
       
      // Stream.concat(list.stream(), list2.stream()).forEach(x->System.out.println(x));
       //System.out.println(result);
       
     long num=  list2.stream().filter(x->x.length()>5).count();
     
    // list.stream().sorted().collect(Collectors.toList()).forEach(x->System.out.print(x));
     
     
    // System.out.println(num);
//     
//     StringJoiner str=new StringJoiner(",","(",")");
//     str.add("vikash");
//     str.add("kumar");
//     Stream.of(str).forEach(System.out::println);
//     
//     Stream.of(1,2,3,4).min(Comparator.comparing(Integer::valueOf)).get();
//     Stream.of(1, 2, 3, 77, 6, 5).min(Comparator.comparing(Integer::valueOf))
//                        .get();
//     
//       list.stream().mapToInt(x->x).sum()
//       

list
        .stream().map(x->x.toString())
        .filter(x->x.startsWith("1"))
        .forEach(System.out::println);


Set<Integer> set=new HashSet<>();

list
        .stream().map(x->!set.add(x))
        .forEach(System.out::println);
       
       // .stream().findFirst().ifPresentOrElse(System.out.print(x), System.out.println("vik"));
       
       List<NotesDTO> dto=new ArrayList<>();
       
       dto.add(new NotesDTO(1,"note1",11));
        dto.add(new NotesDTO(2,"note2",22));
         dto.add(new NotesDTO(3,"note3",33));
          dto.add(new NotesDTO(4,"note4",44));
           dto.add(new NotesDTO(5,"note3",55));
           
        Map<String,Integer> keys=  dto.stream()
                
                   .sorted(Comparator.comparingInt(NotesDTO::getAmount).reversed())
                
                   .collect(Collectors.toMap(NotesDTO::getName,NotesDTO::getId,
                           (oldValue,newValue)->oldValue
                           ,LinkedHashMap::new
                   
                   ));
           
           System.out.println(keys);
           
           int[] arr={1,2,3,4,5,6};
         int[] rr=  Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1)
                   .mapToInt(Integer::intValue).toArray();
         
         System.out.println(rr);
                   
        
    }
   
    
}
