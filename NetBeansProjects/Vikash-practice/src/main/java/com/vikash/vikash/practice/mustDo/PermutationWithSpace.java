/*
Given a string s, you need to print all possible strings that can be made by placing spaces (zero or one) in between them.
 The output should be printed in sorted increasing order of strings.
 s = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
 */
package com.vikash.vikash.practice.mustDo;

import java.util.ArrayList;

public class PermutationWithSpace {

    ArrayList<String> permutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        findPermutations(0,s,"",result);
        result.forEach(System.out::println);
        return result;
    }

    private void findPermutations(int index,String s, String s1, ArrayList<String> result) {

        if (index == s.length()-1) {
              s1 += s.charAt(index);
            result.add(s1);
            return;
        }
        s1=s1+s.charAt(index);
        findPermutations(index+1,s,s1+" ",result);
        findPermutations(index+1,s,s1,result);
    }

    public static void main(String[] args) {
        PermutationWithSpace permutationWithSpace = new PermutationWithSpace();
        permutationWithSpace.permutation("abc");

    }
}
