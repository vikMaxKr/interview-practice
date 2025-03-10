/*
Construct all N digit numbers form given input
Ex:- input="abcdef",  N=2
output:-
ab ac ad ae af bc bd be bf cd ce cf de df ef
 */
package com.vikash.vikash.practice.BackTrack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NdigitNumber {

        public static void main(String[] args) {
            String input = "abcdef";
            List<String> result = new ArrayList<>();
            generateCombinations(input, 0, "", result);
            Collections.sort(result);
            result.forEach(System.out::println);
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(1);
//            list.add(2);
//            list.add(3);
//            list.add(3);
            //formingMagicSquare();
        }

    private static void generateCombinations(String input, int index, String current, List<String> result) {

        if (current.length() == 2) {
            result.add(current);
            return;
        }
        if (index >= input.length()) {
            return;
        }
        // Include the current character and move to the next
        current+=input.charAt(index);
        generateCombinations(input, index + 1, current, result);
        current=current.substring(0, current.length()-1);
        // Exclude the current character and move to the next
        generateCombinations(input, index + 1, current, result);
    }

//-------------------------------------------------------------------------------------------
    public static int formingMagicSquare() {
        // Write your code here

        List<List<Integer>> ls=new ArrayList<>();
        int[] input=new int[]{1,2,3,4,5,6,7,8,9};
        generateAllCombinations(ls, input, new ArrayList<>(),0,0);

        for (List<Integer> l : ls) {
            for (Integer integer : l) {
                System.out.println(integer);
            }
        }

        System.out.println("output");

        return 0;
    }

    private static void generateAllCombinations(List<List<Integer>> s,int[] input,List<Integer> ls,
                                                int index,int sum)
    {

        if(ls.size()==3 && sum==15)
        {
            s.add(new ArrayList<>(ls));
            return;
        }else {
            for (int i = index; i <= 3; i++) {
                sum += input[index];
                ls.add(input[index]);
                generateAllCombinations(s, input, ls, index + 1, sum);
                sum -= ls.get(ls.size() - 1);
                ls.remove(ls.get(ls.size() - 1));
            }
        }
    }


}

