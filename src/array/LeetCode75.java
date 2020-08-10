package array;

import java.util.Arrays;

/**
 * @Author LX
 * @Date 2020/8/10 20:07
 * @Description ����һ��������ɫ����ɫ����ɫ��һ��?n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
 * �����У�����ʹ������ 0��?1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
 * ����ʹ�ô�����е����������������⡣
 * ʾ��:
 * ����: [2,0,2,1,1,0]
 * ���: [0,0,1,1,2,2]
 */
public class LeetCode75 {

    public static void main(String[] args) {
        new LeetCode75().sortColors2(new int[]{1, 2, 0});
    }

    public void sortColors(int[] nums) {
        int[] colorArr = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colorArr[nums[i]] = ++colorArr[nums[i]];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < colorArr[0]) {
                nums[i] = 0;
            } else if (i < colorArr[1] + colorArr[0]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

    }

    public void sortColors2(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (i <= p2) {
                if (nums[i] == 0) {
                    if (i == p1) {
                        p1++;
                    } else {
                        int tmp = nums[i];
                        nums[i] = nums[p1];
                        nums[p1++] = tmp;
                    }
                } else if (nums[i] == 2) {
                    int tmp = nums[i];
                    nums[i--] = nums[p2];
                    nums[p2--] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors3(int[] nums) {

        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else curr++;
        }
    }

}
