package array;

/**
 * @Author LX
 * @Date 2020/8/3 21:18
 * @Description ��������������������?nums1 �� nums2�����㽫 nums2 �ϲ���?nums1?�У�ʹ nums1 ��Ϊһ���������顣
 * ��ʼ��?nums1 �� nums2 ��Ԫ�������ֱ�Ϊ?m �� n ��
 * ����Լ���?nums1?���㹻�Ŀռ䣨�ռ��С���ڻ����?m + n�������� nums2 �е�Ԫ�ء�
 * ����:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * ���:?[1,2,2,3,5,6]
 */
public class LeetCode88 {

    public static void main(String[] args) {

        new LeetCode88().merge2(new int[]{1, 2, 3, 0, 0, 0, 0, 0}, 3, new int[]{2, 5, 6, 7, 8}, 5);
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
    }


}
