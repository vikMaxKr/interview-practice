/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vikashkumar
 */
public class Matchers {
    
    public static void main(String[] args)
    {
        Pattern pattern=Pattern.compile("geeks");
        Matcher m=pattern.matcher("geeksforgeeks");
        while(m.find())
        {
            System.out.println("start"+m.start()+"end"+m.end());
        }
        
        Book book1=new Book("harry",12);
        Book book2=new Book("harry",12);
        
        Set<Book> set=new HashSet<>();
        
        set.add(book2);
        set.add(book1);
        Iterator it=set.iterator();
        while(it.hasNext())
        {
            Book b1=(Book)it.next();
           System.out.println(b1.getName()+"   "+b1.getValue());
        }
        
        
        
        
        
    }
    
}
