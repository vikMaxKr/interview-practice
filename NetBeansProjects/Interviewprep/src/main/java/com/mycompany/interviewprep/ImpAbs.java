/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep;

/**
 *
 * @author vikashkumar
 */
public class ImpAbs extends test1 {
    
    @Override
    public void doabs()
    {
        System.out.println("calling abstrct");
    }
    
    public static void main(String[] args)
    {
        ImpAbs imp=new ImpAbs();
        imp.doabs();
        imp.getdetail();
        
    }
    
}
