/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dynamicp;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author vikashkumar
 */
enum Test {
    
    ART("art"),
    GALLARY("gallary");
    
     private Test(String name)
    {
        this.name=name;
    }
    
    private String name;

    public String getName() {
        return name;
    }
     
    
}

public class Testenum< T extends List>
        
{
    public static void main(String[] args)
    {
        Test.ART.getName();
        Test.GALLARY.getName();
        Employee<?> emp=new Employee<Object>();
//       List<> list=new ArrayList<Employee>();
//       list.add(new Employee());
//       list.add("aaa");
//       // list.add(1);
    }
}

