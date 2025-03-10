/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java8features;

/**
 *
 * @author vikashkumar
 */
public  class Test2 {
    
  public static void main(String[] args)
  {
      String date="26-02-2000";
      int add=5;
      String[] dates=date.split("-");
      String month=monthCheck(dates[1]);
      System.out.println(month);
      String day="";
     if(month.equals("12"))
     {
         int val=Integer.valueOf(dates[0]);
         
         if(val>27)
         {
             day="0"+String.valueOf(add-(31-val))+"-"+"01"+"-"+String.valueOf(Integer.valueOf(dates[2])+1);
         }
         else
         {
              day=add+val+"-"+month+"-"+dates[2];
         }
         
     }
     
     
     if(month.equals("01"))
     {
         int val=Integer.valueOf(dates[0]);
         if(val>27)
         {
             day="0"+String.valueOf(add-(31-val))+"-"+"02"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }
         
     }
     if(month.equals("02"))
     {
         int val=Integer.valueOf(dates[0]);
         int year=Integer.valueOf(dates[2]);
        boolean isleep=false;
             if(year%4==0)
             {
                 
                 if(year%100==0)
                 {
                     if(year%400==0)
                     {
                         isleep=true;
                        
                     }
                 }
             }
             
             if(isleep)
             {
                 if(val>25)
                 {
                      day="0"+String.valueOf(add-(29-val))+"-"+"03"+"-"+dates[2];
                 }
                 else
                 {
                       day=add+val+"-"+month+"-"+dates[2];
                 }
             }
       
         else
         {
             if(val>24)
             {
                 day="0"+String.valueOf(add-(28-val))+"-"+"03"+"-"+dates[2];
             }
             else
             day=add+val+"-"+month+"-"+dates[2];
         }
         
         
     }
     if(month.equals("03"))
     {
       int val=Integer.valueOf(dates[0]);
          if(val>27)
         {
             day="0"+String.valueOf(add-(31-val))+"-"+"04"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }  
     }
     if(month.equals("04"))
     {
         int val=Integer.valueOf(dates[0]);
          if(val>26)
         {
             day="0"+String.valueOf(add-(30-val))+"-"+"02"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }
     }
     if(month.equals("05"))
     {
         int val=Integer.valueOf(dates[0]);
          if(val>27)
         {
             day="0"+String.valueOf(add-(31-val))+"-"+"06"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }
     }
     
     if(month.equals("06"))
     {
         int val=Integer.valueOf(dates[0]);
          if(val>26)
         {
             day="0"+String.valueOf(add-(30-val))+"-"+"07"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }
     }
     if(month.equals("07"))
     {
         int val=Integer.valueOf(dates[0]);
          if(val>27)
         {
             day="0"+String.valueOf(add-(31-val))+"-"+"08"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }
     }
     if(month.equals("08"))
     {
         int val=Integer.valueOf(dates[0]);
          if(val>27)
         {
             day="0"+String.valueOf(add-(31-val))+"-"+"09"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }
     }
     if(month.equals("09"))
     {
         int val=Integer.valueOf(dates[0]);
          if(val>27)
         {
             day="0"+String.valueOf(add-(30-val))+"-"+"10"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }
     }
      if(month.equals("10"))
     {
         int val=Integer.valueOf(dates[0]);
          if(val>27)
         {
             day="0"+String.valueOf(add-(31-val))+"-"+"11"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }
     }
       if(month.equals("11"))
     {
         int val=Integer.valueOf(dates[0]);
          if(val>27)
         {
             day="0"+String.valueOf(add-(31-val))+"-"+"12"+"-"+dates[2];
         }
         else
         {
             day=add+val+"-"+month+"-"+dates[2];
         }
     }
     System.out.println(day);
     
  }
  
  private static String monthCheck(String month)
  {
      String value="";
      switch(month)
      {
             case "01":
             {
              value="01";
              break;
             }
             
              case "02":
             {
              value="02";
              break;
             }
              case "03":
             {
              value="03";
              break;
             }
              case "04":
             {
              value="04";
              break;
             }
              case "05":
             {
              value="05";
              break;
             }
              case "06":
             {
              value="06";
              break;
             }
              case "07":
             {
              value="07";
              break;
             }
              case "08":
             {
              value="08";
              break;
             }
              case "09":
             {
              value="09";
              break;
             }
              case "10":
             {
              value="10";
              break;
             }
              case "11":
             {
              value="11";
              break;
             }
              case "12":
             {
              value="12";
              break;
             }
              
              
      }
      
      return value;
  }
    
}
