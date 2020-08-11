package array;

/**
 * @Author LX
 * @Date 2020/8/11 19:54
 * @Description 给定一个含有?n?个正整数的数组和一个正整数?s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组?[4,3]?是该条件下的长度最小的子数组。
 */
public class LeetCode209 {

    public static void main(String[] args) {
        System.out.println(new LeetCode209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0, sum = 0, min = nums.length + 1;
        while (l < nums.length) {
            if (sum < s && r < nums.length) {
                sum += nums[r++];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                min = Math.min(min, r - l);
            }
        }
        if (min == nums.length + 1) {
            return 0;
        }
        return min;

    }
}
