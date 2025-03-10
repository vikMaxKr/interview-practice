/*
 * The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and
 *  one square vertically (with both forming the shape of an L). The possible movements of chess knight are shown in this diagram:

A chess knight can move as indicated in the chess diagram below:
 */
package com.vikash.vikash.practice.DP.DistinctWays;

public class KnightDailer {

    int mod = 1000000000 + 7;
    int[][] arr= {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
    public int knightDialer(int n) {
        int res=0;
        for(int i=0; i<10; i++){
            res=(res+DFS(i,n-1))%mod;
        } 
        return res;  
    }
    public int DFS(int pos,int n){
        if(n==0){
            return 1;
        }
        int ans=0;
        for(int i=0; i<arr[pos].length; i++){
            ans=(ans+DFS(arr[pos][i],n-1))%mod;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        KnightDailer knightDailer=new KnightDailer();
        knightDailer.knightDialer(3);
    }
    
}
