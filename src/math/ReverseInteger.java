package math;
/*
����һ�� 32 λ�з����������������е����ֽ��з�ת��
        ʾ�� 1:����: 123  ���: 321
        ʾ�� 2:����: -123 ���: -321
        ʾ�� 3:����: 120   ���: 21
        ע��:�������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [?231,  231 ? 1]������������裬�����ת�������������򷵻� 0��
*/

public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;

    }

    public static void main(String[] args) {
        ReverseInteger rt = new ReverseInteger();
        int result = rt.reverse(263);
        System.out.println(result);
    }
}
