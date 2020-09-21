package math;

/**
 * @Author LX
 * @Date 2020/9/20 14:12
 * @Description ����һ�����飬���ĵ�?i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 * ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * ʾ�� 1:
 * ����: [7,1,5,3,6,4]
 * ���: 7
 * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 3 �죨��Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
 * ?    ����ڵ� 4 �죨��Ʊ�۸� = 3����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ��ʽ������ܻ������ = 6-3 = 3 ��
 */
public class LeetCode122 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
