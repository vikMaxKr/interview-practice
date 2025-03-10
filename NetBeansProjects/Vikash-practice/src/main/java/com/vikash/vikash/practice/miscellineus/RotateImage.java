/*
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 */

 //Intution
 /*
  * Let size of row and column be 3. 
During first iteration – 
a[i][j] = Element at first index (leftmost corner top)= 1.
a[j][n-1-i]= Rightmost corner top Element = 3.
a[n-1-i][n-1-j] = Rightmost corner bottom element = 9.
a[n-1-j][i] = Leftmost corner bottom element = 7.
Move these elements in the clockwise direction. 
During second iteration – 
a[i][j] = 2.
a[j][n-1-i] = 6.
a[n-1-i][n-1-j] = 8.
a[n-1-j][i] = 4. 
Similarly, move these elements in the clockwise direction. 


  */
package com.vikash.vikash.practice.miscellineus;

public class RotateImage {

    public void rotate(int[][] a) {
        
        int N=a.length;
        
        for (int i = 0; i < N / 2; i++)
    {
        for (int j = i; j < N - i - 1; j++)
        {
 
            // Swap elements of each cycle
            // in clockwise direction
            int temp = a[i][j];
            a[i][j] = a[N - 1 - j][i];
            a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
            a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
            a[j][N - 1 - i] = temp;
        }
    }
        
    }

    public int myAtoi(String s) {
        int flag=0;
        String temp="";
        s.trim();
        if(s.charAt(0)=='-')
        {
            flag=1;
            s=s.substring(1,s.length());
        }
        for(int i=0;i<s.length();i++)
        {
            int ch=(int)s.charAt(i);
            
            if(ch<48 || ch>57)
            {
                break;
            }
            
            if(ch==48)
            {
                continue;
            }
            
            temp=temp+s.charAt(i);
        }

        
        int result=Integer.parseInt(temp);
        
        return flag==0?result:-result;
    }


    public static void main(String[] args)
    {
        RotateImage rotateImage=new RotateImage();
        rotateImage.myAtoi("     -042");
    }


    
}
