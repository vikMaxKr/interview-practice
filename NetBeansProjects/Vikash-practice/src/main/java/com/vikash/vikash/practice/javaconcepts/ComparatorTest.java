package com.vikash.vikash.practice.javaconcepts;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

    public static void main(String[] args) {

        String[] str=new String[]{"54", "32", "101", "543"};

       // int[] arr=new int[]{54, 546, 548, 60};

//        Arrays.sort(str, new Comparator<>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int x=Integer.parseInt(o1);
//                int y=Integer.parseInt(o2);
//                return Integer.compare(y, x);
//            }
//        });

        Arrays.sort(str, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                String xy=o1+o2;
                String yx=o2+o1;
                return yx.compareTo(xy);
            }
        });

        for(int i=0; i<str.length; i++)
        {
            System.out.println(str[i]);
        }

    }
}
