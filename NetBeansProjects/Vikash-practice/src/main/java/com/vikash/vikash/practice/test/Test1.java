package com.vikash.vikash.practice.test;

import java.util.*;

public class Test1 {

    private FinalClass finalClass;

    public Test1(FinalClass finalClass)
    {
        this.finalClass = finalClass;
    }


    public static void main(String[] args)
    {
        FinalClass finalClass1=new FinalClass();
        finalClass1.getName();
        int x=10;
        int y=10;
        System.out.println();
        System.out.println(x*y);
        String[] str=new String[]{"9","456","458","45","60"};
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String a=o1+o2;
                String b=o2+o1;
                return a.compareTo(b);
            }
        });
    }

    void useStatic()
    {
        System.out.println(finalClass.getName());
    }
}
