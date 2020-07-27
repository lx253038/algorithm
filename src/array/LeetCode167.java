package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LX
 * @Date 2020/7/27 21:03
 * @Description
 */
public class LeetCode167 {

    public static void main(String[] args) {
        System.out.println(new LeetCode167().twoSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(new LeetCode167().twoSum2(new int[]{2, 7, 11, 15}, 9));

    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]), i + 1};

            }
            map.put(target - numbers[i], i + 1);
        }
        return new int[]{0, 0};
    }
}
