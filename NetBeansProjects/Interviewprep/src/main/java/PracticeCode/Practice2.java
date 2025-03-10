/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author vikashkumar
 */
public class Practice2 {
    
    public static void main(String[] args)
   {
//        Map<String, Integer> m=new HashMap<>();
//        m.put("vik", 5);
//        m.put("kr", 1);
//        m.put("vik",6);
//        System.out.println(m);
//       LinkedHashMap<String,Integer> result= m.entrySet().stream().sorted((a,b)->{
//            return a.getValue()-b.getValue();
//                    })
//                .collect
//        (Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e2,LinkedHashMap::new));
//       
//       System.out.println(result);
//       
//       List<Integer> list=new ArrayList<>();
//      list.add(2);
//      list.add(3);
//      list.add(5);
//      double res=list.stream().map(x->x*x).filter(x->x>=100).mapToInt(x->x).summaryStatistics().getAverage();
//      
//      System.out.println(res);
//              //forEach(System.out::println);
//              
//              List<Integer> list1=Arrays.asList(1,2,3,4,4);
//               List<Integer> list2=Arrays.asList(5,6,7,8,8);
//               
//             Set<Integer> output=  Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toSet());
//             
//           int high=  output.stream().max((a,b)->a-b).get();
//           int low=output.stream().min((a,b)->a-b).get();
//             
//              
//       System.out.println(high+"---"+low);
//       
//       StringJoiner str=new StringJoiner(",");
//       
//       str.add("A");
//       str.add("B");
//       str.add("C");
//       
//         StringJoiner str1=new StringJoiner(":","(","}");
//         
//         
//       str1.add("A").add("D");
//       str1.add("B");
//       str1.add("C");
//       
//      StringJoiner sh= str.merge(str1);
//       
//         System.out.println(sh);
//         
//         
         
        List<Integer> list1=Arrays.asList(1,2,3,4,4);
              List<Integer> list2=Arrays.asList(5,6,2,8,8);
             Set<Integer> a=list1.stream().collect(Collectors.toSet());
            Set<Integer> b= list2.stream().collect(Collectors.toSet());
              a.stream().filter(x->!b.add(x)).forEach(x->System.out.println(x));
         
       
    }
    
}
