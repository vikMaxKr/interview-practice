package com.vikash.vikash.practice.miscellineus;

import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {

int[] twoSum(int[] num , int target){
   Map<Integer, Integer> map=new LinkedHashMap<>();
   int[] ret=new int[2];
   for(int i=0;i<num.length;i++)
   {
       if(map.containsKey(target-num[i]))
       {
            ret[0]=map.get(target-num[i]);
            ret[1]=i;
       }
       else{
        map.put(num[i], i);
       }
   }

   return ret;
    }
    
}
