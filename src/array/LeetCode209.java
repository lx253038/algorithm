package array;

/**
 * @Author LX
 * @Date 2020/8/11 19:54
 * @Description ����һ������?n?���������������һ��������?s ���ҳ���������������� �� s �ĳ�����С�� ���� �����飬�������䳤�ȡ���������ڷ��������������飬���� 0��
 * ʾ����
 * ���룺s = 7, nums = [2,3,1,2,4,3]
 * �����2
 * ���ͣ�������?[4,3]?�Ǹ������µĳ�����С�������顣
 */
public class LeetCode209 {

    public static void main(String[] args) {
        System.out.println(new LeetCode209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0, sum = 0, min = nums.length + 1;
        while (l < nums.length) {
            if (sum < s && r < nums.length) {
                sum += nums[r++];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                min = Math.min(min, r - l);
            }
        }
        if (min == nums.length + 1) {
            return 0;
        }
        return min;

    }
}
