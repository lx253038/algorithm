package array;

import java.util.Arrays;

/**
 * @Author LX
 * @Date 2020/8/30 19:05
 * @Description ����һ���������飬���������ҳ�����������ɵ����˻������������˻���
 * ʾ�� 1:
 * ����: [1,2,3]
 * ���: 6
 * ȡ������С�ĺ����ģ����Ǹ�����|ȡ3��������
 */
public class LeetCode628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    public int maximumProduct2(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE,
                max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int curr : nums) {
            if (curr < min1) {
                min2 = min1;
                min1 = curr;
            } else if (curr < min2) {
                min2 = curr;
            }
            if (curr > max1) {
                max3 = max2;
                max2 = max1;
                max1 = curr;
            } else if (curr > max2) {
                max3 = max2;
                max2 = curr;
            } else if (curr > max3) {
                max3 = curr;
            }

        }
        return Math.max(max1 * min1 * min2, max1 * max2 * max3);

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode628().maximumProduct2(new int[]{-4, -3, -2, -1, 60}));
    }
}
