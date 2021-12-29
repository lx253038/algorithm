package leetcode;

/**
 * @author: lixin
 * @date: 2021/12/20 8:58 обнГ
 * @description:
 */
public class LeetCode122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                sum += prices[i] - prices[i - 1];
            }

        }

        return sum;

    }

}
