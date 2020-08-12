package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author LX
 * @Date 2020/8/12 20:02
 * @Description ����һ�����������һ������?k���ж��������Ƿ����������ͬ������?i?��?j��ʹ��?nums [i] = nums [j]������ i �� j?�Ĳ�� ����ֵ ����Ϊ k��
 * ʾ��?1:
 * ����: nums = [1,2,3,1], k = 3
 * ���: true
 */
public class LeetCode219 {
    public static void main(String[] args) {
        System.out.println(new LeetCode219().containsNearbyDuplicate2(new int[]{1, 1, 1, 1}, 0));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0;
        while (l < nums.length) {
            if (r < nums.length) {
                if (set.contains(nums[r])) {
                    return true;
                }
                set.add(nums[r++]);
            } else {
                set.remove(nums[l++]);
            }
            if (r - l > k) {
                set.remove(nums[l++]);
            }
        }
        return false;

    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

    }
}
