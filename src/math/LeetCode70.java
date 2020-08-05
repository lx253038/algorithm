package math;

/**
 * @Author LX
 * @Date 2020/7/29 21:42
 * @Description ������������¥�ݡ���Ҫ n ������ܵ���¥����
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 * ע�⣺���� n ��һ����������
 * ���룺 3
 * ����� 3
 * ���ͣ� �����ַ�����������¥����
 * 1.  1 �� + 1 �� + 1 ��
 * 2.  1 �� + 2 ��
 * 3.  2 �� + 1 ��
 * ����˼·����n��̨��ֻ�ܴӵ�n-1����n-2������������n-1��̨�׵��߷� + ��n-2��̨�׵��߷� = ����n��̨�׵��߷����Ѿ�֪���˵�1���͵�2��̨�׵��߷���һ·����ȥ����
 */
public class LeetCode70 {

    public static void main(String[] args) {
        System.out.println(new LeetCode70().climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2;
        int tmp;
        for (int i = 3; i <= n; i++) {
            tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }

}
