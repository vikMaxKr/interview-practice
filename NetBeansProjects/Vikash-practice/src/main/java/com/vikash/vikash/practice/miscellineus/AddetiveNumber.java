/*
 * An additive number is a string whose digits can form an additive sequence.

A valid additive sequence should contain at least three numbers. 
Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits, return true if it is an additive number or false otherwise.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 */
package com.vikash.vikash.practice.miscellineus;

public class AddetiveNumber {

    public boolean isAdditiveNumber(String num) {

        long num1=0;
        for(int i=0;i<num.length()-1 ;i++)
        {
            num1=num1*10+(num.charAt(i)-'0');
           long num2=0;
           for(int j=i+1;j<num.length();j++)
           {
                num2=num2*10+(num.charAt(j)-'0');
  
                if(isValid(num1, num2, num, j+1, 2))
                {
                     return true;
                }
               if(num2==0) break;
           }
          if(num1==0) break;
        }
          return false;
      }
  
      private boolean isValid(long num1, long num2, String num, int index, int count)
      {
  
          if(index>=num.length())
          {
              if(count>=3)
              {
                  return true;
              }
              return false;
          }
  
          long sum=num1+num2;
          if(num.charAt(index)=='0' && sum!=0)
          {
            return false;
          }
          long temp=0;
          for(int i=index;i<num.length();i++)
          {
              temp=temp*10+(num.charAt(i)-'0');
  
              if(temp==sum && isValid(num2, sum, num, i+1, count+1))
              {
                  return true;
              }
              else if(temp>sum)
              {
                 break;
              }
  
          }
          return false;
      }

    public static void main(String[] args)
    {
        AddetiveNumber addetiveNumber=new AddetiveNumber();
        addetiveNumber.isAdditiveNumber("111");

    }
    
}
