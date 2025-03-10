/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.
We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones
 have weights x and y with x <= y. The result of this smash is:
If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.
 */
package com.vikash.vikash.practice.DP.MaxMin;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            queue.offer(stone);
        }

        System.out.println(queue);

        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();

            if(first-second>0)
            {
                queue.offer(first-second);
            }
        }

        return queue.isEmpty()? 0 : queue.peek();
    }


    //LAST STONE 2:--
    /*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.
     */

    //Intuition:-    get the sum of stones . Divide into two halves, difference will return minimum value.
    public int lastStoneWeightII(int[] stones) {

        int sum=0;
        for (int stone : stones) {
            sum+=stone;
        }

        int target=(int)Math.ceil((double) sum /2);
        int[][] dp=new int[stones.length+1][target+1];
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }

       return getLastStoneWeightII(sum, target, 0, 0, dp , stones);
    }

    private int getLastStoneWeightII(int sum, int target, int i, int currentSum, int[][] dp, int[] stones) {
       if(currentSum>= target || i==stones.length)
              return Math.abs(currentSum-(sum-currentSum));

       if(dp[i][currentSum]!=-1) return dp[i][currentSum];


       dp[i][currentSum]=Math.min(getLastStoneWeightII(sum,target, i+1,currentSum,dp,stones),
               getLastStoneWeightII(sum, target, i+1, currentSum+stones[i],dp, stones));

        return dp[i][currentSum];
    }


    //--------------------TABULATION----------------------------------------------------
    //----------------------------------------------------------------------------------


//
//public int lastStoneWeightIITab(int[] stones) {
//    int totalSum = 0, S2 = 0;
//    //sum up all the stone values
//    for (int stone : stones) totalSum += stone;
//    int n = stones.length;
//    //dp[i][j] represents best sum upto j that you can find for S[0, i - 1]
//    //Hence, our answer would be dp[sum][n].
//    int[][] dp = new int[totalSum + 1][n + 1];
//
////Base Case: We can always find a subset(empty) with sum 0 for any Set S.
//    for (int i = 0; i <= n; i++) {
//        dp[0][i] = 0;
//    }
//
//    for (int i = 1; i <= n; i++) {
//        for (int s = 1; s <= totalSum / 2; s++) {
////if the current stone value is greater than the sum we are
////seeking for, we can always create a subset with given sum
////excluding this stone value if some subset uptill previous stone
//// can form the given sum.
//            if (s < stones[i - 1]) {
//                dp[s][i] = dp[s][i - 1];
//            }
////Else, we create the bezt configuration possible out of including the current stone or excluding it.
//            else {
//                dp[s][i] = Math.max(dp[s][i - 1], dp[s - stones[i - 1]][i - 1] + stones[i - 1]);
//            }
//        }
//    }
//    return totalSum - 2 * dp[totalSum / 2][n]; //Minimum final score.
//
//}

    public int lastStoneWeightIITab(int[] stones) {
        int totalSum = 0, S2 = 0;
        //sum up all the stone values
        for (int stone : stones) totalSum += stone;
        int n = stones.length;
        //dp[i][j] represents best sum upto j that you can find for S[0, i - 1]
        //Hence, our answer would be dp[sum][n].
        int[][] dp = new int[n + 1][totalSum + 1];

//Base Case: We can always find a subset(empty) with sum 0 for any Set S.
        for (int i = 0; i <= totalSum; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum/2; j++) {
                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - stones[i-1]] + stones[i - 1]);
                }
            }
        }
        return totalSum - 2 * dp[n][totalSum/2]; //Minimum final score.

    }


public static void main(String[] args) {

        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int x=lastStoneWeight.lastStoneWeightII(new int[]{31,26,33,21,40});
        System.out.println(x);
    }
}
