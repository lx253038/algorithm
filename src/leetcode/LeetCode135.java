package leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author: lixin
 * @date: 2021/12/8 9:13 обнГ
 * @description:
 */
public class LeetCode135 {


    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int j = ratings.length - 1; j > 0; j--) {
            if (ratings[j - 1] > ratings[j]) {
                arr[j - 1] = Math.max(arr[j] + 1, arr[j - 1]);
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode135().candy(new int[]{1, 2, 3, 1}));
    }
}
