/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 Note that k is guaranteed to be a positive integer.
 Input: s = "3[a]2[bc]"
Output: "aaabcbc"
 */
package com.vikash.vikash.practice.mustDo;
import java.util.Objects;
import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodedString("1[b]1[c]"));
    }

    static String decodedString(String s){
        // code here
        StringBuilder result;
        StringBuilder str= new StringBuilder();
        StringBuilder number= new StringBuilder();
        Stack<String> numbers = new Stack<>();
        Stack<String> digits = new Stack<>();
        int length = s.length();
        int index = 0;
        while(index < length){
            if(Character.isDigit(s.charAt(index))){
                number.append(s.charAt(index));
            }else{
                if(!number.isEmpty())
                {
                    numbers.push(number.toString());
                    number = new StringBuilder();
                }
                char ch=s.charAt(index);
                if(ch==']'){
                    int digitLength = digits.size();
                    while(digitLength>0 && !Objects.equals(digits.peek(), "["))
                    {
                        str.insert(0, digits.pop());
                    }
                    digits.pop();
                    int noTimes=Integer.parseInt(numbers.pop());
                    result = new StringBuilder();
                    result.append(str.toString().repeat(Math.max(0, noTimes)));
                    digits.push(result.toString());
                    str = new StringBuilder();
                }else {
                    digits.push(s.substring(index, index + 1));
                }
            }
            index++;
        }
        result = new StringBuilder();
        while(!digits.isEmpty()){
            result.append(digits.pop());
        }
        return result.toString();
    }


}
