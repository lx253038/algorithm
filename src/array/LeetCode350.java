package array;

import java.util.*;

/**
 * @Author LX
 * @Date 2020/8/12 18:17
 * @Description 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 */
public class LeetCode350 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode350().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                res.add(nums2[i]);
                int val = map.get(nums2[i]);
                if (val > 1) {
                    map.put(nums2[i], val - 1);
                } else {
                    map.remove(nums2[i]);
                }
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
