package array;

import java.util.TreeSet;

/**
 * @Author LX
 * @Date 2020/8/12 20:02
 * @Description 在整数数组 nums 中，是否存在两个下标 i 和 j，使得?nums [i] 和?nums [j]?的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ? 。
 * 如果存在则返回 true，不存在返回 false。
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 */
public class LeetCode220 {
    public static void main(String[] args) {
        System.out.println(new LeetCode220().containsNearbyAlmostDuplicate(new int[]{1, 2147483647}, 1, 2147483647));
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long res = treeSet.ceiling((long) nums[i] - (long) t);
            if (res != null && res <= (long) nums[i] + (long) t) {
                return true;
            }
            treeSet.add((long) nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
