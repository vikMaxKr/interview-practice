package com.vikash.vikash.practice.javaconcepts;

import java.sql.SQLOutput;
import java.util.*;

public class Driver implements OverridingTest{

    @Override
    public String getString(String str)
    {
        return "";
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,12);
        map.put(1,13);

        for(Integer key: map.keySet())
        {

        }

        for(Map.Entry set: map.entrySet())
        {

        }

        System.out.println(map.get(1));
        List<Object> list=new ArrayList<>(10);
        list.add("123");
        list.add(2);
        list.add(null);

       // System.out.println(list.get(2));
        Queue<Integer> q=new PriorityQueue<>();
        q.offer(1);
        q.offer(3);
        q.offer(2);

        Iterator<Integer> it=q.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
            it.remove();;
        }

        q.offer(8);

        System.out.println(q);

        String str1="Vik";
        str1.concat("kr");
        System.out.println(str1);

        StringBuilder sb=new StringBuilder("Vik");
        sb.append("kr");
        System.out.println(sb);


        String str=20+23+"java"+20*23+"vik";
        Singleton sig=Singleton.getInstance();
        Singleton sig1=Singleton.getInstance();
        System.out.println(str);

        Demo demo=new Demo("Vikash", "Kumar");
        Cloning clone=new Cloning("123", demo);
        Cloning cloned=clone.deepClone();
        cloned.setId("345");

        System.out.println(clone.getId());
        System.out.println(cloned.getId());

        Driver driver=new Driver();
        driver.varargsTest(1,2,3,4,5,6,7,8,9);

    }

    private void varargsTest(int... num)
    {

        String[] name=new String[]{"Vika","Kr"};
        for(String nm: name) {
            switch (nm) {
                case "Vik":
                    System.out.println(1);
                    //break;
                case "Kr":
                    System.out.println(2);
                   // break;
                case "Sin":
                    System.out.println(3);
                    //break;
                default:
                    System.out.println(1444);
            }
        }
    }
}
