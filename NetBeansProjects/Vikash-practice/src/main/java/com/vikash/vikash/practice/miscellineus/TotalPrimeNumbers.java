package com.vikash.vikash.practice.miscellineus;

import java.util.Arrays;
import java.util.Random;

public class TotalPrimeNumbers {


    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        TotalPrimeNumbers totalPrimeNumbers=new TotalPrimeNumbers();

        int[] copy=new int[]{1,2,3,4};

        int[] clone=copy.clone();

        Arrays.fill(clone, 2);

        for(int i=0;i<clone.length;i++){
            System.out.println(copy[i]);
        }
      // Random random=new Random();
       // random.nextInt(0);
    }
}
