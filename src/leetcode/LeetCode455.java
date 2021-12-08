package leetcode;

import java.util.Arrays;

/**
 * @author: lixin
 * @date: 2021/12/8 8:38 обнГ
 * @description:
 */
public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (g[child] < s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }


}
