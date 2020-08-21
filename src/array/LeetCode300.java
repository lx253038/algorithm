package array;

/**
 * @Author LX
 * @Date 2020/8/16 19:48
 * @Description ����һ��������������飬�ҵ���������������еĳ��ȡ�
 * ʾ��:
 * ����: [10,9,2,5,3,7,101,18]
 * ���: 4
 * ����: ���������������?[2,3,7,101]�����ĳ����� 4��
 * ˵��:
 * ���ܻ��ж�������������е���ϣ���ֻ��Ҫ�����Ӧ�ĳ��ȼ��ɡ�
 * ���㷨��ʱ�临�Ӷ�Ӧ��Ϊ?O(n2) ��
 */
public class LeetCode300 {

    public static void main(String[] args) {
        System.out.println(new LeetCode300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
