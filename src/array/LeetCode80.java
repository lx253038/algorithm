package array;

/**
 * @Author LX
 * @Date 2020/8/10 19:44
 * @Description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode80 {

    public static void main(String[] args) {
        System.out.println(new LeetCode80().removeDuplicates(new int[]{1, 1, 1, 1, 1, 1}));

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 1] || nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    /**
     * 升级重复元素最多不能超过k个
     *
     * @param nums
     * @param k
     * @return
     */
    public int removeDuplicates(int[] nums, int k) {
        if (nums.length <= k) return nums.length;
        int index = k;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != nums[index - k]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
