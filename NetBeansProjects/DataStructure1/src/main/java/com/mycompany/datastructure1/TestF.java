/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datastructure1;

/**
 *
 * @author vikashkumar
 */
public class TestF {
    
    
    public static void main(String[] args)
    {
        int  prime=1;
        int n=4;
      for(int i=2;i<n;i++)
      {
          if(n%i==0)
              prime=0;
          
      }
      
      System.out.println(prime);
    }
    
}
