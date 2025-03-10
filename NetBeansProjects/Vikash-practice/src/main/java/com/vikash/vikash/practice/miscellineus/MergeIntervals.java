package com.vikash.vikash.practice.miscellineus;

import java.util.ArrayList;
import java.util.*;

public class MergeIntervals {

        public int[][] merge(int[][] intervals) {
            List<List<Integer>> ls= new ArrayList<>();

            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    // Compare the first element of each row for sorting
                    return Integer.compare(a[0], b[0]);
                }
            });

            for (int[] interval : intervals) {

                if (ls.isEmpty() || interval[0] > ls.get(ls.size() - 1).get(1)) {
                    ls.add(Arrays.asList(interval[0], interval[1]));
                } else {
                    ls.get(ls.size() - 1).set(1, Math.max(ls.get(ls.size() - 1).get(1), interval[1]));
                }
            }

            int[][] res=new int[ls.size()][2];
            for(int i=0; i<ls.size();i++)
            {
                res[i][0]=ls.get(i).get(0);
                res[i][1]=ls.get(i).get(1);
            }

            return res;

        }

    public static void main(String[] args)
    {
        MergeIntervals mergeIntervals=new MergeIntervals();
        int[][] intervals=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        mergeIntervals.merge(intervals);
    }
}
