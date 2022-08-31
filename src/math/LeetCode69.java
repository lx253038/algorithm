package math;

/**
 * @Author LX
 * @Date 2020/9/21 20:55
 * @Description ʵ��?int sqrt(int x)?������
 * ���㲢����?x?��ƽ����������?x �ǷǸ�������
 * ���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
 * ʾ�� 1:
 * ����: 4
 * ���: 2
 * ʾ�� 2:
 * <p>
 * ����: 8
 * ���: 2
 * ˵��: 8 ��ƽ������ 2.82842...,
 * ?    ���ڷ���������������С�����ֽ�����ȥ��
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        long l = 0, r = x;
        while (l <=r) {
            long middle = (l + r) / 2;
            if (middle * middle == x) {
                return (int) middle;
            } else if (middle * middle > x) {
                r=middle-1;
            } else {
                l=middle+1;
            }
        }
        return (int) (l-1);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode69().mySqrt(0));
    }

}