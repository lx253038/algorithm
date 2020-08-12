package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author LX
 * @Date 2020/8/12 18:17
 * @Description 给定两个数组，编写一个函数来计算它们的交集。
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 */
public class LeetCode349 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode349().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] result = new int[res.size()];

        int a = 0;
        for (Integer integer : res) {
            result[a++] = integer;
        }
        return result;
    }
}
