package math;

/**
 * @Author LX
 * @Date 2020/10/14 20:45
 * @Description
 * 쳲���������ͨ����?F(n) ��ʾ���γɵ����г�Ϊ쳲��������С���������?0 �� 1 ��ʼ�������ÿһ�����ֶ���ǰ���������ֵĺ͡�Ҳ���ǣ�
 *
 * F(0) = 0,? ?F(1)?= 1
 * F(N) = F(N - 1) + F(N - 2), ���� N > 1.
 * ����?N������?F(N)��
 */
public class LeetCode509 {

    public int fib(int N) {
        if(N==1||N==0){
            return N;
        }
        return fib(N-1)+fib(N-2);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode509().fib(4));
    }

}
