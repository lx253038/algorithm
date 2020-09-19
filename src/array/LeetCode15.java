package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/9/17 20:00
 * @Description ����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��ʹ��?a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 * ʾ����
 * �������� nums = [-1, 0, 1, -1, -4, 2]��
 * ����Ҫ�����Ԫ�鼯��Ϊ��
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> reslist = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) continue; // ȥ��
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    reslist.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return reslist;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode15().threeSum(new int[]{0, 0, 0}));
    }
}
