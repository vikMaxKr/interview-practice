/*
 * Find binary representation of a given number
 */
package com.vikash.vikash.practice.bitManipulation;

public class BinaryRepresentation {

    static int number1=0;

    //find binary representation
    void findBinary(int num, StringBuilder sb)
    {
        if(num>1)
        {
            findBinary(num/2, sb);
        }   

        sb.append(num%2);
    }

    //count no of 1s
     void countNo1s(int num)
    {
        if(num>1)
        {
            countNo1s(num>>1);
        } 
        
        if(num%2!=0) number1++;
    }

    //Add two binary 

     
    String addBinary(String A, String B) {
        // code here
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        StringBuilder res=new StringBuilder();
        
        makeStringEqual(A, B, sb1, sb2);
        String AA=sb1.toString();
        String BB=sb2.toString();
        int carry=0;
        
        for(int i=AA.length()-1;i>=0;i--)
        {
            int bitA=AA.charAt(i)-'0';
            int bitB=BB.charAt(i)-'0';
            int sum=(bitA ^ bitB ^ carry);
            
            carry=(bitA & bitB )| (bitA & carry ) | (bitB & carry);
            res.append(sum);
            
        }
        
        if(carry==1)
        {
            
            res.append("1");
        }
        
        int count=0;
        
        for(int i=res.length()-1;i>=0;i--)
        {
            if(res.charAt(i)!='1')
            {
                count++;
            }
            else{
                break;
            }
        }
        return res.reverse().substring(count,res.length());
        
    }
    
    private void makeStringEqual(String A, String B, StringBuilder sb1, StringBuilder sb2)
    {
        int lA=A.length();
        int lB=B.length();
        
        if(lA==lB) {
            sb1.append(A);
            sb2.append(B);
            return;
        }
        if(lA<lB)
        {
            int remain=lB-lA;
            
            for(int i=0;i<remain;i++)
            {
                sb1.append("0");
            }
        }
        
        if(lB<lA)
        {
            int remain=lA-lB;
            
            for(int i=0;i<remain;i++)
            {
                sb2.append("0");
            }
        }
        
        sb1.append(A);
        sb2.append(B);
    }


    public static void main(String[] args)
    {
        BinaryRepresentation binaryRepresentation=new BinaryRepresentation();
        StringBuilder sb=new StringBuilder();
       // binaryRepresentation.findBinary(8, sb);
        //binaryRepresentation.countNo1s(6);
        //System.out.println(""+number1);
        binaryRepresentation.addBinary("01001001", "0110101");
        System.out.println(10<<1);

        String str="a";
        str="b";
        System.out.println(str);

    }
    
}
