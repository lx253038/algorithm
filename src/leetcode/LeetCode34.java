package leetcode;

import java.util.Arrays;

/**
 * @author: lixin
 * @date: 2022/2/9 8:45 ÏÂÎç
 * @description:
 */
public class LeetCode34 {


    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftIndex = searchLeft(nums, target, left, right);
        int rightIndex = searchRight(nums, target, left, right);

        return new int[]{leftIndex, rightIndex};
    }


    public int searchLeft(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                int ans = searchLeft(nums, target, left, middle - 1);
                return ans != -1 ? ans : middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;

    }

    public int searchRight(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                int ans = searchRight(nums, target, middle + 1, right);
                return ans != -1 ? ans : middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{5}, 5)));
    }
}
