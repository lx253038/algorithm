package array;

/**
 * @author LX
 * @date 2018-11-22 14:32
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Integer result = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (result == null || nums[i] * nums[i + 1] > result) {
                result = nums[i] * nums[i + 1];
            }
        }

        return result;

    }
}
