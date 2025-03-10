package com.vikash.vikash.practice.DP.knapsack;

import java.util.Arrays;
import java.util.Comparator;

/*
A car travels from a starting position to a destination which is target miles east of the starting position.
There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.
The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.
Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.

 */
public class MinRefuellingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Arrays.sort(stations, Comparator.comparingInt(A -> A[0]));
        int res  = recursion(target,startFuel,stations,0,0);
        return res>=Integer.MAX_VALUE/2?-1:res;
    }

    public int recursion(int target,int startFuel,int[][] stations,int currPosition,int index){
        if(target<=startFuel+currPosition)
            return 0;

        if(index>=stations.length)
            return Integer.MAX_VALUE/2;

        int pick = Integer.MAX_VALUE/2;
        int notPick = Integer.MAX_VALUE/2;

        int weCanReach = startFuel+currPosition;
        if(weCanReach>=stations[index][0]){
            pick = 1 + recursion(target,startFuel-(stations[index][0]-currPosition)+stations[index][1],stations,stations[index][0],index+1);
            notPick = recursion(target,startFuel-(stations[index][0]-currPosition),stations,stations[index][0],index+1);
        }

        return Math.min(pick,notPick);
    }

    public static void main(String[] args)
    {
        MinRefuellingStops minRefuellingStops=new MinRefuellingStops();
        int[][] stations=new int[][]{{10,60},{20,30},{30,30},{60,40}};
        int res=minRefuellingStops.minRefuelStops(100, 10, stations);
        System.out.println(res);
    }
}
