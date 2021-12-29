package leetcode;

import sun.net.TelnetInputStream;

/**
 * @author: lixin
 * @date: 2021/12/20 9:26 обнГ
 * @description:
 */
public class LeetCode665 {

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            if (i == 1 || nums[i] >= nums[i - 2]) {
                nums[i - 1] = nums[i];
            } else {
                nums[i] = nums[i - 1];
            }
            if (++count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode665().checkPossibility(new int[]{3, 4, 2, 3}));
    }

}
