package com.vikash.vikash.practice.BackTrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a keypad as shown in the diagram, and an N digit number which is represented by array a[],
the task is to list all words which are possible by pressing these numbers.
 */
public class PossibleWordsFromPhoneDigit {

    private static String[] phoneDigits = new String[]
            {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static ArrayList<String> possibleWords(int[] a, int N) {
       ArrayList<String> possibleWords = new ArrayList<>();
        generateCombinations(0,a,N,"",possibleWords);
        Collections.sort(possibleWords);
        return possibleWords;
    }

    private static String findWords(int i) {
        return phoneDigits[i - 2];
    }

    private static void generateCombinations(int index, int[]  a, int N, String input, List<String> result) {
        if(index >= N) {
            result.add(input);
            return;
        }
        String combination = findWords(a[index]);
        for(int j = 0; j < combination.length(); j++) {
            input+=combination.charAt(j);
            generateCombinations(index+1,a,N,input,result);
            input=input.substring(0,input.length()-1);
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{2,4};
       System.out.println(possibleWords(a,2));
    }

}
