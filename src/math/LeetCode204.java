package math;

import java.util.Arrays;

/**
 * @Author LX
 * @Date 2020/7/28 21:32
 * @Description 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class LeetCode204 {

    public static void main(String[] args) {
        System.out.println(new LeetCode204().countPrimes(10));
    }


    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            for (int j = i * 2; j < n; j = j + i) {
                isPrime[j] = false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }


}
