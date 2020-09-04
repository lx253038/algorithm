package Queue;

import java.util.*;

/**
 * @Author LX
 * @Date 2020/9/3 20:36
 * @Description 给定一个非空的整数数组，返回其中出现频率前?k?高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class LeetCode347 {


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(x -> -x.getValue()));
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode347().topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 3}, 2)));
    }
}
