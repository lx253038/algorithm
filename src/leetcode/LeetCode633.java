package leetcode;

/**
 * @author: lixin
 * @date: 2021/12/29 9:19 обнГ
 * @description:
 */
public class LeetCode633 {


    public boolean judgeSquareSum(int c) {
        long a = 0, b = (long) Math.sqrt(c);
        while (a <= c && b >= 0) {
            long sum = a * a + b * b;
            if (sum == c) {
                return true;
            }
            if (sum > c) {
                b--;
            } else {
                a++;
            }

        }
        return false;
    }
}
