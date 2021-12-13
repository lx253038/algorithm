package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: lixin
 * @date: 2021/12/9 9:32 ÏÂÎç
 * @description:
 */
public class LeetCode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));

        int min = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= min) {
                min = intervals[i][1];
            } else {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode435().eraseOverlapIntervals(new int[][]{{1, 2}, {1, 4}, {1, 3}}));
    }
}
